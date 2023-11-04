package micro.test.GraphQLExample.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Product {
    @Id
    private String id ;
    private String name ;
    private double price ;
    private int quantity ;
    @ManyToOne
    private Category category;

}
