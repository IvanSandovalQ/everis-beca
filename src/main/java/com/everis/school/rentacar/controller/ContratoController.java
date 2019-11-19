package com.everis.school.rentacar.controller;

import com.everis.school.rentacar.entity.ContratoEntity;
import com.everis.school.rentacar.entity.PersonaEntity;
import com.everis.school.rentacar.service.ContratoService;
import com.everis.school.rentacar.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/contrato")
@CrossOrigin(value = {})
public class ContratoController {

    @Autowired
    private ContratoService service;

    @GetMapping("/rut")
    public ResponseEntity<?> obtenerContratoPorFolio(@RequestParam String folio) {
        ResponseEntity<?> response;
        try {
            ContratoEntity contrato = this.service.buscarPorFolio(folio);
            response = new ResponseEntity<>(contrato, HttpStatus.OK);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            response = new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<?> obtenerContratos() {
        ResponseEntity<?> response;
        try {
            List<ContratoEntity> contratos = this.service.buscarTodos();
            response = new ResponseEntity<>(contratos, HttpStatus.OK);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            response = new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @PostMapping
    public ResponseEntity<?> agregarContrato(@RequestBody ContratoEntity contrato) {
        ResponseEntity<?> response;
        try {
            this.service.guardar(contrato);
            response = new ResponseEntity<>(contrato.getId(), HttpStatus.CREATED);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            response = new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @DeleteMapping
    public ResponseEntity<?> eliminarContrato(@RequestParam String id) {
        ResponseEntity<?> response;
        try {
           this.service.eliminar(id);
            response = new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            response = new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

}
