package Vivero.service;

import Vivero.Dao.ArticleDao;
import Vivero.entity.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleDao articleDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Articulo> listar() {
        return articleDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Articulo article) {
        articleDao.save(article);
    }

    @Override
    @Transactional
    public void eliminar(Articulo article) {
        articleDao.delete(article);
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo buscar(Articulo article) {
        return articleDao.findById(article.getArticuloId()).orElse(null);
    }
    
}
