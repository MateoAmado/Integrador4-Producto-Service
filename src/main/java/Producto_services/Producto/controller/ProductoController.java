package Producto_services.Producto.controller;


import Producto_services.Producto.DTO.ProductoDTO;
import Producto_services.Producto.model.Producto;
import Producto_services.Producto.services.ApiService;
import Producto_services.Producto.services.ProductoServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@Tag(name = "Productos", description = "Operaciones relacionadas con los productos")
public class ProductoController {

    @Autowired
    private ProductoServices productoServices;

    @Autowired
    private ApiService apiService;

    @Operation(summary = "Obtener todos los productos", description = "Devuelve una lista de todos los prodcutos registrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de productos obtenida con éxito"),
            @ApiResponse(responseCode = "404", description = "Se ha hecho una mala Request")
    })
    @GetMapping
    public ResponseEntity<List<ProductoDTO>> getProductos(){
        List<ProductoDTO> productos=productoServices.getProductos();
        if(productos==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @Operation(summary = "Obtener un producto", description = "Devuelve un producto según su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto obtenido con éxito"),
            @ApiResponse(responseCode = "404", description = "No existe un producto con la ID proporcionada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable("id") Long id){
        Producto p=productoServices.getById(id);
        if(p!=null){
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        return new ResponseEntity<>(p, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Obtener producto más vendido", description = "Devuelve el producto más vendido entre todos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto obtenido con éxito"),
            @ApiResponse(responseCode = "404", description = "No existe un producto que sea más vendido")
    })
    @GetMapping("/productoMasVendido")
    public ResponseEntity<Producto> productoMasVendido(){
        Producto p=productoServices.productoMasVendido();
        if(p!=null){
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        return new ResponseEntity<>(p, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Agregar un nuevo producto", description = "Agrega un nuevo producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Producto agregado con éxito"),
            @ApiResponse(responseCode = "404", description = "No se logró agregar el producto")
    })
    @PostMapping
    public ResponseEntity<Producto> addProducto(@RequestBody Producto producto){
        Producto p=productoServices.save(producto);
        if(p!=null){
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Modificar información del producto ", description = "Modifica información sobre un producto ya existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto modificado con éxito"),
            @ApiResponse(responseCode = "404", description = "No existe un producto que quiere modificarse")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto producto){
        Producto p=productoServices.updateProducto(id, producto);
        if(p!=null){
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @Operation(summary = "Elimina un producto", description = "Elimina un producto existente por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto eliminado con éxito"),
            @ApiResponse(responseCode = "404", description = "No existe un producto con ese ID")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable Long id){
        Producto p=productoServices.deleteProducto(id);
        if(p!=null){
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
