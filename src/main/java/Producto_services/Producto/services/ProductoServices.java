package Producto_services.Producto.services;

import Producto_services.Producto.model.Producto;
import Producto_services.Producto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServices {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getProductos() {
        return productoRepository.getProductos();
    }

    public Producto save(Producto producto) {
        Producto p = productoRepository.save(producto);
        if(p!=null) {
            return p;
        }
        return null;
    }

    public Producto updateProducto(Long id, Producto producto) {
        if(id==producto.getId()) {
            Producto p=productoRepository.getById(id);
            if(p!=null) {
                p.setId(producto.getId());
                p.setNombre(producto.getNombre());
                p.setValor(producto.getValor());
                p.setCantidad_stock(producto.getCantidad_stock());
                return productoRepository.save(p);
            }
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
}
