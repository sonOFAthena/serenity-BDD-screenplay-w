package co.com.choucair.cetification.proyectobase.stepdefinitions;

import co.com.choucair.cetification.proyectobase.utils.SessionVariables;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

public class StepDefintions1 {

    @When("he tries to remember {word}")
    public void he_tries_to_remember_foo(String value) {
        OnStage.theActorInTheSpotlight().remember(SessionVariables.FOO.toString(), value);
    }

}
