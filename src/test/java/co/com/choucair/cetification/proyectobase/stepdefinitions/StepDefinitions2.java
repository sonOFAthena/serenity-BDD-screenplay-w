package co.com.choucair.cetification.proyectobase.stepdefinitions;

import co.com.choucair.cetification.proyectobase.utils.SessionVariables;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;

public class StepDefinitions2 {
    @Then("he should get Foo")
    public void he_should_get_foo() {
        String valueRecall = OnStage.theActorInTheSpotlight().recall(SessionVariables.FOO.toString());
    }
}
