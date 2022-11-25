package upn.pe.Chacombo.Cliente;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{
    @Autowired
    private ICliente data;
    
    @Override
    public List<Cliente> Listar() {
        return (List<Cliente>) data.findAll();
    }

    @Override
    public Optional<Cliente> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Cliente c) {
        data.save(c);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }
    
    @Override
    public int IdMaxCliente() {
        return data.BuscarIdMax();
    }
    
    @Override
    public List<Cliente> Buscar(String dato) {

        return data.buscarPorTodo(dato);
    }
    
    @Override
    public List<Cliente> OrdenAscendenteCli() {
        return data.OrderAscCli();

    }

    @Override
    public List<Cliente> OrdenDescendenteCli() {
        return data.OrderDescCli();

    }

    
    
}
