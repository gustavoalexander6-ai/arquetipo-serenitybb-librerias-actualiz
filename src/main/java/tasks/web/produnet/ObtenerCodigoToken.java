package tasks.web.produnet;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.web.produnet.ObtenerTokenPageUI;
import ui.web.produnet.LoginUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ObtenerCodigoToken implements Task {

    private final String urlToken;

    private ObtenerCodigoToken(String urlToken) {
        this.urlToken = urlToken;
    }

    public static ObtenerCodigoToken dePaginaExterna() {
        return new ObtenerCodigoToken("https://www.jetbrains.com/es-es/idea/download/download-thanks.html?platform=windows");
    }

    public static ObtenerCodigoToken desdeUrl(String url) {
        return new ObtenerCodigoToken(url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // 1️⃣ Recupera el username de la memoria del actor
        String username = actor.recall("username");
        System.out.println("📋 Username recuperado de memoria: " + username);
        
        // 2️⃣ Abre la página en nueva pestaña
        actor.attemptsTo(
            AbrirNuevaPestana.enLaUrl(urlToken)
        );
        
        System.out.println("🌐 Página de token abierta en nueva pestaña");
        
        // 3️⃣ Espera que aparezca el campo de nombre de cliente
        actor.attemptsTo(
            WaitUntil.the(ObtenerTokenPageUI.INPUT_NOMBRE_CLIENTE, isVisible()).forNoMoreThan(10).seconds()
        );
        
        // 4️⃣ PEGA el username en el campo de nombre de cliente
        actor.attemptsTo(
            Enter.theValue(username).into(ObtenerTokenPageUI.INPUT_NOMBRE_CLIENTE)
        );
        
        System.out.println("✅ Username pegado en página de token: " + username);
        
        // 5️⃣ Si hay un botón para generar el código, haz clic
        try {
            actor.attemptsTo(
                WaitUntil.the(ObtenerTokenPageUI.BTN_GENERAR_CODIGO, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(ObtenerTokenPageUI.BTN_GENERAR_CODIGO)
            );
            System.out.println("🔘 Botón generar código presionado");
        } catch (Exception e) {
            System.out.println("ℹ️ No hay botón de generar código o no es necesario");
        }
        
        // 6️⃣ Espera y obtiene el código
        actor.attemptsTo(
            WaitUntil.the(ObtenerTokenPageUI.CODIGO_TOKEN, isVisible()).forNoMoreThan(15).seconds()
        );
        
        String codigo = Text.of(ObtenerTokenPageUI.CODIGO_TOKEN).answeredBy(actor);
        System.out.println("🔑 Código obtenido: " + codigo);
        
        // 7️⃣ Guarda el código en la memoria
        actor.remember("token", codigo);
        
        // 8️⃣ Cierra la pestaña y regresa a Produnet
        actor.attemptsTo(
            CerrarPestanaActual.yRegresarALaPrimera()
        );
        
        System.out.println("🔙 Regresó a la página de Produnet");
        
        // 9️⃣ Espera que aparezca el input de token en Produnet
        actor.attemptsTo(
            WaitUntil.the(LoginUI.INPUT_TOKEN, isVisible()).forNoMoreThan(10).seconds()
        );
        
        // 🔟 Ingresa el código en Produnet
        actor.attemptsTo(
            Enter.theValue(codigo).into(LoginUI.INPUT_TOKEN),
            Click.on(LoginUI.BTN_ACEPTAR_TOKEN)
        );
        
        System.out.println("✅ Código ingresado en Produnet");
    }
}