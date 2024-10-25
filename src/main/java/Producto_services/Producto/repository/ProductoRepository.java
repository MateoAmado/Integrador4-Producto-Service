package Producto_services.Producto.repository;

import Producto_services.Producto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p")
    List<Producto> getProductos();

    @Query("SELECT p FROM Producto p WHERE p.id=:id")
    Producto getById(Long id);
}
