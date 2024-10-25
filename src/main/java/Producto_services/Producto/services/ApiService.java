package Producto_services.Producto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ApiService {
    // Reemplaza con la URL de tu API

    @Value("http://localhost:8080")
    private String base_url;

    @Autowired
    private RestTemplate rest_template;

    public ResponseEntity<String> get() {
        return this.rest_template.getForEntity(this.base_url, String.class);
    }


    public void delete(Long id) {
        this.rest_template.delete(this.base_url + "/" + id);
    }

}
