package maximatech.api.service;

import maximatech.api.model.Cliente;
import maximatech.api.service.interfaces.ClienteRepository;
import maximatech.api.service.interfaces.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public class ClienteServiceImp implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> consultarTodosClientes() throws Exception {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente consultarCliente(Long codigo) throws Exception {
        return clienteRepository.findById(codigo).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public void adicionarCliente(Cliente cliente) throws Exception {
        if(cliente == null || cliente.getCodigo().isEmpty()){
            throw new Exception("Não existe cliente para salvar");
        }
        clienteRepository.save(cliente);
    }

    @Override
    public void adicionarClientes(List<Cliente> clientes) throws Exception {
        if(clientes.isEmpty()){
            throw new Exception("Lista de clientes está vazia");
        }
        clienteRepository.saveAll(clientes);
    }

    @Override
    public void removerCliente(Cliente cliente) throws Exception {
        clienteRepository.delete(cliente);
    }

    @Override
    public void atualizrCliente(Cliente cliente) throws Exception {
        //TODO verificar o melhor metodo para update
        clienteRepository.save(cliente);
    }
}
