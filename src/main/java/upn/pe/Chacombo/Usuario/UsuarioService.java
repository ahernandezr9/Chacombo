package upn.pe.Chacombo.Usuario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{
    @Autowired
    private IUsuario data;
    
    @Override
    public int LoginUsu(String usu, String cla) {
        return data.buscarUsuario(usu, cla);
    }
}
