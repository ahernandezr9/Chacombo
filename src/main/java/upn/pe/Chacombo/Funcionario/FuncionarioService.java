package upn.pe.Chacombo.Funcionario;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FuncionarioService implements IFuncionarioService {
    @Autowired
    private IFuncionario data;

    @Override
    public List<Funcionario> Listar() {
        return (List<Funcionario>) data.findAll();
    }

    @Override
    public Optional<Funcionario> ConsultarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Funcionario f) {
        data.save(f);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }
    
    @Override
    public List<Funcionario> Buscar(String dato) {
        
        return data.buscarPorTodo(dato);
    }
    
    @Override
    public List<Funcionario> OrdenAscendente() {
        return data.OrderAsc();
    }

    @Override
    public List<Funcionario> OrdenDescendente() {
        return data.OrderDesc();
    }

    
    
}
