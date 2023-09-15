package com.example.lab5gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersona")
    private int personaId;
    @Column(name = "nombre", length = 45)
    private String nombrePersona;
    @Column(name = "dni", length = 45)
    private String dniPersona;
    @Column(name = "celular", length = 45)
    private String celularPersona;
    @Column(name = "tipo_persona", length = 45)
    private String tipoPersona;
}
