package com.everis.school.rentacar.repository;

import com.everis.school.rentacar.entity.ContratoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface ContratoRepository extends MongoRepository<ContratoEntity, Serializable> {

    Optional<ContratoEntity> findByFolio(String folio);

}
