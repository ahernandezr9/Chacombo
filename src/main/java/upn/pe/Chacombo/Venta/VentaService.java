package upn.pe.Chacombo.Venta;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{
    @Autowired
    private IVenta data;
    
    @Override
    public List<Venta> Listar() {
       return (List<Venta>) data.findAll();
    }

    @Override
    public Optional<Venta> ConsultarId(int id) {
       return data.findById(id);
    }

    @Override
    public void Guardar(Venta v) {
        data.save(v);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }
    
    @Override
    public int IdMaxVenta() {
        return data.BuscarIdMax();
    }
    
    @Override
    public List<Venta> VentasXCliente(int id) {
        return data.VentasXCliente(id);
    }
    
    @Override
    public List<Venta> VentasXPago(int id) {
        return data.VentasXPago(id);
    }
    
}
