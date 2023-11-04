package micro.test.GraphQLExample.web;

import lombok.AllArgsConstructor;
import micro.test.GraphQLExample.entities.Category;
import micro.test.GraphQLExample.entities.Product;
import micro.test.GraphQLExample.reposotories.CategoryRepo;
import micro.test.GraphQLExample.reposotories.ProductRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("product1")
@AllArgsConstructor
public class productRest {
    private ProductRepo productRepo;
    private CategoryRepo categoryRepo;
    @GetMapping("/all")
    public List<Product> getall(){
        List<Product> all = productRepo.findAll();
//        System.out.println(all.get(0));
        return all;
    }
    @GetMapping("/cat")
    public List<Category> getallC(){
        return categoryRepo.findAll();
    }

    @GetMapping("/all/{category}")
    public List<Product> getallddC(@PathVariable String category){
        List<Product> all = productRepo.findAll().stream()
                .filter(product -> category.equals(product.getCategory().getName())).collect(Collectors.toList());
        return all;
    }
}
