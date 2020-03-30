package maximatech.freteservice.controller;
import maximatech.freteservice.service.CalcularServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/calcularFrete")
@RestController
public class FreteController {

    @Autowired
    CalcularServiceImp calcularServiceImp;

    @RequestMapping(value = "/{quantidadeProdutos}", method = RequestMethod.GET)
    public Double calcularFrete (@PathVariable("quantidadeProdutos") Integer quantidadeProdutos){
        return calcularServiceImp.calcularValorFrete(quantidadeProdutos);
    }
}
