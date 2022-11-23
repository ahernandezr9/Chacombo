package upn.pe.Chacombo.Pago;

import java.util.List;
import java.util.Optional;

public interface IPagoService {
    public List<Pago> Listar();
    public Optional<Pago> ConsultarId(int id);
    public void Guardar(Pago p);
    public void Eliminar(int id);
}
