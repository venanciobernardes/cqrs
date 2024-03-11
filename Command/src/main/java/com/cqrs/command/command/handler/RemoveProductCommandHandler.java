package com.cqrs.command.command.handler;

import com.cqrs.command.command.RemoveProductCommand;
import com.cqrs.command.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class RemoveProductCommandHandler implements IRemoveProductCommandHandler {

    private ProductRepository repository;

    public RemoveProductCommandHandler(ProductRepository Repository) {
        this.repository = Repository;
    }

    public void handle(RemoveProductCommand productCommand){
        var product = repository.findById(productCommand.id);
        if(product.isPresent()) {
            repository.deleteById(product.get().getId());
        }

    }

}
