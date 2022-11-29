package upn.pe.Chacombo.Producto;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private IProducto data;
    
    @Override
    public List<Producto> Listar() {
       return (List<Producto>) data.findAll();
    }

    @Override
    public Optional<Producto> ConsultarId(int id) {
       return data.findById(id);
    }

    @Override
    public void Guardar(Producto p) {
        data.save(p);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Producto> OrdenAscendenteProd() {
        return data.OrderAscProd();
    }

    @Override
    public List<Producto> OrdenDescendenteProd() {
        return data.OrderDescProd();
    }

    @Override
    public List<Producto> Buscar(String dato) {
        return data.buscarPorTodo(dato);
    }
    
    @Override
    public int IdMaxProducto() {
        return data.BuscarIdMax();
    }
}
