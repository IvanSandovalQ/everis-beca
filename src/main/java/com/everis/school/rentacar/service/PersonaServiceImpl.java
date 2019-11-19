package com.everis.school.rentacar.service;

import com.everis.school.rentacar.entity.PersonaEntity;
import com.everis.school.rentacar.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository repository;

    @Override
    public PersonaEntity buscarPersonaPorRut(String rut) {
        return this.repository.findOneByRut(rut).get();
    }

    @Override
    public List<PersonaEntity> buscarTodos() {
        return this.repository.findAll();
    }

    @Override
    public List<PersonaEntity> buscarEjecutivos() {
        return this.repository.findByTipo("Ejecutivo").get();
    }

    @Override
    public List<PersonaEntity> buscarClientes() {
        return this.repository.findByTipo("Cliente").get();
    }

    @Override
    public void guardar(PersonaEntity persona) {
        this.repository.save(persona);
    }

    @Override
    public void eliminar(String id) {
        this.repository.deleteById(id);
    }
}
