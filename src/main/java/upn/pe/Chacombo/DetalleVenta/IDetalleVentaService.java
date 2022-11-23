package upn.pe.Chacombo.DetalleVenta;

import java.util.List;
import java.util.Optional;

public interface IDetalleVentaService {
    public List<DetalleVenta> Listar();
    public Optional<DetalleVenta> ConsultarId(int id);
    public void Guardar(DetalleVenta dv);
    public void Eliminar(int id);
}
