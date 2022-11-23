package upn.pe.Chacombo.DetalleVenta;

import upn.pe.Chacombo.Venta.Venta;
import upn.pe.Chacombo.Producto.Producto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremental
    private int id;
    
    @JoinColumn(name = "IdVenta", nullable = false)
    @ManyToOne
    private Venta venta;
    
    @JoinColumn(name = "IdProducto", nullable = false)
    @ManyToOne
    private Producto prd;
    
    private int Cantidad; 
}
