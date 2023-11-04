package micro.test.GraphQLExample.reposotories;


import micro.test.GraphQLExample.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category , Long> {

}
