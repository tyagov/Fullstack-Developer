package maximatech.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import maximatech.api.model.Cliente;
import maximatech.api.model.Produto;
import maximatech.api.service.ClienteServiceImp;
import maximatech.api.service.ProdutoServiceImp;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Tiago Vitorino
 * responsavel por popular o banco com json
 */

@RestController
@RequestMapping("/povoar")
public class ClienteProdutoController {

    @Autowired
    private RestTemplate rest;

    @Autowired
    private ClienteServiceImp clienteServiceImp;

    @Autowired
    private ProdutoServiceImp produtoServiceImp;

    @RequestMapping("/clientes")
    public void postCliente() {
        try {
            String json = rest.getForObject("https://api.myjson.com/bins/tnjfr", String.class);
            List<Cliente> clientes = new ObjectMapper().readValue(new JSONObject(json).get("clientes").toString(), new TypeReference<List<Cliente>>() {
            });
            clienteServiceImp.adicionarClientes(clientes);
        } catch (Exception e) {

        }
    }
    @RequestMapping("/produtos")
    public void postProdutos() {
        try {

        } catch (Exception e) {

        }
    }
}
