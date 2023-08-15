package Vivero.service;

import Vivero.entity.Articulo;
import java.util.List;

public interface ArticleService {

    public List<Articulo> listar();

    public void guardar(Articulo article);

    public void eliminar(Articulo article);

    public Articulo buscar(Articulo article);
}
