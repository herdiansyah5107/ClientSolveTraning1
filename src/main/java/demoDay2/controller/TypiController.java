package demoDay2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import demoDay2.model.Type;

@RestController
@Controller 
public class TypiController {

@Autowired RestTemplate restTemplate;

//Exercise RESTFul 1
@GetMapping("/post/{id}")
    public String todoById(@PathVariable(value = "id") Integer id){
        
        Type todoById = restTemplate.getForObject(
                "https://jsonplaceholder.typicode.com/posts/"+id, Type.class);
        String body = todoById.getBody();
        return body;
    }
//versi pak yudi 09 maret 2022





}
