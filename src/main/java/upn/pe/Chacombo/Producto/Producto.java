package upn.pe.Chacombo.Producto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Autoincremental
    private int IdProducto;
    private String Nombre;
    private String Descripcion;
    private float Precio;
    private String Tipo;
    private String imagen;
}
