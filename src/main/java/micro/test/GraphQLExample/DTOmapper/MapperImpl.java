package micro.test.GraphQLExample.DTOmapper;

import lombok.AllArgsConstructor;
import micro.test.GraphQLExample.dto.ProductReqDTO;
import micro.test.GraphQLExample.entities.Category;
import micro.test.GraphQLExample.entities.Product;
import micro.test.GraphQLExample.reposotories.CategoryRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class MapperImpl implements Mapper {
    private CategoryRepo categoryRepo;
    @Override
    public Product fromProductReqDto(ProductReqDTO productReqDTO , TransformType type) {
        Product product = new Product();
        BeanUtils.copyProperties(productReqDTO , product);
        if(type.equals(TransformType.INSERT)){
            product.setId(UUID.randomUUID().toString());
            // we can skip this because BeanUtils has already copied the id
        } else if (type.equals(TransformType.UPDATE)) {
            product.setId(productReqDTO.getId());
        }
        Long categoryId = productReqDTO.getCategoryId();
        Category category = categoryRepo.findById(categoryId).orElse(null);
        product.setCategory(category);
        return product;
    }

}
