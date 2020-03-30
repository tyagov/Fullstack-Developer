package maximatech.api.service.interfaces;

import maximatech.api.model.Cliente;
import maximatech.api.model.Produto;

import java.util.List;

public interface ProdutoService {

    List<Produto> consultarTodosProdutos() throws Exception;

    Produto consultarProduto(Long codigo) throws Exception;

    void adicionarProduto(Produto produto) throws Exception;

    void adicionarProdutos(List<Produto> produtos) throws Exception;

    void removerProduto(Produto produto) throws Exception;

    void atualizrProduto(Produto produto) throws Exception;
}
