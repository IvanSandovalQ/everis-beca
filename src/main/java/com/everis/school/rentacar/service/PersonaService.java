package com.everis.school.rentacar.service;

import com.everis.school.rentacar.entity.PersonaEntity;

import java.util.List;

public interface PersonaService {

    PersonaEntity buscarPersonaPorRut(String rut);
    List<PersonaEntity> buscarTodos();
    List<PersonaEntity> buscarEjecutivos();
    List<PersonaEntity> buscarClientes();
    void guardar(PersonaEntity persona);
    void eliminar(String id);

}
