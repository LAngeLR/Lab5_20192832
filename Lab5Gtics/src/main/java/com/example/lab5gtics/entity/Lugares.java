package com.example.lab5gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="Lugares")
public class Lugares {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLugares")
    private int idLugar;

    @Column(name = "nombre_lugar", length = 45)
    private String nombreLugar;
    @Column(name = "descrip_lugar", length = 45)
    private String descripLugar;
    @Column(name = "fecha_lugar")
    private Date fechaLugar;
}
