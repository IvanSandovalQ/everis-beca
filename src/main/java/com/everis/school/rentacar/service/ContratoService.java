package com.everis.school.rentacar.service;

import com.everis.school.rentacar.entity.ContratoEntity;
import com.everis.school.rentacar.entity.PersonaEntity;

import java.util.List;

public interface ContratoService {

    ContratoEntity buscarPorFolio(String folio);
    List<ContratoEntity> buscarTodos();
    void guardar(ContratoEntity contrato);
    void eliminar(String id);

}
