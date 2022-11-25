package upn.pe.Chacombo.Usuario;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{
    @Autowired
    private IUsuario data;
    
    @Override
    public int LoginUsu(String usu, String cla) {
        return data.buscarUsuario(usu, cla);
    }

    @Override
    public List<Usuario> Listar() {
        return (List<Usuario>) data.findAll();
    }

    @Override
    public Optional<Usuario> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Usuario u) {
        data.save(u);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Usuario> Buscar(String dato) {
         return data.buscarPorTodo(dato);
    }

    @Override
    public List<Usuario> OrdenAscendente() {
        return data.OrderAsc();
    }

    @Override
    public List<Usuario> OrdenDescendente() {
        return data.OrderDesc();
    }
}
