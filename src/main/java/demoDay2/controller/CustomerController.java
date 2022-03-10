package demoDay2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import demoDay2.model.Customer;
import demoDay2.repository.CustomerRepository;
@RestController
public class CustomerController {
    @Autowired
    CustomerRepository repository;

   //Materi Teraning dari pak yudi
    @GetMapping("/init")
    public void init() {
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));
        // System.out.println("Berhasil ditambahakan");
    }
    @GetMapping("/all")
    public List<Customer> all() {
        return repository.findAll();
    }
    @GetMapping("/id")
    public Optional<Customer> id(long id) {
        return repository.findById(id);

    }
    @GetMapping("/lastname")
    public List<Customer> lastName(String lastName) {
        return repository.findByLastName(lastName);
    }
//==========================================================//
    //Excercise JPA
    // @GetMapping("/search/{name}")
    // public List<Customer> search (@PathVariable (value ="name")String name){
    //     List<Customer> firstName = repository.findByFirstName(name);

    //     if(firstName.size()==0){
    //         return repository.findByLastName(name);
    //     }
    //     return repository.findByFirstName(name);
    // }




}
