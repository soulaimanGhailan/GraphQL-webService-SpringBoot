package micro.test.GraphQLExample.DTOmapper;

import lombok.AllArgsConstructor;
import micro.test.GraphQLExample.dto.ProductReqDTO;
import micro.test.GraphQLExample.entities.Category;
import micro.test.GraphQLExample.entities.Product;
import micro.test.GraphQLExample.reposotories.CategoryRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MapperImpl implements Mapper {
    private CategoryRepo categoryRepo;
    @Override
    public Product fromProductReqDto(ProductReqDTO productReqDTO) {
        Product product = new Product();
        Long categoryId = productReqDTO.getCategoryId();
        Category category = categoryRepo.findById(categoryId)
                                        .orElseThrow(() -> new RuntimeException("category of id +(" + categoryId + ") not found"));
        product.setCategory(category);
        BeanUtils.copyProperties(productReqDTO , product);
        return null;
    }

}
