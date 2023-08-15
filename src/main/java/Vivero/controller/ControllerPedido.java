package Vivero.controller;

import Vivero.entity.Pedido;
import Vivero.service.ArticleService;
import Vivero.service.PedidoService;
import Vivero.service.ClienteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControllerPedido {

    @Autowired
    private PedidoService pedidoService;
    
    @Autowired
    private ArticleService productoService;

    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/pedido")
    public String pedidos(Model model) {
        var pedidos = pedidoService.listar();
        var productos = productoService.listar();
        var clientes = clienteService.listar();
        
        log.info("Ejecutando el controlador de pedidos");

        model.addAttribute("pedidos", pedidos);
        model.addAttribute("productos", productos);
        model.addAttribute("clientes", clientes);
        return "pedido";
    }

    @GetMapping("/agregarPedido")
    public String agregar(Pedido pedido) {
        return "modificarPedido";
    }

    @PostMapping("/guardarPedido")
    public String guardar(@Valid Pedido pedido, Errors errores) {
        if (errores.hasErrors()) {
            return "modificarPedido";
        }
        pedidoService.guardar(pedido);
        return "redirect:/pedido";
    }

    @GetMapping("/editarPedido/{pedido_id}")
    public String editar(Pedido pedido, Model model) {
        pedido = pedidoService.buscar(pedido);
        model.addAttribute("pedido", pedido);
        return "modificarPedido";
    }

    @DeleteMapping("/eliminarPedido")
    public String eliminar(Pedido pedido) {
        pedidoService.eliminar(pedido);
        return "redirect:/pedido";
    }
}
