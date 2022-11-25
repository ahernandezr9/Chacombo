package upn.pe.Chacombo.Cliente;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICliente extends CrudRepository<Cliente,Integer>{
    @Query(value="SELECT COALESCE(MAX(id_cliente),0) FROM cliente",nativeQuery=true)
    int BuscarIdMax();
    
    @Query(value="SELECT * FROM cliente "
            + "WHERE nombres LIKE %?1% "
            + "OR telefono LIKE %?1% "
            + "OR correo LIKE %?1%",nativeQuery=true)
    List<Cliente> buscarPorTodo(String dato);
    
    @Query(value="SELECT * FROM cliente "
            + "ORDER BY id_cliente ASC",nativeQuery=true)
    List<Cliente> OrderAscCli();
    
    @Query(value="SELECT * FROM cliente "
            + "ORDER BY id_cliente DESC",nativeQuery=true)
    List<Cliente> OrderDescCli();
}
