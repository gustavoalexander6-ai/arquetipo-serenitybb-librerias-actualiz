package tasks.web.produnet;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.Attribute;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.web.produnet.LoginUI;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class RevisarRespuesta implements Task {

    private final String tipo;

    private RevisarRespuesta(String tipo) {
        this.tipo = tipo;
    }

    public static RevisarRespuesta token() {
        return new RevisarRespuesta("token");
    }
    
    public static RevisarRespuesta contraseniaIncorrecta() {
        return new RevisarRespuesta("contraseniaIncorrecta");
    }
    
    public static RevisarRespuesta contraseniaCorrecta() {
        return new RevisarRespuesta("contraseniaCorrecta");
    }
    
    public static RevisarRespuesta loginExitoso() {
        return new RevisarRespuesta("loginExitoso");
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (tipo) {
            case "token":
                actor.attemptsTo(
                        WaitUntil.the(LoginUI.LBL_INGRESAR_CODIGO, isVisible()).forNoMoreThan(10).seconds()
                );
                
                actor.should(
                        seeThat(Text.of(LoginUI.LBL_INGRESAR_CODIGO), containsString("temporal enviado al correo")),
                        seeThat(Attribute.of(LoginUI.BTN_ACEPTAR_TOKEN).named("disabled"), equalTo("true"))
                );
                
                System.out.println("✅ Pantalla de token validada correctamente");
                break;
                
            case "contraseniaIncorrecta":
                actor.attemptsTo(
                        WaitUntil.the(LoginUI.MODAL_ERROR_USUARIO, isVisible()).forNoMoreThan(10).seconds()
                );
                
                actor.should(
                        seeThat(Text.of(LoginUI.MODAL_ERROR_USUARIO), containsString("Error al obtener el usuario"))
                );
                
                System.out.println("✅ Error de usuario validado correctamente");
                break;
                
            case "contraseniaCorrecta":
                actor.attemptsTo(
                        WaitUntil.the(LoginUI.MODAL_ERROR_PASSWORD, isVisible()).forNoMoreThan(10).seconds()
                );
                
                actor.should(
                        seeThat(Text.of(LoginUI.MODAL_ERROR_PASSWORD), containsString("La información ingresada"))
                );
                
                System.out.println("✅ Error de password validado correctamente");
                break;
                
            case "loginExitoso":
                actor.attemptsTo(
                        WaitUntil.the(LoginUI.LBL_LOGIN_EXITOSO, isVisible()).forNoMoreThan(15).seconds()
                );
                
                actor.should(
                        seeThat(Text.of(LoginUI.LBL_LOGIN_EXITOSO), containsString("Bienvenido"))
                );
                
                System.out.println("✅ Login exitoso validado correctamente");
                break;
        }
    }
}