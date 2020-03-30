package maximatech.freteservice.service;

public class CalcularServiceImp implements CalcularService {
    @Override
    public Double calcularValorFrete(Integer quantidadeProdutos) {
        Double valorParaMultiplicar =  5 + (Math.random() * (10 - 5));
        return quantidadeProdutos * valorParaMultiplicar;
    }
}
