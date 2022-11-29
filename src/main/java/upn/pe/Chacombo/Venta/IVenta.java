package upn.pe.Chacombo.Venta;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVenta extends CrudRepository<Venta,Integer> {
    @Query(value="SELECT COALESCE(MAX(id_venta),0) FROM venta",nativeQuery=true)
    int BuscarIdMax();
    
    @Query(value="SELECT * FROM venta "
            + "INNER JOIN cliente ON venta.id_cliente = cliente.id_cliente "
            + "WHERE venta.id_cliente = ?1",nativeQuery=true)
    List<Venta> VentasXCliente(int id);
    
    @Query(value="SELECT * FROM venta "
            + "INNER JOIN pago ON venta.id_pago = pago.id_pago "
            + "WHERE venta.id_pago = ?1",nativeQuery=true)
    List<Venta> VentasXPago(int id);
    
}
