package co.com.choucair.cetification.proyectobase.stepdefinitions;

import co.com.choucair.cetification.proyectobase.exceptions.EnvironmentError;
import co.com.choucair.cetification.proyectobase.questions.OverviewData;
import co.com.choucair.cetification.proyectobase.tasks.NavigateTo;
import co.com.choucair.cetification.proyectobase.tasks.builders.Login;
import co.com.choucair.cetification.proyectobase.userinterfaces.DashboardPage;
import co.com.choucair.cetification.proyectobase.utils.facts.AToken;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class LoginStepDefinitions {
    String name;

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{word} has a activated account")
    public void sergey_has_a_activated_account(String name) {
        this.name = name;
    }

    @Given("{word} has a token")
    public void Pepito_has_a_token(String name) {
        this.name = name;
        theActorCalled(name)
                .has(AToken.toManageTheirProducts());
    }

    @Given("Pepito failed 1")
    public void pepito_failed1() {
        theActorCalled(name).should(
                seeThat("failed 1", actor -> true, equalTo(false) )
        );
    }

    @Given("Pepito failed 2")
    public void pepito_failed2() {
        theActorCalled(name).should(
            seeThat("failed 1", actor -> true, equalTo(false) )
        );
    }

    @Given("{word} compromised")
    public void pepito_compromised() {
        theActorCalled(name).should(
                seeThat("", actor -> true, equalTo(false))
                        .orComplainWith(EnvironmentError.class, "No se tiene la conexion con el third party.")
        );
    }

    @When("he sends their valid credentials")
    public void he_sends_their_valid_credentials() {
        theActorCalled(name).attemptsTo(
                NavigateTo.theDuckDuckGoHomePage(),
                //DoLogin.withCredential( "pepito", "algo")
                Login
                    .with()
                    .username("pepito")
                    .and()
                    .password("seguridad")
                    .and()
                    .rememberMe()
        );
    }

    @Then("he should have access to manage his account")
    public void he_should_have_access_to_manage_his_account() {
        theActorInTheSpotlight().should(
                seeThat("The displayed credit available", OverviewData.creditAvailable(), equalTo("$17,800")),
                seeThat("The displayed total balance", OverviewData.totalBalance(), equalTo("$350")),
                seeThat("The displayed credit available", OverviewData.creditAvailable(), equalTo("$17,800"))
        );

        theActorInTheSpotlight().attemptsTo(
                Click.on(DashboardPage.LEFT_MENU.CREDIT_CARD_LINK)
        );
    }

}
