package starter.stepdefinitions.web.produnet;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.produnet.CodigoDeRespuesta;
import starter.navigation.NavegarHacia;
import tasks.web.produnet.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el {actor} abre la Produnet web")
    public void clienteAbreProdunetWeb(Actor actor) {
        actor.whoCan(CallAnApi.at("https://pokeapi.co/api/v2"));
        actor.wasAbleTo(NavegarHacia.produnetLogin());
        System.out.println("🌐 Navegó a Produnet Login");
    }

    @Cuando("{actor} ingresa su usuario y contrasenia correctas")
    public void ingresaUsuarioYContraseniaCorrectas(Actor actor) {
        actor.attemptsTo(
                IngresarCredenciales.userCorrecto(),
                IngresarCredenciales.pwdCorrecta()
        );
        System.out.println("✅ Credenciales correctas ingresadas");
    }

    @Cuando("{actor} obtiene el codigo de verificacion")
    public void obtieneCodigoDeVerificacion(Actor actor) {
        actor.attemptsTo(
                ObtenerCodigoToken.dePaginaExterna()
        );
        System.out.println("✅ Código obtenido e ingresado");
    }

    @Entonces("{actor} valida que se vea la pantalla de token")
    public void validaPantallaToken(Actor actor) {
        actor.attemptsTo(
                RevisarRespuesta.token()
        );
    }

    @Entonces("{actor} valida que ingreso correctamente")
    public void validaLoginExitoso(Actor actor) {
        actor.attemptsTo(
                RevisarRespuesta.loginExitoso()
        );
    }

    @Cuando("{actor} ingresa su usuario incorrecto")
    public void ingresaUsuarioIncorrecto(Actor actor) {
        actor.attemptsTo(
                IngresarCredenciales.userIncorrecto(),
                IngresarCredenciales.pwdCorrecta()
        );
    }

    @Entonces("{actor} valida se muestre un mensaje de error de usuario")
    public void validaErrorUsuario(Actor actor) {
        actor.attemptsTo(
                RevisarRespuesta.contraseniaIncorrecta()
        );
    }

    @Cuando("{actor} ingresa su contrasenia incorrecta")
    public void ingresaContraseniaIncorrecta(Actor actor) {
        actor.attemptsTo(
                IngresarCredenciales.userCorrecto(),
                IngresarCredenciales.pwdIncorrecta()
        );
    }

    @Entonces("{actor} valida que se muestre un mensaje de error de contrasenia")
    public void validaErrorContrasenia(Actor actor) {
        actor.attemptsTo(
                RevisarRespuesta.contraseniaCorrecta()
        );
    }

    // Example restAssured
    @Cuando("{actor} consulta las habilidades de pokemon con limite y offset")
    public void consultaAbilities(Actor actor) {
        actor.attemptsTo(
                ConsultarAbilities.desde("/ability/?limit=20&offset=20")
        );
    }

    @Entonces("{actor} el servicio responde exitosamente")
    public void validaCodigoRespuesta(Actor actor) {
        actor.should(
                seeThat("El código de respuesta",
                        CodigoDeRespuesta.es(),
                        equalTo(200))
        );
    }
}