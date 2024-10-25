package Producto_services.Producto.controller;


import Producto_services.Producto.DTO.ProductoDTO;
import Producto_services.Producto.DTO.UsuarioDTO;
import Producto_services.Producto.model.Producto;
import Producto_services.Producto.services.ApiService;
import Producto_services.Producto.services.ProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoServices productoServices;

    @Autowired
    private ApiService apiService;

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> getProductos(){
        List<ProductoDTO> productos=productoServices.getProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable("id") Long id){
        Producto p=productoServices.getById(id);
        if(p!=null){
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        return new ResponseEntity<>(p, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/productoMasVendido")
    public ResponseEntity<Producto> productoMasVendido(){
        Producto p=apiService.productoMasVendido();
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Producto> addProducto(@RequestBody Producto producto){
        Producto p=productoServices.save(producto);
        if(p!=null){
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto producto){
        Producto p=productoServices.updateProducto(id, producto);
        if(p!=null){
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable Long id){
        Producto p=productoServices.deleteProducto(id);
        if(p!=null){
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
