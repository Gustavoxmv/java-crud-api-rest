package com.example.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apirest.Entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
