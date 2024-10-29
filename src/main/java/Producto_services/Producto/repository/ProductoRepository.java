package Producto_services.Producto.repository;

import Producto_services.Producto.DTO.ProductoDTO;
import Producto_services.Producto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT new Producto_services.Producto.DTO.ProductoDTO(p.id,p.nombre,p.cantidad_stock, p.valorEnPesos, p.valorEnDolares) FROM Producto p")
    List<ProductoDTO> getProductos();

    @Query("SELECT p FROM Producto p WHERE p.id=:id")
    Producto getById(Long id);
}
