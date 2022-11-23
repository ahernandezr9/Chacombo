package upn.pe.Chacombo.Venta;

import upn.pe.Chacombo.Cliente.Cliente;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import upn.pe.Chacombo.Entrega.Entrega;
import upn.pe.Chacombo.Funcionario.Funcionario;
import upn.pe.Chacombo.Pago.Pago;

@Data
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremental
    private int IdVenta;
    
    @JoinColumn(name = "IdCliente", nullable = false)
    @ManyToOne
    private Cliente cli;
    
    private float Total;
    private Date fecha;
    
    @JoinColumn(name = "IdPago", nullable = false)
    @ManyToOne
    private Pago pago;
    
    @JoinColumn(name = "IdServicio", nullable = false)
    @ManyToOne
    private Entrega servicio;
    
    @JoinColumn(name = "IdFuncionario", nullable = false)
    @ManyToOne
    private Funcionario func;    
}
