package upn.pe.Chacombo.Funcionario;

import java.util.List;
import java.util.Optional;

public interface IFuncionarioService {
    public List<Funcionario> Listar();
    public Optional<Funcionario> ConsultarId(int id);
    public void Guardar(Funcionario f);
    public void Eliminar(int id);
    public List<Funcionario> Buscar(String dato);
    public List<Funcionario> OrdenAscendente();
    public List<Funcionario> OrdenDescendente();
}
