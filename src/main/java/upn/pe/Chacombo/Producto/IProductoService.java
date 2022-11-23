package upn.pe.Chacombo.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    public List<Producto> Listar();
    public Optional<Producto> ConsultarId(int id);
    public void Guardar(Producto p);
    public void Eliminar(int id);
}
