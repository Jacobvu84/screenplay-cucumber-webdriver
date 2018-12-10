package com.asksqa.blogspot.todos.screenplay.actions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

/**
 * Custom Action using a low-level WebDriver API
 */

public class DoubleClick implements Task {

    public static DoubleClick on(Target target) {
        return instrumented(DoubleClick.class, target);
    }

    private final Target target;

    public DoubleClick(Target target) {
        this.target = target;
    }

    @Step("{0} double-clicks on #target")
    public <T extends Actor> void performAs(T actor) {
        WebElement element = target.resolveFor(actor);

        as(actor).doubleClick(element).perform();
    }

    private Actions as(Actor actor) {
        return new Actions(BrowseTheWeb.as(actor).getDriver());
    }
}
