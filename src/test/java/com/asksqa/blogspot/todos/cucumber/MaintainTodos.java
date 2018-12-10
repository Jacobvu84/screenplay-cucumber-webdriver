package com.asksqa.blogspot.todos.cucumber;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/maintain_my_todo_list", 
		tags = {"@filtering","@maintaining"})
public class MaintainTodos {}
