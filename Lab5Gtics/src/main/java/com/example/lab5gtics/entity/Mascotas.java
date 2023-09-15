package com.example.lab5gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Mascotas")
public class Mascotas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMascotas")
    private int mascotaId;
    @Column(name = "nombre_mascota", length = 45)
    private String nombreMascota;
    @Column(name = "genero", length = 45)
    private String generoMascota;
    @Column(name = "edad", length = 45)
    private String edadMascota;
    @Column(name = "fecha_nacimiento", length = 45)
    private String fechaNacimiento;
    @Column(name = "Vacunado", length = 45)
    private String vacunado;
    @Column(name = "Desparasitado", length = 45)
    private String desparasitado;

    @ManyToOne
    @JoinColumn(name = "Persona_idPersona")
    private Persona persona;
}
