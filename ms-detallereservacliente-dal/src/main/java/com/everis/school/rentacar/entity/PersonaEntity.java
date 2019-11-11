package com.everis.school.rentacar.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Document(collection = "Persona")
public class PersonaEntity implements Serializable {

    private static final long serialVersionUID = -3745608243007405409L;

    @Id
    @NotNull
    private String id;

    private String rut;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String sexo;
    private LocalDate fechaNacimiento;
    private String tipo;

}
