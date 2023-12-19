package ma.sdia.customerfrontthymeleafapplication;

import ma.sdia.customerfrontthymeleafapplication.entities.Customer;
import ma.sdia.customerfrontthymeleafapplication.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
public class CustomerFrontThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerFrontThymeleafApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder().name("asmae").email("asmae@gmail.com").build());
            customerRepository.save(Customer.builder().name("issam").email("issam@gmail.com").build());
            customerRepository.save(Customer.builder().name("anwar").email("anwar@gmail.com").build());
            customerRepository.save(Customer.builder().name("fatima").email("fatima@gmail.com").build());
            };
    }
}
