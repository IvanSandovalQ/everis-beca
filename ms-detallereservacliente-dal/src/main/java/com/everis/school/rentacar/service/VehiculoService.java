package com.everis.school.rentacar.service;

import com.everis.school.rentacar.entity.VehiculoEntity;

import java.util.List;

public interface VehiculoService {

    VehiculoEntity buscarPorPatente(String patente);
    VehiculoEntity buscarPorNumeroMotor(String numeroMotor);
    List<VehiculoEntity> buscarTodos();
    List<VehiculoEntity> buscarPorFabricante(String fabricante);
    List<VehiculoEntity> buscarPorModelo(String modelo);
    void guardar(VehiculoEntity vehiculo);
    void eliminar(String id);

}
