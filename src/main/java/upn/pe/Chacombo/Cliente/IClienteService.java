package upn.pe.Chacombo.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    public List<Cliente> Listar();
    public Optional<Cliente> ConsultarId(int id);
    public void Guardar(Cliente c);
    public void Eliminar(int id);
    public int IdMaxCliente();
    public List<Cliente> Buscar(String dato);
    public List<Cliente> OrdenAscendenteCli();
    public List<Cliente> OrdenDescendenteCli();
}
