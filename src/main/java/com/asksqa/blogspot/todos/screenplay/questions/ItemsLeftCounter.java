package com.asksqa.blogspot.todos.screenplay.questions;

import com.asksqa.blogspot.todos.screenplay.ui.TodoList;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ItemsLeftCounter implements Question<Integer> {
    @Override
    public Integer answeredBy(Actor actor) {
        return Text.of(TodoList.ITEMS_LEFT)
                   .viewedBy(actor)
                   .asInteger();
    }
}