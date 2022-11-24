package upn.pe.Chacombo.Funcionario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFuncionario extends CrudRepository<Funcionario,Integer>{
    
}
