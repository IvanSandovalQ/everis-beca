package com.everis.school.rentacar.service;

import com.everis.school.rentacar.entity.ContratoEntity;
import com.everis.school.rentacar.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratoServiceImpl implements ContratoService {

    @Autowired
    private ContratoRepository repository;

    @Override
    public ContratoEntity buscarPorFolio(String folio) {
        return this.repository.findByFolio(folio).get();
    }

    @Override
    public List<ContratoEntity> buscarTodos() {
        return this.repository.findAll();
    }

    @Override
    public void guardar(ContratoEntity contrato) {
        this.repository.save(contrato);
    }

    @Override
    public void eliminar(String id) {
        this.repository.deleteById(id);
    }

}
