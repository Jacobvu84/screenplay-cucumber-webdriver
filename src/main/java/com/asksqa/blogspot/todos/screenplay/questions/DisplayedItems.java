package com.asksqa.blogspot.todos.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

import com.asksqa.blogspot.todos.screenplay.ui.TodoList;

@Subject("the displayed todo items")
public class DisplayedItems implements Question<List<String>> {

    @Override
    public List<String> answeredBy(Actor actor) {
        return Text.of(TodoList.ITEMS)
                .viewedBy(actor)
                .asList();
    }
}