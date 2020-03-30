package maximatech.api.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import maximatech.api.model.Cliente;
import maximatech.api.service.ClienteServiceImp;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private RestTemplate rest;

    @Autowired
    ClienteServiceImp clienteServiceImp;

    @RequestMapping("/listarTodosClientes")
    public List<Cliente> listarTodosClientes() {
        try {
            if (clienteServiceImp.consultarTodosClientes().isEmpty()) {
                povoarCliente();
            }
            return clienteServiceImp.consultarTodosClientes();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void povoarCliente() {
        try {
            String json = rest.getForObject("https://api.myjson.com/bins/tnjfr", String.class);
            List<Cliente> clientes = new ObjectMapper().readValue(new JSONObject(json).get("clientes").toString(), new TypeReference<List<Cliente>>() {
            });
            clienteServiceImp.adicionarClientes(clientes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
