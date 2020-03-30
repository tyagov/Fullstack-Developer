package maximatech.freteservice;

import maximatech.freteservice.service.CalcularServiceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FreteServiceApplication {

    @Bean
    public CalcularServiceImp getCalcularServiceImp(){
        return new CalcularServiceImp();
    }
    @LoadBalanced
    public static void main(String[] args) {
        SpringApplication.run(FreteServiceApplication.class, args);
    }

}
