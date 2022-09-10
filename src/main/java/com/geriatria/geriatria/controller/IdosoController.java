package com.geriatria.geriatria.controller;

import com.geriatria.geriatria.model.entities.Idoso;
import com.geriatria.geriatria.model.repository.IdosoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.lang.module.ResolutionException;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/idoso")
public class IdosoController {

    private IdosoRepository repository;

    @Autowired
    public IdosoController(IdosoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Idoso salvarIdoso(@RequestBody Idoso idoso){
        return  repository.save(idoso);
    }


    @GetMapping("{id}")
    public Idoso buscarIdosoPorId(@PathVariable Integer id) {
        return  repository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarIdosoPorId(@PathVariable Integer id){
        repository
                .findById(id)
                .map(idoso -> {
                    repository.deleteById(id);
                    return Void.TYPE;
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarIdoso(@PathVariable Integer id , @RequestBody Idoso idosoAtualizar){
        repository
                .findById(id)
                .map(idoso -> {
                    idosoAtualizar.setId(idoso.getId());
                    return repository.save(idosoAtualizar);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
