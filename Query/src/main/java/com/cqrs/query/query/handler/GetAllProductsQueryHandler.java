package com.cqrs.query.query.handler;

import com.cqrs.query.query.GetAllProductsQuery;
import com.cqrs.query.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllProductsQueryHandler implements IGetAllProductsQueryHandler {

    private ProductRepository repository;

    public GetAllProductsQueryHandler(ProductRepository Repository) {
        this.repository = Repository;
    }

    public List<GetAllProductsQuery> handle(){
        var products = repository.findAll();
        var getAllList = new ArrayList<GetAllProductsQuery>();

        for (var p: products) {
            var getAllProductsQuery = new GetAllProductsQuery();
            getAllProductsQuery.setId(p.getId());
            getAllProductsQuery.setName(p.getName());
            getAllProductsQuery.setDescription(p.getDescription());
            getAllProductsQuery.setPrice(p.getPrice());
            getAllList.add(getAllProductsQuery);
        }

        return getAllList;
    }

}
