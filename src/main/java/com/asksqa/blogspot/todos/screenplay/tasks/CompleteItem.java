package com.asksqa.blogspot.todos.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.asksqa.blogspot.todos.screenplay.ui.TodoListItem;

public class CompleteItem implements Task {

    private final String itemName;

    @Override
    @Step("{0} completes the item called: #itemName")
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                Click.on(TodoListItem.COMPLETE_ITEM.of(itemName))
        );
    }

    public static CompleteItem called(String itemName) {
        return instrumented(CompleteItem.class, itemName);
    }
    public CompleteItem(String itemName) { this.itemName = itemName; }
}