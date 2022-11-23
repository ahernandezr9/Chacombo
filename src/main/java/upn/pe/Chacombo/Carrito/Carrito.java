package upn.pe.Chacombo.Carrito;

import lombok.Data;

@Data
public class Carrito {
    private int IdProducto;
    private String Nombre;
    private float Precio;
    private int Cantidad;
    private float Total;
}
