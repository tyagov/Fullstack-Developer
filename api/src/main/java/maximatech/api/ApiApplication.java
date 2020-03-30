package maximatech.api;

import maximatech.api.service.ClienteServiceImp;
import maximatech.api.service.PedidoServiceImp;
import maximatech.api.service.ProdutoServiceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ApiApplication {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ClienteServiceImp getClienteServiceImp() {
        return new ClienteServiceImp();
    }

    @Bean
    public ProdutoServiceImp getProdutoServiceImp() {
        return new ProdutoServiceImp();
    }

    @Bean
    public PedidoServiceImp getPedidoServiceImp() {
        return new PedidoServiceImp();
    }

    @LoadBalanced
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

}
