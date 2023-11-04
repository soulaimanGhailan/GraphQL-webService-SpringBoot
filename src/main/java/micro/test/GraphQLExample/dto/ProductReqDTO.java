package micro.test.GraphQLExample.dto;

import lombok.Data;
import micro.test.GraphQLExample.entities.Category;

@Data
public class ProductReqDTO {
    private String id ;
    private String name ;
    private double price ;
    private int quantity ;
    private Long categoryId;
}
