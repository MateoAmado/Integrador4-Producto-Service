package Producto_services.Producto.services;

import Producto_services.Producto.DTO.ProductoDTO;
import Producto_services.Producto.DTO.UsuarioDTO;
import Producto_services.Producto.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ApiService {
    // Reemplaza con la URL de tu API

    @Autowired
    private ProductoServices productoServices;

    @Value("http://localhost:8090/auth")
    private String base_url;

    @Value("http://localhost:8010/clientes")
    private String APICliente;

    @Value("http://localhost:8026")
    private String APICompras;

    @Autowired
    private RestTemplate rest_template;

    public ResponseEntity<UsuarioDTO> registro(UsuarioDTO usuarioDTO){
        ResponseEntity<UsuarioDTO> response = rest_template.postForEntity(base_url + "/registro", usuarioDTO, UsuarioDTO.class);

        return response;
    }

    public Producto productoMasVendido(){
        ResponseEntity<Long> response = rest_template.getForEntity(APICompras+"/productoMasVendido", Long.class);
        Long idUser= response.getBody();
        Producto producto=productoServices.getById(idUser);
        return producto;
    }
    public ResponseEntity<String> get() {
        return this.rest_template.getForEntity(this.base_url, String.class);
    }


    public void delete(Long id) {
        this.rest_template.delete(this.base_url + "/" + id);
    }

    public String login(UsuarioDTO usuarioDTO) {
        String response = rest_template.postForObject(base_url + "/login", usuarioDTO, String.class);
        return response;
    }
}
