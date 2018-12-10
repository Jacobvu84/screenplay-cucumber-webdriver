package com.asksqa.blogspot.todos.cucumber;

public class MissingTodoItemsException extends AssertionError {
    public MissingTodoItemsException(String message) {
        super(message);
    }

    public MissingTodoItemsException(String message, Throwable cause) {
        super(message, cause);
    }
}
