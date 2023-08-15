package Vivero.service;

import Vivero.Dao.PedidoDao;
import Vivero.entity.Pedido;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoServiceImpl implements PedidoService{
    
    @Autowired
    private PedidoDao pedidoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Pedido> listar() {
        return pedidoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Pedido pedido) {
        pedidoDao.save(pedido);
    }

    @Override
    @Transactional
    public void eliminar(Pedido pedido) {
        pedidoDao.delete(pedido);
    }

    @Override
    @Transactional(readOnly = true)
    public Pedido buscar(Pedido pedido) {
        return pedidoDao.findById(pedido.getPedidoId()).orElse(null);
    }
    
}
