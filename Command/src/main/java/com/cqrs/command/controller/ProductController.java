package com.cqrs.command.controller;

import com.cqrs.command.command.InsertProductCommand;
import com.cqrs.command.command.RemoveProductCommand;
import com.cqrs.command.command.UpdateProductInfoCommand;
import com.cqrs.command.command.handler.IInsertProductCommandHandler;
import com.cqrs.command.command.handler.IRemoveProductCommandHandler;
import com.cqrs.command.command.handler.IUpdateProductInfoCommandHandler;
import com.cqrs.command.dto.ProductDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {

    private IInsertProductCommandHandler insertProductCommandHandler;
    private IRemoveProductCommandHandler removeProductCommandHandler;
    private IUpdateProductInfoCommandHandler updateProductInfoCommandHandler;

    public ProductController(IInsertProductCommandHandler insertProductCommandHandler, IRemoveProductCommandHandler removeProductCommandHandler, IUpdateProductInfoCommandHandler updateProductInfoCommandHandler) {
        this.insertProductCommandHandler = insertProductCommandHandler;
        this.removeProductCommandHandler = removeProductCommandHandler;
        this.updateProductInfoCommandHandler = updateProductInfoCommandHandler;
    }

    @PostMapping
    public void insert(@RequestBody ProductDTO dto) {
        var command = new InsertProductCommand(dto.getName(), dto.getDescription(), dto.getPrice());
        insertProductCommandHandler.handle(command);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        var command = new RemoveProductCommand(id);
        removeProductCommandHandler.handle(command);
    }

    @PutMapping("/{id}")
    public void updateById(@PathVariable Long id, @RequestBody ProductDTO dto) {
        var command = new UpdateProductInfoCommand(dto.getName(), dto.getDescription(), dto.getPrice());
        updateProductInfoCommandHandler.handle(id, command);
    }
}
