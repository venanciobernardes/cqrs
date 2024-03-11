package com.cqrs.command.command.handler;

import com.cqrs.command.command.InsertProductCommand;
import com.cqrs.command.model.Product;
import com.cqrs.command.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class InsertProductCommandHandler implements IInsertProductCommandHandler{

    private ProductRepository repository;

    public InsertProductCommandHandler(ProductRepository Repository) {
        this.repository = Repository;
    }

    public void handle(InsertProductCommand productCommand){
        Product product = new Product(productCommand.getName(), productCommand.getDescription(), productCommand.getPrice());
        repository.save(product);
    }
}
