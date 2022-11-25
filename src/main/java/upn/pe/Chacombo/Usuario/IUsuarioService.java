package upn.pe.Chacombo.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    public int LoginUsu(String usu, String cla);
    public List<Usuario> Listar();
    public Optional<Usuario> ConsultarId(int id);
    public void Guardar(Usuario u);
    public void Eliminar(int id);
    public List<Usuario> Buscar(String dato);
    public List<Usuario> OrdenAscendente();
    public List<Usuario> OrdenDescendente();
}
