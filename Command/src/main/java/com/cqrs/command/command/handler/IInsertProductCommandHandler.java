package com.cqrs.command.command.handler;

import com.cqrs.command.command.InsertProductCommand;

public interface IInsertProductCommandHandler {
    void handle(InsertProductCommand product);
}
