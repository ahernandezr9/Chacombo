package upn.pe.Chacombo.DetalleVenta;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleVentaService implements IDetalleVentaService{
    @Autowired
    private IDetalleVenta data;
    
    @Override
    public List<DetalleVenta> Listar() {
       return (List<DetalleVenta>) data.findAll();
    }

    @Override
    public Optional<DetalleVenta> ConsultarId(int id) {
       return data.findById(id);
    }

    @Override
    public void Guardar(DetalleVenta dv) {
        data.save(dv);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }
}
