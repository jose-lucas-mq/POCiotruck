package com.br.iotruck.pociotrucmicroservices.controller;

import com.br.iotruck.pociotrucmicroservices.entity.SecurityAnalyst;
import com.br.iotruck.pociotrucmicroservices.repository.ISecurityAnalystRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/securityanalyst")
public class SecurityAnalystController {

    @Autowired
    private ISecurityAnalystRepository repository;

    @GetMapping("/{id}")
    public SecurityAnalyst getById(@PathVariable int id) {

        Optional<SecurityAnalyst> securityanalyst = repository.findById(id);

        return securityanalyst.orElse(null);
    }

    @GetMapping
    public Iterable<SecurityAnalyst> getAll() {

        return repository.findAll();

    }

    @PostMapping
    public String create(@RequestBody SecurityAnalyst securityAnalyst) {

        repository.save(securityAnalyst);
        return "Analista Criado com sucesso";

    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody SecurityAnalyst securityAnalyst) {

        if (repository.existsById(id)) {
            securityAnalyst.setId(id);
            repository.save(securityAnalyst);
            return "Analista Atualizado com sucesso";
        } else {
            return "Treinador não encontrado";
        }
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Analista Removido com sucesso";
        } else {
            return "Analista Não encontrado";
        }
    }


}
