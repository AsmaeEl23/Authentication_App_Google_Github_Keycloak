package el.asmae.inventoryservice.web;

import el.asmae.inventoryservice.entities.Product;
import el.asmae.inventoryservice.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableMethodSecurity
@AllArgsConstructor
public class ProductRestController {
    private ProductRepository productRepository;
    @GetMapping("/products")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public List<Product> products(){
        return productRepository.findAll();
    }
}
