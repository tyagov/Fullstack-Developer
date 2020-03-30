package maximatech.api.controller;

import maximatech.api.model.Pedido;
import maximatech.api.service.PedidoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoServiceImp pedidoServiceImp;

    @PostMapping("/realizarPedido")
    public String realizarPedido(@RequestBody Pedido pedido) {
        try {
            if (pedido.getQuantidadeTotal() != null && pedido.getQuantidadeTotal() > 0) {
                pedidoServiceImp.adicionarPedido(pedido);
                return "Pedido realizado com sucesso!";
            }else{
                return "Pedido não realizado :( ";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Ocorreu um erro, desculpe-nos </3";
        }
    }

    @GetMapping("/consultarTodosPedidos")
    public List<Pedido> consultarTodosPedidos(){
        try {
            return pedidoServiceImp.consultarTodosPedidos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
