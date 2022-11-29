package upn.pe.Chacombo.Venta;

import java.util.List;
import java.util.Optional;

public interface IVentaService {

    public List<Venta> Listar();
    public Optional<Venta> ConsultarId(int id);
    public void Guardar(Venta p);
    public void Eliminar(int id);
    public int IdMaxVenta();
    public List<Venta> VentasXCliente(int id);
    public List<Venta> VentasXPago(int id);
    
}
