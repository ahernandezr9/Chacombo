package upn.pe.Chacombo.Entrega;

import java.util.List;
import java.util.Optional;

public interface IEntregaService {
    public List<Entrega> Listar();
    public Optional<Entrega> ConsultarId(int id);
    public void Guardar(Entrega e);
    public void Eliminar(int id);
}
