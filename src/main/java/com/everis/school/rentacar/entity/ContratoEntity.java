package com.everis.school.rentacar.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Document(collection = "Contrato")
public class ContratoEntity implements Serializable {

    private static final long serialVersionUID = 7310294605102037402L;

    @Id
    @NotNull
    private String id;

    private String folio;
    private String tipo;
    private PersonaEntity cliente;
    private PersonaEntity ejecutivo;
    private VehiculoEntity vehiculo;
    private LocalDate fechaInicio;
    private LocalDate fechaTermino;
    private LocalDate fechaContrato;
    private String medioPago;
    private int monto;
    private boolean confirmar;

}
