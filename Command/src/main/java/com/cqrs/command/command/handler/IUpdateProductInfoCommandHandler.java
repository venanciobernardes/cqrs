package com.cqrs.command.command.handler;

import com.cqrs.command.command.UpdateProductInfoCommand;

public interface IUpdateProductInfoCommandHandler {

    void handle(Long id, UpdateProductInfoCommand product);
}
