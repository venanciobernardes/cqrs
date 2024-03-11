package com.cqrs.query.query.handler;

import com.cqrs.query.query.GetProductByIdQuery;
import com.cqrs.query.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class GetProductByIdQueryHandler implements IGetProductByIdQueryHandler {

    private ProductRepository repository;

    public GetProductByIdQueryHandler(ProductRepository Repository) {
        this.repository = Repository;
    }

    public GetProductByIdQuery handle(Long id){
        var product = repository.findById(id);

        if (product.isPresent()) {
            var getProductByIdQuery = new GetProductByIdQuery();
            getProductByIdQuery.setId(product.get().getId());
            getProductByIdQuery.setName(product.get().getName());
            getProductByIdQuery.setDescription(product.get().getDescription());
            getProductByIdQuery.setPrice(product.get().getPrice());

            return getProductByIdQuery;
        }
        return null;
    }
}
