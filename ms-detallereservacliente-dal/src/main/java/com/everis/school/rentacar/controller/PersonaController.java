package com.everis.school.rentacar.controller;

import com.everis.school.rentacar.entity.PersonaEntity;
import com.everis.school.rentacar.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/cliente")
@CrossOrigin(value = {})
public class PersonaController {

    @Autowired
    private PersonaService service;

    @GetMapping("/rut")
    public ResponseEntity<?> obtenerPersonaPorRut(@RequestParam String rut) {
        ResponseEntity<?> response;
        try {
            PersonaEntity persona = this.service.buscarPersonaPorRut(rut);
            response = new ResponseEntity<>(persona, HttpStatus.OK);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            response = new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("/clientes")
    public ResponseEntity<?> obtenerClientes() {
        ResponseEntity<?> response;
        try {
            List<PersonaEntity> clientes = this.service.buscarClientes();
            response = new ResponseEntity<>(clientes, HttpStatus.OK);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            response = new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("/ejecutivos")
    public ResponseEntity<?> obtenerEjecutivos() {
        ResponseEntity<?> response;
        try {
            List<PersonaEntity> ejecutivos = this.service.buscarEjecutivos();
            response = new ResponseEntity<>(ejecutivos, HttpStatus.OK);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            response = new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<?> obtenerPersonas() {
        ResponseEntity<?> response;
        try {
            List<PersonaEntity> personas = this.service.buscarTodos();
            response = new ResponseEntity<>(personas, HttpStatus.OK);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            response = new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @PostMapping
    public ResponseEntity<?> agregarPersonas(@RequestBody PersonaEntity persona) {
        ResponseEntity<?> response;
        try {
            this.service.guardar(persona);
            response = new ResponseEntity<>(persona.getId(), HttpStatus.CREATED);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            response = new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @DeleteMapping
    public ResponseEntity<?> eliminarPersonas(@RequestParam String id) {
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
