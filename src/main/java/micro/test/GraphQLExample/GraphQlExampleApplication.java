package micro.test.GraphQLExample;

import micro.test.GraphQLExample.entities.Category;
import micro.test.GraphQLExample.entities.Product;
import micro.test.GraphQLExample.reposotories.CategoryRepo;
import micro.test.GraphQLExample.reposotories.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class GraphQlExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlExampleApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CategoryRepo categoryRepo , ProductRepo productRepo){
		return args -> {
			List.of("Clothing" , "furniture" , "electronics")
					.forEach(s -> categoryRepo.save(Category.builder().name(s).build()));
			categoryRepo.findAll().forEach(category -> {
				for (int i = 0; i < 5; i++) {
					productRepo.save(Product.builder()
							.id(UUID.randomUUID().toString())
							.name("product"+ i)
							.price(Math.random()*1000 +20)
							.quantity((int)(Math.random()*100 +100))
							.category(category)
							.build());
				}
			});


		};
	}
}
