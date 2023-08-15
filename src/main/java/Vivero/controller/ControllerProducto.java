package Vivero.controller;

import Vivero.entity.Articulo;
import Vivero.service.ArticleService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControllerProducto {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articulo")
    public String productos(Model model) {
        var articles = articleService.listar();
        log.info("Ejecutando el controlador de productos");

        model.addAttribute("articles", articles);
        return "products";
    }

    @GetMapping("/agregarP")
    public String agregar(Articulo article) {
        return "modificarP";
    }

    @GetMapping("/guardarP")
    public String guardar(@Valid Articulo article, Errors errores) {
        if (errores.hasErrors()) {
            return "modificarP";
        }
        articleService.guardar(article);
        return "redirect:/articulo";
    }

    @GetMapping("/editarP/{articulo_id}")
    public String editar(Articulo article, Model model) {
        article = (Articulo) articleService.buscar(article);
        model.addAttribute("article", article);
        return "modificarP";
    }

    @GetMapping("/eliminarP")
    public String eliminar(Articulo article) {
        articleService.eliminar(article);
        return "redirect:/articulo";
    }
}
