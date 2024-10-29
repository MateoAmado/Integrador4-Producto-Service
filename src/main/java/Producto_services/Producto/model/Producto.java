package Producto_services.Producto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity(name = "Producto")
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column
    private int cantidad_stock;

    @Column
    private float valorEnPesos;

    @Column
    private float valorEnDolares;


    public Producto() {}


    public Producto(Long id, String nombre, int cantidadStock, float valorEnPesos, float valorEnDolares) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad_stock = cantidadStock;
        this.valorEnPesos = valorEnPesos;
        this.valorEnDolares = valorEnDolares;
    }
}
