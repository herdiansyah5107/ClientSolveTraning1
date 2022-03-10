package demoDay2.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import demoDay2.model.Product;
public interface ProductRepository extends JpaRepository<Product, Long> {
   
    List<Product> findAll();

    //Exercise Day 3
    @Query(value= "Select*from product where name LIKE ?%1", nativeQuery =true)
    List<Product> findByName(String name);
    
    @Query(value= "Select * from product where price<?1", nativeQuery =true)
    List<Product> findByPrice(int price);

    @Query(value= "Select * from product ORDER BY name ASC", nativeQuery =true)
    List<Product> findByAsc();

    @Query(value= "Select * from product ORDER BY name DESC", nativeQuery =true)
    List<Product> findByDesc();


    List<Product> findAllByNameContains(String name);
    
}
