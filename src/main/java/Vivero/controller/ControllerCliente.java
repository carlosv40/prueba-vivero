package Vivero.controller;

import Vivero.entity.Cliente;
import Vivero.service.ClienteService;
import jakarta.validation.Valid;
import java.io.Serializable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControllerCliente implements Serializable{
    
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/cliente")
    public String clientes(Model model){
        var clientes = clienteService.listar();
        
        log.info("Ejecutando el controlador de Clientes");
        model.addAttribute("clientes", clientes);
        return "Cliente";
    }
    
     @GetMapping("/agregarC")
    public String agregar(Cliente cliente) {
        return "modificarC";
    }

    @PostMapping("/guardarC")
    public String guardar(@Valid Cliente cliente, Errors errores) {
        if (errores.hasErrors()) {
            return "modificarC";
        }
        clienteService.guardar(cliente);
        return "redirect:/cliente";
    }

    @GetMapping("/editarC/{cliente_id}")
    public String editar(Cliente cliente, Model model) {
        cliente = clienteService.buscar(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarC";
    }

    @GetMapping("/eliminarC")
    public String eliminar(Cliente cliente) {
        clienteService.eliminar(cliente);
        return "redirect:/cliente";
    }
    
}
