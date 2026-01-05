package tasks.web.produnet;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultarAbilities implements Task {

    private final String endpoint;

    public ConsultarAbilities(String endpoint) {
        this.endpoint = endpoint;
    }

    public static ConsultarAbilities desde(String endpoint) {
        return new ConsultarAbilities(endpoint);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(endpoint) // Se conecta al dominio configurado en serenity.conf
        );
        System.out.println("habilidades de pokemon -> "+ lastResponse().asString());
        System.out.println("status de pokemon -> "+ lastResponse().statusCode());
    }
}

