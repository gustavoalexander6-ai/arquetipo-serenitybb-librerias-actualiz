package questions.produnet;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static ui.web.produnet.LoginUI.TELEFONO_SOPORTE;

public class TelefonoSoporteExiste implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        // Valida que el elemento esté presente/visible en la página
        return TELEFONO_SOPORTE.resolveFor(actor).isPresent();
    }

    public static TelefonoSoporteExiste visible() {
        return new TelefonoSoporteExiste();
    }
}
