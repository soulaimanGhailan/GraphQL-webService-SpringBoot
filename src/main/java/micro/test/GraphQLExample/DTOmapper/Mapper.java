package micro.test.GraphQLExample.DTOmapper;

import micro.test.GraphQLExample.dto.ProductReqDTO;
import micro.test.GraphQLExample.entities.Product;

public interface Mapper {
    Product fromProductReqDto(ProductReqDTO productReqDTO , TransformType type);
}
