package demoDay2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import demoDay2.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
    List<Customer> findById(String id);
    List<Customer> findByFirstName(String firstName);
  

}
