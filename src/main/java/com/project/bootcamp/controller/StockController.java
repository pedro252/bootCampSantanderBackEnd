package com.project.bootcamp.controller;

import com.project.bootcamp.model.dto.StockDTO;
import com.project.bootcamp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired //gerenciar classes
    private StockService service;

    //como vai enviar os dados, para formato json
    //post salva
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto) {

        return ResponseEntity.ok(service.save(dto));

    }

    //put alteração
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@RequestBody StockDTO dto) {
        return ResponseEntity.ok(service.update(dto));

    }

    //pegar informações
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findALL() {

        return ResponseEntity.ok(service.findAll());

    }

    //pegar informações pelo id
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findByID(@PathVariable long id) {
        return ResponseEntity.ok(service.findById(id));

    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping(value = "/today", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findByToday() {
        return ResponseEntity.ok(service.findByToday());
    }
}