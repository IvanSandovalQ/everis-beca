package com.everis.school.rentacar.repository;

import com.everis.school.rentacar.entity.VehiculoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public interface VehiculoRepository extends MongoRepository<VehiculoEntity, Serializable> {

    Optional<VehiculoEntity> findByPatente(String patente);

    Optional<VehiculoEntity> findByNumeroMotor(String patente);

    @Query(value = "SELECT vehiculo FROM VehiculoEntity vehiculo WHERE vehiculo.modelo = ?1 ")
    List<VehiculoEntity> queryFindByModelo(String modelo);

    @Query( nativeQuery = true,
            value = "db.vehiculo.find( { fabricante: ?1 } ) ")
    List<VehiculoEntity> queryFindByFabricante(String fabricante);

}
