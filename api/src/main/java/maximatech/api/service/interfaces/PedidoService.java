package maximatech.api.service.interfaces;

import maximatech.api.model.Pedido;

import java.util.List;

public interface PedidoService {

    List<Pedido> consultarTodosPedidos() throws Exception;

    Pedido consultarPedido(Long codigo) throws Exception;

    void adicionarPedido(Pedido pedido) throws Exception;

    void adicionarPedidos(List<Pedido> pedidos) throws Exception;

    void removerPedido(Pedido pedido) throws Exception;

    void atualizrPedido(Pedido pedido) throws Exception;
}
