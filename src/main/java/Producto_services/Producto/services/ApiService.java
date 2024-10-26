package Producto_services.Producto.services;

import Producto_services.Producto.model.Producto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ApiService {

    @Value("http://localhost:8090/auth")
    private String base_url;

    @Value("http://localhost:8010/clientes")
    private String APICliente;

    @Value("http://localhost:8026")
    private String APICompras;

    @Value("https://dolarapi.com/v1/dolares/oficial")
    private String APIDolar;

    @Autowired
    private RestTemplate rest_template;


    public Long valorDolarOficial() throws JsonProcessingException {
        String jsonResponse = rest_template.getForObject(APIDolar, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonResponse);
        Long response = rootNode.path("venta").asLong();
        return response;
    }

    public Long productoMasVendido(){
        ResponseEntity<Long> response = rest_template.getForEntity(APICompras+"/productoMasVendido", Long.class);
        Long idUser= response.getBody();
        return idUser;
    }

}
