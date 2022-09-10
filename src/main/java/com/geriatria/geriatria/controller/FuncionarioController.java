package com.geriatria.geriatria.controller;

import com.geriatria.geriatria.model.entities.Funcionario;
import com.geriatria.geriatria.model.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {

    private FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario salvarFuncionario(@RequestBody Funcionario funcionario){
        return  funcionarioRepository.save(funcionario);
    }

    @GetMapping("{id}")
    public Funcionario buscarFunPorId(@PathVariable Integer id){
        return  funcionarioRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarFunPorId(@PathVariable Integer id){
          funcionarioRepository.deleteById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void atualizarFunPorId(@PathVariable Integer id, @RequestBody Funcionario funcionarioAtualizar) {
            funcionarioRepository
                    .findById(id)
                    .map( funcionario -> {
                        funcionarioAtualizar.setId(funcionario.getId());
                        return  funcionarioRepository.save(funcionarioAtualizar);
                    })
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

}
