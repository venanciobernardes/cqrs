package com.cqrs.query.controller;

import com.cqrs.query.query.GetAllProductsQuery;
import com.cqrs.query.query.GetProductByIdQuery;
import com.cqrs.query.query.handler.IGetAllProductsQueryHandler;
import com.cqrs.query.query.handler.IGetProductByIdQueryHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class GetProductController {

    private IGetAllProductsQueryHandler getAllProductsHandler;
    private IGetProductByIdQueryHandler getProductByIdHandler;

    public GetProductController(IGetAllProductsQueryHandler GetAllProductsHandler, IGetProductByIdQueryHandler GetProductByIdHandler) {
        this.getAllProductsHandler = GetAllProductsHandler;
        this.getProductByIdHandler = GetProductByIdHandler;
    }

    @GetMapping
    public List<GetAllProductsQuery> getAllProductsHandler() {
        return getAllProductsHandler.handle();
    }

    @GetMapping("/{id}")
    public GetProductByIdQuery getProductByIdHandler(@PathVariable Long id) {
        var query = new GetProductByIdQuery();
        return getProductByIdHandler.handle(id);
    }

}
