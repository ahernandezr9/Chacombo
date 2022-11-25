package upn.pe.Chacombo.Funcionario;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFuncionario extends CrudRepository<Funcionario,Integer>{
    
    @Query(value="SELECT * FROM funcionario "
            + "WHERE nombre LIKE %?1% "
            + "OR dni LIKE %?1% "
            + "OR correo LIKE %?1%",nativeQuery=true)
    List<Funcionario> buscarPorTodo(String dato);
    
    
    @Query(value="SELECT * FROM funcionario "
            + "ORDER BY id_funcionario ASC",nativeQuery=true)
    List<Funcionario> OrderAsc();
    
    @Query(value="SELECT * FROM funcionario "
            + "ORDER BY id_funcionario DESC",nativeQuery=true)
    List<Funcionario> OrderDesc();
}
