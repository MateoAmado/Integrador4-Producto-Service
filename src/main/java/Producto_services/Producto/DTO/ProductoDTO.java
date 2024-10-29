package Producto_services.Producto.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDTO {

    private Long id;
    private String nombre;
    private int cantidad_stock;
    private float valorEnPesos;
    private float valorEnDolares;


    public ProductoDTO(Long id, String nombre, int cantidad_stock, float valorP, float valorD) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad_stock = cantidad_stock;
        this.valorEnPesos = valorP;
        this.valorEnDolares = valorD;
    }
}
