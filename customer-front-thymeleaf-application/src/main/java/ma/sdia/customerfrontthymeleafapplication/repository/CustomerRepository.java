package ma.sdia.customerfrontthymeleafapplication.repository;

import ma.sdia.customerfrontthymeleafapplication.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
