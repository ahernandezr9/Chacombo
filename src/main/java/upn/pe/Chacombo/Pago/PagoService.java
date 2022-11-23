package upn.pe.Chacombo.Pago;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoService implements IPagoService {
    @Autowired
    private IPago data;
    
    @Override
    public List<Pago> Listar() {
       return (List<Pago>) data.findAll();
    }

    @Override
    public Optional<Pago> ConsultarId(int id) {
       return data.findById(id);
    }

    @Override
    public void Guardar(Pago p) {
        data.save(p);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }
}
