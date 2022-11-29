package upn.pe.Chacombo.Producto;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProducto extends CrudRepository<Producto,Integer>{
    
    @Query(value="SELECT * FROM producto "
            + "WHERE nombre LIKE %?1% "
            + "OR tipo LIKE %?1% "
            + "OR precio LIKE %?1%",nativeQuery=true)
    List<Producto> buscarPorTodo(String dato);
    
    @Query(value="SELECT * FROM producto "
            + "ORDER BY id_producto ASC",nativeQuery=true)
    List<Producto> OrderAscProd();
    
    @Query(value="SELECT * FROM producto "
            + "ORDER BY id_producto DESC",nativeQuery=true)
    List<Producto> OrderDescProd();
    
    @Query(value="SELECT COALESCE(MAX(id_producto),0) FROM producto",nativeQuery=true)
    int BuscarIdMax();
}
