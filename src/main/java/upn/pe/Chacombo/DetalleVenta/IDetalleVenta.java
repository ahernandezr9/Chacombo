package upn.pe.Chacombo.DetalleVenta;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleVenta extends CrudRepository<DetalleVenta,Integer>{
    
}
