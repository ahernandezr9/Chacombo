package upn.pe.Chacombo.Cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremental
    private int IdCliente;
    private String Nombres;
    private String Correo;
    private String Telefono;
    private String Direccion;
}
