package com.example.lab5gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Viajes")
public class Viajes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idViajes")
    private int idViaje;

    @Column(name = "punto_rocojo", length = 45)
    private String puntoRecojo;
    @Column(name = "cant_personas", length = 45)
    private String cantPersonas;
    @Column(name = "cant_perros", length = 45)
    private String cantPerros;

    @ManyToOne
    @JoinColumn(name = "Persona_idPersona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "Lugares_idLugares")
    private Lugares lugares;
}
