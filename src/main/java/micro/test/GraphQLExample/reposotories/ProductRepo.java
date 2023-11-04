package micro.test.GraphQLExample.reposotories;


import micro.test.GraphQLExample.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product , String> {
    List<Product> findProductsByCategory(String category);
}
