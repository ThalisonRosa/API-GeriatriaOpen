package com.geriatria.geriatria.controller;


import com.geriatria.geriatria.model.entities.Casa;
import com.geriatria.geriatria.model.repository.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/casa")
public class CasaController {

    private CasaRepository casaRepositor;

    @Autowired
    public CasaController(CasaRepository casaRepositor) {
        this.casaRepositor = casaRepositor;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Casa salvarCasa(@RequestBody Casa casa){
        return  casaRepositor.save(casa);
    }

    @GetMapping("{id}")
    public Casa buscarCasaPorId(@PathVariable Integer id){
        return casaRepositor
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCasaPorId(@PathVariable Integer id){
        casaRepositor
                .findById(id)
                .map(casa -> {
                    casaRepositor.deleteById(id);
                    return Void.TYPE;
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND) );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void atualizarCasaPorId(@PathVariable Integer id , @RequestBody Casa atualizarCasa){
        casaRepositor
                .findById(id)
                .map(casa -> {
                    atualizarCasa.setId(casa.getId());
                    return casaRepositor.save(atualizarCasa);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

}
