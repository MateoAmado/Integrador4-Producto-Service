package Producto_services.Producto.controller;

import Producto_services.Producto.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest_template")
public class RestTemplateController {

    @Autowired
    private ApiService api_service;

    @GetMapping
    public ResponseEntity<String> get() {
        return this.api_service.get();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.api_service.delete(id);
    }
}
