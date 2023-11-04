package micro.test.GraphQLExample.web;

import lombok.AllArgsConstructor;
import micro.test.GraphQLExample.DTOmapper.Mapper;
import micro.test.GraphQLExample.dto.ProductReqDTO;
import micro.test.GraphQLExample.entities.Category;
import micro.test.GraphQLExample.entities.Product;
import micro.test.GraphQLExample.reposotories.CategoryRepo;
import micro.test.GraphQLExample.reposotories.ProductRepo;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class ProductGraphQL_Controller {
    private ProductRepo productRepo ;
    private CategoryRepo categoryRepo ;
    private Mapper mapper ;

    @QueryMapping
    public List<Product> productsList(){
        return productRepo.findAll();
    }
    @QueryMapping("ProductById")
    public Product getProductById(@Argument String productId ){
        return productRepo.findById(productId).orElseThrow(() ->new RuntimeException("product of id (" + productId +") not found"));
    }
    @QueryMapping
    public List<Product> productsByCategory(@Argument String category){
        List<Product> all = productRepo.findAll().stream()
                                        .filter(product -> category.equals(product.getCategory().getName())).collect(Collectors.toList());
        return all;
    }
    @QueryMapping
    public List<Category> categories(){
        return categoryRepo.findAll();
    }
    @QueryMapping
    public Category categoryById(@Argument Long id){
        return categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("category of (" + id + ") not founded"));
    }

    @MutationMapping
    public Product saveProduct(@Argument ProductReqDTO ProductRequest){
        return productRepo.save(mapper.fromProductReqDto(ProductRequest));
    }
}
