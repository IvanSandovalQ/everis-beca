package com.everis.school.rentacar.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Document(collection = "Vehiculo")
public class VehiculoEntity implements Serializable {

    private static final long serialVersionUID = 4835788585782195715L;

    @Id
    @NotNull
    private String id;

    private String patente;
    private String modelo;
    private String color;
    private String tipo;
    private String fabricante;
    private String numeroMotor;
    private LocalDate fechaFabricacion;

}
