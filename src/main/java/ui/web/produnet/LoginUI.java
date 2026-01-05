package ui.web.produnet;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;

public class LoginUI extends PageObject {

    //Pagina username
    public static final Target LBL_BIENVENIDA = Target.the("Label de bienvenida")
            .located(By.xpath("//h4[normalize-space(text())='Hola, te damos la bienvenida']"))
            .waitingForNoMoreThan(Duration.ofSeconds(10));
    
    public static final Target INPUT_USERNAME = Target.the("Input del Username")
            .locatedBy("//input[@id='NombreUsuario']")
            .waitingForNoMoreThan(Duration.ofSeconds(10));

    //Pagina password
    public static final Target INPUT_PASSWORD = Target.the("Input del Password")
            .locatedBy("//input[@id='input_Clave']")
            .waitingForNoMoreThan(Duration.ofSeconds(10));
    
    public static final Target BTN_CHECK_PASSWORD = Target.the("Botón Mostrar Password")
            .locatedBy("//button[@id='btnMostrar']")
            .waitingForNoMoreThan(Duration.ofSeconds(10));
    
    public static final Target BTN_INGRESAR = Target.the("Botón Ingresar")
            .locatedBy("//button[@id='btnAceptar']")
            .waitingForNoMoreThan(Duration.ofSeconds(10));
    
    public static final Target BTN_CANCELAR = Target.the("Botón Cancelar")
            .locatedBy("//a[@id='btnAtras']")
            .waitingForNoMoreThan(Duration.ofSeconds(10));
    
    public static final Target TELEFONO_SOPORTE = Target.the("Teléfono de soporte")
            .locatedBy("//a[@href='tel:024009000']")
            .waitingForNoMoreThan(Duration.ofSeconds(10));

    //Pagina de Token
    public static final Target LBL_INGRESAR_CODIGO = Target.the("Label Ingresa el código temporal")
            .locatedBy("//h4[contains(text(),'Código de seguridad')]")
            .waitingForNoMoreThan(Duration.ofSeconds(10));
    
    public static final Target INPUT_TOKEN = Target.the("Input del código de seguridad")
            .locatedBy("//input[@id='codigoSeguridad'] | //input[@name='token'] | //input[contains(@placeholder, 'código')]")
            .waitingForNoMoreThan(Duration.ofSeconds(10));
    
    public static final Target BTN_ACEPTAR_TOKEN = Target.the("Botón aceptar segundo factor")
            .locatedBy("//button[@id='btnAceptarValidarSegundoFactor']");

    public static final Target BTN_CANCELAR_TOKEN = Target.the("Botón cancelar segundo factor")
            .locatedBy("//a[@id='btnAtras']");

    public static final Target LNK_SOLICITAR_CODIGO = Target.the("Enlace solicitar código temporal")
            .locatedBy("//a[@id='idIngresoAlternativo']");

    //Mensajes de error
    public static final Target MODAL_ERROR_USUARIO = Target.the("Modal Error User Incorrecto")
            .locatedBy("//div[@id='divMensajeAlerta']")
            .waitingForNoMoreThan(Duration.ofSeconds(10));
    
    public static final Target MODAL_ERROR_PASSWORD = Target.the("Modal Error Password Incorrecta")
            .locatedBy("//div[@id='divMensajeAlerta']//p[contains(text(),'La información ingresada')]")
            .waitingForNoMoreThan(Duration.ofSeconds(10));
    
    //Pantalla de login exitoso
    public static final Target LBL_LOGIN_EXITOSO = Target.the("Label de login exitoso")
            .locatedBy("//h1[contains(text(), 'Bienvenido')] | //div[contains(@class, 'dashboard')] | //div[@id='home']")
            .waitingForNoMoreThan(Duration.ofSeconds(15));
}