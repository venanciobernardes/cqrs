package com.cqrs.command.command.handler;

import com.cqrs.command.command.UpdateProductInfoCommand;
import com.cqrs.command.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductInfoCommandHandler implements IUpdateProductInfoCommandHandler{
    private ProductRepository repository;

    public UpdateProductInfoCommandHandler(ProductRepository Repository) {
        this.repository = Repository;
    }

    public void handle(Long id, UpdateProductInfoCommand productInfoCommand){
        var produto = repository.getOne(id);
        produto.setDescription(productInfoCommand.getDescription());
        produto.setName(productInfoCommand.getName());
        produto.setPrice(productInfoCommand.getPrice());
        repository.save(produto);
    }
}