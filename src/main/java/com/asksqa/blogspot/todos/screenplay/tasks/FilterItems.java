package com.asksqa.blogspot.todos.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.asksqa.blogspot.todos.screenplay.model.TodoStatusFilter;
import com.asksqa.blogspot.todos.screenplay.ui.TodoList;

public class FilterItems implements Task {

    private final TodoStatusFilter filter;

    @Step("{0} filters items by #filter")
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                Click.on(TodoList.FILTER.of(filter.name()).called("filter by "+ filter))
        );
    }

    public static FilterItems toShow(TodoStatusFilter status) {
        return instrumented(FilterItems.class, status);
    }
    public FilterItems(TodoStatusFilter filter) { this.filter = filter; }
}