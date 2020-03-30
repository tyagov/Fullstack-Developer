package maximatech.api.service;

import maximatech.api.model.Pedido;
import maximatech.api.service.interfaces.PedidoRepository;
import maximatech.api.service.interfaces.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public class PedidoServiceImp implements PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> consultarTodosPedidos() throws Exception {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido consultarPedido(Long codigo) throws Exception {
        return pedidoRepository.findById(codigo).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public void adicionarPedido(Pedido pedido) throws Exception {
        pedidoRepository.save(pedido);
    }

    @Override
    public void adicionarPedidos(List<Pedido> pedidos) throws Exception {
        pedidoRepository.saveAll(pedidos);
    }

    @Override
    public void removerPedido(Pedido pedido) throws Exception {
        pedidoRepository.delete(pedido);
    }

    @Override
    public void atualizrPedido(Pedido pedido) throws Exception {
        pedidoRepository.save(pedido);
    }
}
