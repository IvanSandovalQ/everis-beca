package com.everis.school.rentacar.controller;

import com.everis.school.rentacar.entity.VehiculoEntity;
import com.everis.school.rentacar.service.VehiculoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/vehiculo")
@CrossOrigin(value = {})
public class VehiculoController {

    @Autowired
    private VehiculoService service;

    @GetMapping("fabricante")
    public ResponseEntity<?> obtenerVehiculosPorFabricante(@RequestParam String fabricante) {
        ResponseEntity<?> response;
        try {
            List<VehiculoEntity> vehiculos = this.service.buscarPorFabricante(fabricante);
            response = new ResponseEntity<>(vehiculos, HttpStatus.OK);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            response = new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("modelo")
    public ResponseEntity<?> obtenerVehiculosPorModelo(@RequestParam String modelo) {
        ResponseEntity<?> response;
        try {
            List<VehiculoEntity> vehiculos = this.service.buscarPorModelo(modelo);
            response = new ResponseEntity<>(vehiculos, HttpStatus.OK);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            response = new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("patente")
    public ResponseEntity<?> obtenerVehiculoPorPatente(@RequestParam String patente) {
        ResponseEntity<?> response;
        try {
            VehiculoEntity vehiculo = this.service.buscarPorPatente(patente);
            response = new ResponseEntity<>(vehiculo, HttpStatus.OK);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            response = new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("numero-motor")
    public ResponseEntity<?> obtenerVehiculoPorNumeroMotor(@RequestParam String numeroMotor) {
        ResponseEntity<?> response;
        try {
            VehiculoEntity vehiculo = this.service.buscarPorNumeroMotor(numeroMotor);
            response = new ResponseEntity<>(vehiculo, HttpStatus.OK);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            response = new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<?> obtenerVehiculos() {
        ResponseEntity<?> response;
        try {
            List<VehiculoEntity> vehiculos = this.service.buscarTodos();
            response = new ResponseEntity<>(vehiculos, HttpStatus.OK);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            response = new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @PostMapping
    public ResponseEntity<?> agregarVehiculo(@RequestBody VehiculoEntity vehiculo) {
        ResponseEntity<?> response;
        try {
            this.service.guardar(vehiculo);
            response = new ResponseEntity<>(vehiculo.getId(), HttpStatus.CREATED);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            response = new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @DeleteMapping
    public ResponseEntity<?> eliminarVehiculo(@RequestParam String id) {
        ResponseEntity<?> response;
        try {
            this.service.eliminar(id);
            response = new ResponseEntity<>(HttpStatus.CREATED);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            response = new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

}
