package el.asmae.inventoryservice;

import el.asmae.inventoryservice.entities.Product;
import el.asmae.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {
	private ProductRepository productRepository;

	public InventoryServiceApplication(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	public CommandLineRunner start(){
		return args -> {
				productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("HP").price(230098.0).quantity(20).build());
				productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("Mic").price(300900.0).quantity(10).build());
				productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("USB").price(100.0).quantity(20).build());
		};
	}

}
