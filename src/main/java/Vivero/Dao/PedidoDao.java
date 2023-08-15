package Vivero.Dao;

import Vivero.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoDao extends JpaRepository<Pedido, Long> {

}
