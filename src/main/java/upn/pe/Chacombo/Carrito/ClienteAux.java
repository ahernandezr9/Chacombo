package upn.pe.Chacombo.Carrito;

import lombok.Data;

@Data
public class ClienteAux {
    private String Nombres;
    private String Correo;
    private String Telefono;
    private String Direccion;
    private int IdPago;
    private int IdEntrega;
    
    private float Total_Pago;
}
