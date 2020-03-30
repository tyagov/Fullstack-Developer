package maximatech.api.service;

import maximatech.api.model.Produto;
import maximatech.api.service.interfaces.ProdutoRepository;
import maximatech.api.service.interfaces.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public class ProdutoServiceImp implements ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public List<Produto> consultarTodosProdutos() throws Exception {
        return produtoRepository.findAll();
    }

    @Override
    public Produto consultarProduto(Long codigo) throws Exception {
        return produtoRepository.findById(codigo).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public void adicionarProduto(Produto produto) throws Exception {
        if(produto == null || produto.getCodigo().isEmpty()){
            throw new Exception("Não tem produto para salvar");
        }
         produtoRepository.save(produto);
    }

    @Override
    public void adicionarProdutos(List<Produto> produtos) throws Exception {
        produtoRepository.saveAll(produtos);
    }

    @Override
    public void removerProduto(Produto produto) throws Exception {
        produtoRepository.delete(produto);
    }

    @Override
    public void atualizrProduto(Produto produto) throws Exception {
        //TODO verificar metodo para update
        produtoRepository.save(produto);
    }
}
