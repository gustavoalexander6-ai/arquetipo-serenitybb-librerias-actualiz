package tasks.web.produnet;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.web.produnet.LoginUI;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.CoreMatchers.containsString;

public class IngresarCredenciales implements Task {

    private final String credencial;
    private final String tipo;

    private IngresarCredenciales(String credencial, String tipo) {
        this.credencial = credencial;
        this.tipo = tipo;
    }

    public static IngresarCredenciales username(String credencial) {
        return new IngresarCredenciales(credencial, "username");
    }

    public static IngresarCredenciales password(String credencial) {
        return new IngresarCredenciales(credencial, "password");
    }

    // ⚠️ CAMBIA ESTAS CREDENCIALES - Usa variables de entorno en producción
    public static IngresarCredenciales userCorrecto() {
        return new IngresarCredenciales("DACRUZCH", "username");
    }
    
    public static IngresarCredenciales userIncorrecto() {
        return new IngresarCredenciales("USUARIOINCORRECTO123", "username");
    }

    public static IngresarCredenciales pwdCorrecta() {
        return new IngresarCredenciales("Panecillo@123", "password");
    }
    
    public static IngresarCredenciales pwdIncorrecta() {
        return new IngresarCredenciales("PasswordIncorrecta123", "password");
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (tipo) {
            case "username":
                actor.attemptsTo(
                        WaitUntil.the(LoginUI.LBL_BIENVENIDA, isVisible()).forNoMoreThan(10).seconds()
                );
                
                actor.should(
                        seeThat(Text.of(LoginUI.LBL_BIENVENIDA), containsString("Hola"))
                );
                
                // 🎯 GUARDA el username en la memoria del actor
                actor.remember("username", credencial);
                
                actor.attemptsTo(
                        Task.where("{0} ingresa Usuario: " + credencial,
                                Enter.theValue(credencial).into(LoginUI.INPUT_USERNAME),
                                Click.on(LoginUI.BTN_INGRESAR)
                        )
                );
                
                System.out.println("✅ Usuario ingresado y guardado en memoria: " + credencial);
                break;

            case "password":
                actor.attemptsTo(
                        WaitUntil.the(LoginUI.INPUT_PASSWORD, isVisible()).forNoMoreThan(10).seconds()
                );
                
                actor.should(
                        seeThat(Text.of(LoginUI.TELEFONO_SOPORTE), containsString("02 400 9000"))
                );
                
                actor.attemptsTo(
                        Task.where("{0} ingresa Password",
                                Enter.theValue(credencial).into(LoginUI.INPUT_PASSWORD),
                                Click.on(LoginUI.BTN_INGRESAR)
                        )
                );
                
                System.out.println("✅ Password ingresada");
                break;
        }
    }
}