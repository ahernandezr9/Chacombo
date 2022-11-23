/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upn.pe.Chacombo.Entrega;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntregaService implements IEntregaService{
    @Autowired
    private IEntrega data;
    
    @Override
    public List<Entrega> Listar() {
       return (List<Entrega>) data.findAll();
    }

    @Override
    public Optional<Entrega> ConsultarId(int id) {
       return data.findById(id);
    }

    @Override
    public void Guardar(Entrega e) {
        data.save(e);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }
}
