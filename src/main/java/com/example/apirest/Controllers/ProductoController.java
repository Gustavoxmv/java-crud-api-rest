package com.example.apirest.Controllers;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.apirest.Entities.Producto;
import com.example.apirest.Repositories.ProductoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;







@RestController
@RequestMapping("/productos")
public class ProductoController {


    @Autowired
    private ProductoRepository productoRepository;

@GetMapping
public List<Producto> getProducto() {
    return productoRepository.findAll();
}

@GetMapping("./{id}")
public Producto getProductobyId(@PathVariable Long id) {
    return productoRepository.findById(id).orElseThrow(()->new RuntimeException("No se encontro el Id"));

}

@PostMapping
public Producto postProducto(@RequestBody Producto producto) {
    //TODO: process POST request
    
    return productoRepository.save(producto);
}

@PutMapping("./{id}")
public Producto putProductobyId(@PathVariable Long id, @RequestBody Producto detalleproducto) {
    
  
    Producto producto= productoRepository.findById(id).orElseThrow(()-> new RuntimeException("Id no encontrado") );
    producto.setNombre(detalleproducto.getNombre());
    producto.setPrecio(detalleproducto.getPrecio());

   return productoRepository.save(producto);

}


@DeleteMapping("./{id}")
public String deleteProductobyId(@PathVariable Long id){

    Producto producto = productoRepository.findById(id).orElseThrow(()->new RuntimeException("Id no encontrado"));

    productoRepository.delete(producto);

    return "Producto Borrado";

}



}