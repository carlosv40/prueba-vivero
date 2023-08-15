package Vivero.service;

import Vivero.entity.Cliente;
import java.util.List;

public interface ClienteService {

    public List<Cliente> listar();

    public void guardar(Cliente cliente);

    public void eliminar(Cliente cliente);

    public Cliente buscar(Cliente cliente);
}
