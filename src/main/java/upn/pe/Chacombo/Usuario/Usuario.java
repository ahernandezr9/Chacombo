package upn.pe.Chacombo.Usuario;

import upn.pe.Chacombo.Funcionario.Funcionario;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremental
    private int IdUsuario;
    
    @JoinColumn(name = "IdFuncionario", nullable = false)
    @ManyToOne
    private Funcionario func;
    
    private String Usuario;
    private String Clave;
}
