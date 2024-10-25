package Producto_services.Producto.controller;


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
    public ResponseEntity<List<Producto>> getProductos(){
        List<Producto> productos=productoServices.getProductos();
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

    @PostMapping
    public ResponseEntity<Producto> addProducto(@RequestBody Producto producto){
        Producto p=productoServices.save(producto);
        if(p!=null){
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/registro")
    public ResponseEntity<UsuarioDTO> registro(@RequestBody UsuarioDTO usuarioDTO){
        ResponseEntity<UsuarioDTO> usuario=apiService.registro(usuarioDTO);
        return new ResponseEntity<>(usuario.getBody(), usuario.getStatusCode());
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
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
