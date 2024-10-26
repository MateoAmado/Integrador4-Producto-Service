package Producto_services.Producto.services;

import Producto_services.Producto.DTO.ProductoDTO;
import Producto_services.Producto.model.Producto;
import Producto_services.Producto.repository.ProductoRepository;
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

    @SneakyThrows //Anotación de Lombok para manejar excepciones (no usar para excepciones que se deben manejar explicitamente)
    public Producto save(Producto producto) {
        Long valorDolar= apiService.valorDolarOficial();
        float nuevoValor= producto.getValor()+valorDolar;
        producto.setValor(nuevoValor);
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
                System.out.println(p.getValor());
                System.out.println(producto.getValor());
                if(producto.getValor()!=p.getValor()) {
                    Long valorDolar= apiService.valorDolarOficial();
                    float nuevoValor= producto.getValor()+valorDolar;
                    p.setValor(nuevoValor);
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

    public Producto productoMasVendido() {
        Long id= apiService.productoMasVendido();
        Producto producto=productoRepository.getById(id);
        return producto;
    }
}
