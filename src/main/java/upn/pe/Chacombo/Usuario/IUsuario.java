package upn.pe.Chacombo.Usuario;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuario extends CrudRepository<Usuario,Integer>{
    @Query(value="SELECT EXISTS(SELECT * FROM usuario "
            + "WHERE usuario = ?1 "
            + "AND clave = ?2)",nativeQuery=true)
            
    int buscarUsuario(String usu,String cla);
}
