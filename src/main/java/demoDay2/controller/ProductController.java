package demoDay2.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import demoDay2.model.Product;
import demoDay2.repository.ProductRepository;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepo;

    //untuk menambahkan prodact
    @GetMapping("/add")
    public void add() {
        productRepo.save(new Product("Minyak Goreng",12000 ));
        productRepo.save(new Product("Minyak Angin",12000 ));
        productRepo.save(new Product("Minyak Rambut",12000 ));
        productRepo.save(new Product("Telor Asin", 25000));
        productRepo.save(new Product("Telor Ceplok", 25000));
        productRepo.save(new Product("Gula Merah", 15000));
        productRepo.save(new Product("Gula Putih", 15000));
        productRepo.save(new Product("Garam Laut", 5000));
        productRepo.save(new Product("Garam Dapur", 5000));
        productRepo.save(new Product("Ampela Goreng",20000 ));
        productRepo.save(new Product("Ampela Pepes",20000 ));
        productRepo.save(new Product("Bumbu",500 ));
        productRepo.save(new Product("Tahu bulat",500));
        productRepo.save(new Product("Tahu Gejrot",10000));
        // System.out.println("Berhasil ditambahakan");
    }
    @GetMapping("/allP")
    public List<Product> allP() {
        return productRepo.findAll();
    }
    // =============================================
    //Excercise 1 JPA Day 3
    @GetMapping("/search/{name}")
    public List<Product> search (@PathVariable (value ="name")String name){      
        return productRepo.findByName(name);
    }
    //Versi non Query
    // @GetMapping("/search/{name}")
    // public List<Product> search (@PathVariable (value ="name")String name){      
    //     return productRepo.findAllByNameContains(name);
    // }
    // ===================================================
    //Excercise 2 JPA Day 3
    @GetMapping("/product/{ascOrDesc}")
    public List<Product> candingList (@PathVariable (value ="ascOrDesc")String ascOrDesc){
    if (ascOrDesc.equals("asc")) {
     return productRepo.findByAsc();
    }else if (ascOrDesc.equals("desc")){
    return productRepo.findByDesc();
    }else {
        return productRepo.findAll();
    }
}
// =================================
    //EXCERCISE 3 JPA Day 3
    @GetMapping("/product/cheaper/{price}")
    public List<Product> cheaper (@PathVariable (value ="price")int price){
        return productRepo.findByPrice(price);
    }

    //Ini versi no Query
    // @GetMapping("/product/cheaper/{price}")
    // public List<Product> findCheaper(@PathVariable(value = "price") double price) {
    //     return productRepo.findAllByPriceLessThan(price);
    // }

    // @GetMapping("/product/{sort}")
    // public List<Product> nameAsc(@PathVariable(value = "sort") String sort) {
    //     if (sort.equals("asc")) {
    //         urut = productRepo.findAllByOrderByNameAsc();
    //     } else if (sort.equals("desc")) {
    //         urut = productRepo.findAllByOrderByNameDesc();
    //     }
    //     return urut;
    // }
}
