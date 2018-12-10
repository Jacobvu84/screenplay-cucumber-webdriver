package com.asksqa.blogspot.todos.cucumber.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import com.asksqa.blogspot.todos.cucumber.MissingTodoItemsException;
import com.asksqa.blogspot.todos.screenplay.model.TodoStatusFilter;
import com.asksqa.blogspot.todos.screenplay.questions.TheItems;
import com.asksqa.blogspot.todos.screenplay.tasks.AddATodoItem;
import com.asksqa.blogspot.todos.screenplay.tasks.CompleteItem;
import com.asksqa.blogspot.todos.screenplay.tasks.FilterItems;
import com.asksqa.blogspot.todos.screenplay.tasks.Start;

import static java.util.Collections.EMPTY_LIST;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class TodoUserSteps {

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^that (.*) has an empty todo list$")
    public void that_James_has_an_empty_todo_list(String actorName) throws Throwable {
        theActorCalled(actorName).wasAbleTo(Start.withAnEmptyTodoList());
    }

    @Given("^that (.*) has a todo list containing (.*)$")
    public void that_James_has_an_empty_todo_list(String actorName, List<String> items) throws Throwable {
        theActorCalled(actorName).wasAbleTo(Start.withATodoListContaining(items));
    }

    @When("^s?he adds '(.*)' to (?:his|her|the) list$")
    public void adds_Buy_some_milk_to_his_list(String item) throws Throwable {
        theActorInTheSpotlight().attemptsTo(AddATodoItem.called(item));
    }

    @Then("^(?:his|her|the) todo list should contain (.*)$")
    public void todo_list_should_contain(List<String> expectedItems) throws Throwable {
        theActorInTheSpotlight().should(seeThat(TheItems.displayed(), equalTo(expectedItems))
                .orComplainWith(MissingTodoItemsException.class,"Missing todos " + expectedItems));
    }

    @Then("^(?:his|her|the) todo list should be empty$")
    public void todo_list_should_be_empty() throws Throwable {
        theActorInTheSpotlight().should(seeThat(TheItems.displayed(), equalTo(EMPTY_LIST)));
    }

    @Then("^s?he (?:completes|has completed) the task called '(.*)'$")
    public void completes_task_called(String item) throws Throwable {
        theActorInTheSpotlight().attemptsTo(
                CompleteItem.called(item)
        );
    }

    @When("s?he filters her list to show only (.*) tasks")
    public void filters_tasks_by(TodoStatusFilter status) {
        theActorInTheSpotlight().attemptsTo(FilterItems.toShow(status));
    }

    @Then("^(.*)'s todo list should contain (.*)$")
    public void a_users_todo_list_should_contain(String actorName, List<String> expectedItems) throws Throwable {
        theActorCalled(actorName).should(seeThat(TheItems.displayed(), equalTo(expectedItems))
                                        .orComplainWith(MissingTodoItemsException.class,"Missing todos " + expectedItems));
    }

    @Then("^'(.*)' should be recorded in (?:his|her|the) list$")
    public void item_should_be_recorded_in_the_list(String expectedItem) throws Throwable {
       theActorInTheSpotlight().should(seeThat(TheItems.displayed(), hasItem(expectedItem))
                                        .orComplainWith(MissingTodoItemsException.class,"Missing todo " + expectedItem));
    }


    @Given("^a precondition$")
    public void a_precondition() throws Exception {
    }


    @When("^something happens$")
    public void something_happens() throws Exception {
    }

    @Then("^something should result$")
    public void something_should_result() throws Exception {
    }

}
