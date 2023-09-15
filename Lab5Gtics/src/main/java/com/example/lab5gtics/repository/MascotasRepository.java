package com.example.lab5gtics.repository;

import com.example.lab5gtics.entity.Mascotas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotasRepository extends JpaRepository<Mascotas, Integer> {
}
