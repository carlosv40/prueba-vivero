package Vivero.service;

import Vivero.entity.Pedido;
import java.util.List;

public interface PedidoService {

    public List<Pedido> listar();
    
    public void guardar(Pedido pedido);
    
    public void eliminar(Pedido pedido);
    
    public Pedido buscar(Pedido pedido);
}
