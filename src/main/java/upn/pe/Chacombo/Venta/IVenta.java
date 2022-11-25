package upn.pe.Chacombo.Venta;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVenta extends CrudRepository<Venta,Integer> {
    @Query(value="SELECT COALESCE(MAX(id_venta),0) FROM venta",nativeQuery=true)
    int BuscarIdMax();
}
