package com.cqrs.command.command.handler;

import com.cqrs.command.command.RemoveProductCommand;

public interface IRemoveProductCommandHandler {

    void handle(RemoveProductCommand product);
}
