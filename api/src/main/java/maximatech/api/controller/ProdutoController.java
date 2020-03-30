package maximatech.api.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import maximatech.api.model.Produto;
import maximatech.api.service.ProdutoServiceImp;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private RestTemplate rest;

    @Autowired
    private ProdutoServiceImp produtoServiceImp;

    @RequestMapping("/listarTodosProdutos")
    public List<Produto> listarTodosProdotos(){
        try {
            if(produtoServiceImp.consultarTodosProdutos().isEmpty()){
                povoarProdutos();
            }
            return produtoServiceImp.consultarTodosProdutos();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void povoarProdutos(){
        try {
            String json = rest.getForObject("https://api.myjson.com/bins/tnjfr", String.class);
            List<Produto> produtos = new ObjectMapper().readValue(new JSONObject(json).get("produtos").toString(), new TypeReference<List<Produto>>() {
            });
            produtoServiceImp.adicionarProdutos(produtos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
