package questions.produnet;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static net.serenitybdd.rest.SerenityRest.lastResponse;


public class CodigoDeRespuesta implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return lastResponse().statusCode();
    }

    public static CodigoDeRespuesta es() {
        return new CodigoDeRespuesta();
    }
}

