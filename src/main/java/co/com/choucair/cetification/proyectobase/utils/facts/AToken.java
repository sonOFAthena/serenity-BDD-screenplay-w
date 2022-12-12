package co.com.choucair.cetification.proyectobase.utils.facts;

import co.com.choucair.cetification.proyectobase.questions.GetToken;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.facts.Fact;

public class AToken implements Fact {
    private String token;

    public static AToken toManageTheirProducts(){
        return new AToken();
    }

    @Override
    public void setup(Actor actor) {
        token = GetToken
                .toManageMyProducts()
                .answeredBy(actor);

    }

    @Override
    public String toString() {
        return "AToken{" +
                "token='" + token + '\'' +
                '}';
    }
}
