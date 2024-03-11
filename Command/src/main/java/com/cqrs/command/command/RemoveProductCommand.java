package com.cqrs.command.command;

public class RemoveProductCommand {

    public Long id;

    public Long getId() {
        return id;
    }

    public RemoveProductCommand(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
