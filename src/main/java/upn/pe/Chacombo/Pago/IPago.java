package upn.pe.Chacombo.Pago;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPago extends CrudRepository<Pago,Integer> {
    
}
