package maximatech.api.service.interfaces;

import maximatech.api.model.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> consultarTodosClientes() throws Exception;

    Cliente consultarCliente(Long codigo) throws Exception;

    void adicionarCliente(Cliente cliente) throws Exception;

    void adicionarClientes(List<Cliente> clientes) throws Exception;

    void removerCliente(Cliente cliente) throws Exception;

    void atualizrCliente(Cliente cliente) throws Exception;
}
