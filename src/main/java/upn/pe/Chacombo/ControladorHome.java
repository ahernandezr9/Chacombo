package upn.pe.Chacombo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import upn.pe.Chacombo.Carrito.Carrito;
import upn.pe.Chacombo.Carrito.ClienteAux;
import upn.pe.Chacombo.Cliente.Cliente;
import upn.pe.Chacombo.Cliente.IClienteService;
import upn.pe.Chacombo.DetalleVenta.DetalleVenta;
import upn.pe.Chacombo.DetalleVenta.IDetalleVentaService;
import upn.pe.Chacombo.Funcionario.Funcionario;
import upn.pe.Chacombo.Funcionario.IFuncionarioService;
import upn.pe.Chacombo.Producto.IProductoService;
import upn.pe.Chacombo.Producto.Producto;
import upn.pe.Chacombo.Usuario.IUsuarioService;
import upn.pe.Chacombo.Usuario.Usuario;
import upn.pe.Chacombo.Venta.Venta;

@RequestMapping("/") //http://localhost/producto/
@Controller
public class ControladorHome {

    ArrayList<Carrito> listaCarrito = new ArrayList();
    ArrayList<ClienteAux> listaDatCarrito = new ArrayList();

    @Autowired
    private IProductoService service;

    @Autowired
    private IUsuarioService serviceUsu;
    
    @Autowired
    private IClienteService serviceCli;
    
    @Autowired
    private IFuncionarioService serviceFun;
    
    String carpetaPrd="Producto/";
    String carpetaCli="Cliente/";
    String carpetaFun="Funcionario/";

    @GetMapping("/")
    public String Mostrar(Model model) {
        List<Producto> productos = service.Listar();
        model.addAttribute("productos", productos);
                
        return "index"; //index.html
    }

    @GetMapping("/login")
    public String Login(Model model) {
        return "Login";
    }

    @PostMapping("/LoginUsu")
    public String LoginUsu(@RequestParam("datoUsu") String datoUsu, @RequestParam("datoCla") String datoCla, Model model) {
        int ValidaUsu = serviceUsu.LoginUsu(datoUsu, datoCla);

        if (ValidaUsu == 1) {
            return "indexUsuario"; //indexUsuario.html
        } else {
            return Mostrar(model);
        }
    }

    @PostMapping("/AgregarCarrito")
    public String AgregarCarrito(@RequestParam("id") int id_producto,
            @RequestParam("nombre") String nombre,
            @RequestParam("precio") float precio,
            @RequestParam("cantidad") int cantidad,
            Model model) {

        Carrito c = new Carrito();
        float Total = precio * cantidad;
        
        c.setIdProducto(id_producto);
        c.setNombre(nombre);
        c.setPrecio(precio);
        c.setCantidad(cantidad);
        c.setTotal(Total);

        listaCarrito.add(c);

        return Mostrar(model);
    }

    @GetMapping("/ListarCarrito")
    public String ListarCarrito(Model model) {
        model.addAttribute("detalles", listaCarrito);
        return "Carrito";
    }

    @GetMapping("/EliminarCompra")
    public String EliminarCompra(@RequestParam("id") int id, Model model) {
        for (int x = 0; x < listaCarrito.size(); x++) {
            if (listaCarrito.get(x).getIdProducto() == id) {
                listaCarrito.remove(x);
            }
        }
        return ListarCarrito(model);
    }
    
    @PostMapping("/ContinuarCompra")
    public String CompraClientes(Model model) {
        return "carritoCliente";
    }
    
    @PostMapping("/CompraCliente")
    public String CompraRegClientes(@RequestParam("nom") String nom,
                            @RequestParam("corr") String corr,
                            @RequestParam("telf") String telf,
                            @RequestParam("direc") String direc,
                            @RequestParam("pag") int pag,
                            @RequestParam("entr") int entr,
                            Model model)
    {
        ClienteAux cAux = new ClienteAux();
        cAux.setNombres(nom);
        cAux.setCorreo(corr);
        cAux.setTelefono(telf);
        cAux.setDireccion(direc);
        cAux.setIdPago(pag);
        cAux.setIdEntrega(entr);
        
        model.addAttribute("detalleProducto", listaCarrito);
        
        float Total=(float) 0.0;
        for (int i = 0; i < listaCarrito.size(); i++) {
            Total += listaCarrito.get(i).getTotal();
        }
        
        cAux.setTotal_Pago(Total);
        listaDatCarrito.add(cAux);       
        
        model.addAttribute("detalleCliente", listaDatCarrito);
        
        return "carritoFin"; //listaProducto.html
    }
    
    @GetMapping("/Dashboard")
    public String MostrarDashboard(Model model) {
        return "indexUsuario"; //listaProducto.html
    }

    @GetMapping("/Productos")
    public String ListarProductos(Model model) {
        List<Producto> productos = service.Listar();
        model.addAttribute("productos", productos);
        return "listaProducto"; //listaProducto.html
    }
    
    @GetMapping("/eliminarPrd")
    public String EliminarProducto(@RequestParam("id") int id, Model model)
    {
        service.Eliminar(id);
        return "listaProducto"; //listaProducto.html
    }
    
    @PostMapping("/RegistrarPrd")
    public String RegistrarProducto(@RequestParam("nom") String nom,
                            @RequestParam("desc") String desc,
                            @RequestParam("prec") float prec,
                            @RequestParam("tip") String tip,
                            @RequestParam("imag") String imag,
                            Model model)
    {
        Producto p = new Producto();
        p.setNombre(nom);
        p.setDescripcion(desc);
        p.setPrecio(prec);
        p.setTipo(tip);
        p.setImagen(imag);
        
        service.Guardar(p);
        
        return "listaProducto"; //listaProducto.html
    }
    
    @PostMapping("/actualizarPrd")
    public String Actualizar(@RequestParam("id") int id,
                            @RequestParam("nombre") String nom,
                            @RequestParam("descripcion") String desc,
                            @RequestParam("precio") float prec,
                            @RequestParam("tipo") String tip,
                            @RequestParam("imagen") String image,
                            Model model)
    {
        Producto p = new Producto();
        p.setIdProducto(id);
        p.setNombre(nom);
        p.setDescripcion(desc);
        p.setPrecio(prec);
        p.setTipo(tip);
        p.setImagen(image);
        
        service.Guardar(p);
        
        return "indexUsuario"; //listaProducto.html
    }
    
    @GetMapping("/editarPrd")
    public String Editar(@RequestParam("id") int id, Model model)
    {
        Optional<Producto> producto = service.ConsultarId(id);
        model.addAttribute("producto", producto);
        
        return "listaProducto"; //listaProducto.html
    }
    
    @GetMapping("/Clientes")
    public String ListarClientes(Model model) {
        List<Cliente> clientes = serviceCli.Listar();
        model.addAttribute("clientes", clientes);
        return "listaCliente"; //listacliente.html
    }
    
    @GetMapping("/eliminarCli")
    public String EliminarCliente(@RequestParam("id") int id, Model model)
    {
        serviceCli.Eliminar(id);
        return "listaCliente"; //listacliente.html
    }
    
    @PostMapping("/RegistrarCli")
    public String RegistrarCliente(@RequestParam("nom") String nom,
                            @RequestParam("corr") String corr,
                            @RequestParam("telf") String telf,
                            @RequestParam("dire") String dire,
                            Model model)
    {
        Cliente c = new Cliente();
        c.setNombres(nom);
        c.setCorreo(corr);
        c.setTelefono(telf);
        c.setDireccion(dire);
        
        serviceCli.Guardar(c);
        
        return "listaCliente"; //listacliente.html
    }
    
    @PostMapping("/actualizarCli")
    public String ActualizarCliente(@RequestParam("id") int id,
                            @RequestParam("nombres") String nom,
                            @RequestParam("correo") String corr,
                            @RequestParam("telefono") String telf,
                            @RequestParam("direccion") String dire,
                            Model model)
    {
        Cliente c = new Cliente();
        c.setIdCliente(id);
        c.setNombres(nom);
        c.setCorreo(corr);
        c.setTelefono(telf);
        c.setDireccion(dire);
        
        serviceCli.Guardar(c);
        
        return "indexUsuario"; //listacliente.html
    }
    
    @GetMapping("/editarCli")
    public String EditarCliente(@RequestParam("id") int id, Model model)
    {
        Optional<Cliente> cliente = serviceCli.ConsultarId(id);
        model.addAttribute("cliente", cliente);
        
        return "listaCliente"; //listacliente.html
    }
    
    @GetMapping("/Funcionarios")
    public String ListarFuncionarios(Model model) {
        List<Funcionario> funcionarios = serviceFun.Listar();
        model.addAttribute("funcionarios", funcionarios);
        return "listaFuncionario"; //listaFuncionario.html
    }
    
    
    @GetMapping("/eliminarFun")
    public String EliminarFuncionario(@RequestParam("id") int id, Model model)
    {
        serviceFun.Eliminar(id);
        return "listaFuncionario"; //listaFuncionario.html
    }
    
    @PostMapping("/RegistrarFun")
    public String RegistrarFuncionario(@RequestParam("nom") String nom,
                            @RequestParam("dni") String dni,
                            @RequestParam("corr") String corr,
                            Model model)
    {
        Funcionario f = new Funcionario();
        f.setNombre(nom);
        f.setDni(dni);
        f.setCorreo(corr);
        
        serviceFun.Guardar(f);
        
        return "listaFuncionario"; //listaFuncionario.html
    }
    
    @PostMapping("/actualizarFun")
    public String ActualizarFun(@RequestParam("id") int id,
                            @RequestParam("dni") String dni,
                            @RequestParam("nombre") String nom,
                            @RequestParam("correo") String corr,
                            Model model)
    {
        Funcionario f = new Funcionario();
        f.setIdFuncionario(id);
        f.setNombre(nom);
        f.setDni(dni);
        f.setCorreo(corr);
        
        serviceFun.Guardar(f);
        
        return "indexUsuario"; //listaFuncionario.html
    }
    
    @GetMapping("/editarFun")
    public String EditarFun(@RequestParam("id") int id, Model model)
    {
        Optional<Funcionario> funcionario = serviceFun.ConsultarId(id);
        model.addAttribute("funcionario", funcionario);
        
        return "listaFuncionario"; //listaFuncionario.html
    }

    
    
    @PostMapping("/buscarFun")
    public String Buscar(@RequestParam("dato") String dato, Model model)
    {
        List<Funcionario> funcionarios = serviceFun.Buscar(dato);
        model.addAttribute("funcionarios", funcionarios);
        return "listaFuncionario"; //listaproductos.html
    }
    
    @PostMapping("/buscarCli")
    public String BuscarCli(@RequestParam("dato") String dato, Model model)
    {
        List<Cliente> clientes = serviceCli.Buscar(dato);
        model.addAttribute("clientes", clientes);
        return "listaCliente"; //listaproductos.html
    }
    
    
    @GetMapping("/orden_ascFun")
    public String OrdenarAsc(Model model)
    {
        List<Funcionario> funcionarios = serviceFun.OrdenAscendente();
        model.addAttribute("funcionarios", funcionarios);
        return "listaFuncionario"; //listaproductos.html
    }
    
    @GetMapping("/orden_descFun")
    public String OrdenarDesc(Model model)
    {
        List<Funcionario> funcionarios = serviceFun.OrdenDescendente();
        model.addAttribute("funcionarios", funcionarios);
        return "listaFuncionario"; //listaproductos.html
    }
    
    
    @GetMapping("/orden_asccli")
    public String OrdenarAscCli(Model model)
    {
        List<Cliente> clientes = serviceCli.OrdenAscendenteCli();
        model.addAttribute("clientes", clientes);
        return "listaCliente"; //listaproductos.html
    }
    
    @GetMapping("/orden_desccli")
    public String OrdenarDescCli(Model model)
    {
        List<Cliente> clientes = serviceCli.OrdenDescendenteCli();
        model.addAttribute("clientes", clientes);
        return "listaCliente"; //listaproductos.html
    }
}


