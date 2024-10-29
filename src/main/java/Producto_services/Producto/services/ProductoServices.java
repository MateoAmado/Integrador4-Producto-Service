package Producto_services.Producto.services;

import Producto_services.Producto.DTO.ProductoDTO;
import Producto_services.Producto.model.Producto;
import Producto_services.Producto.repository.ProductoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServices {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ApiService apiService;

    public List<ProductoDTO> getProductos() {
        return productoRepository.getProductos();
    }

    @SneakyThrows
    public Producto save(Producto producto) {
        Long valorDolar= apiService.valorDolarOficial();
        float nuevoValor= producto.getValorEnDolares()*valorDolar;
        System.out.println(producto.getValorEnDolares());
        producto.setValorEnPesos(nuevoValor);
        Producto p = productoRepository.save(producto);
        if(p!=null) {
            return p;
        }
        return null;
    }

    @SneakyThrows
    public Producto updateProducto(Long id, Producto producto) {
            Producto p=productoRepository.getById(id);
            if(p!=null) {
                p.setNombre(producto.getNombre());
                if(producto.getValorEnDolares()!=p.getValorEnDolares()) {
                    Long valorDolar= apiService.valorDolarOficial();
                    float nuevoValor= producto.getValorEnDolares()*valorDolar;
                    p.setValorEnPesos(nuevoValor);
                }
                p.setCantidad_stock(producto.getCantidad_stock());
                return productoRepository.save(p);
            }
        return null;
    }

    public Producto deleteProducto(Long id) {
        Producto producto = productoRepository.getById(id);
        if(producto!=null) {
            productoRepository.delete(producto);
            return producto;
        }
        return null;
    }

    public Producto getById(Long id) {
        return productoRepository.getById(id);
    }

    @SneakyThrows
    public List<ProductoDTO> actualizarPrecio() {
        Long valorDolar= apiService.valorDolarOficial();
        List<ProductoDTO> productos=productoRepository.getProductos();
        for(ProductoDTO productoDTO:productos) {
            float precioDolar = productoDTO.getValorEnDolares();
            float nuevoValor = precioDolar * valorDolar;
            productoDTO.setValorEnPesos(nuevoValor);
            Producto p=new Producto(productoDTO.getId(), productoDTO.getNombre(), productoDTO.getCantidad_stock(), productoDTO.getValorEnPesos(),productoDTO.getValorEnDolares());
            productoRepository.save(p);
        }
    return productos;
    }
}
