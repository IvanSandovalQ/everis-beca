package com.everis.school.rentacar.service;

import com.everis.school.rentacar.entity.VehiculoEntity;
import com.everis.school.rentacar.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository repository;

    @Override
    public VehiculoEntity buscarPorPatente(String patente) {
        return this.repository.findByPatente(patente).get();
    }

    @Override
    public VehiculoEntity buscarPorNumeroMotor(String numeroMotor) {
        return this.repository.findByNumeroMotor(numeroMotor).get();
    }

    @Override
    public List<VehiculoEntity> buscarTodos() {
        return this.repository.findAll();
    }

    @Override
    public List<VehiculoEntity> buscarPorFabricante(String fabricante) {
        return this.repository.queryFindByFabricante(fabricante);
    }

    @Override
    public List<VehiculoEntity> buscarPorModelo(String modelo) {
        return this.repository.queryFindByModelo(modelo);
    }

    @Override
    public void guardar(VehiculoEntity vehiculo) {
        this.repository.save(vehiculo);
    }

    @Override
    public void eliminar(String id) {
        this.repository.deleteById(id);
    }
}
