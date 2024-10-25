package Producto_services.Producto.services;

import Producto_services.Producto.DTO.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ApiService {
    // Reemplaza con la URL de tu API

    @Value("http://localhost:8090/auth")
    private String base_url;

    @Autowired
    private RestTemplate rest_template;

    public ResponseEntity<UsuarioDTO> registro(UsuarioDTO usuarioDTO){
        ResponseEntity<UsuarioDTO> response = rest_template.postForEntity(base_url + "/registro", usuarioDTO, UsuarioDTO.class);
        return response;
    }

    public ResponseEntity<String> get() {
        return this.rest_template.getForEntity(this.base_url, String.class);
    }


    public void delete(Long id) {
        this.rest_template.delete(this.base_url + "/" + id);
    }

}
