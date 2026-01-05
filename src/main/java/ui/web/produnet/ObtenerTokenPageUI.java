package ui.web.produnet;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;

public class ObtenerTokenPageUI extends PageObject {

    // Campo para ingresar el nombre del cliente (username)
    public static final Target INPUT_NOMBRE_CLIENTE = Target.the("Input nombre de cliente")
            .locatedBy("//input[@id='clientName'] | //input[@name='customer'] | //input[@name='username'] | //input[contains(@placeholder, 'nombre')] | //input[contains(@placeholder, 'cliente')]")
            .waitingForNoMoreThan(Duration.ofSeconds(10));
    
    // Campo donde aparece el código token
    public static final Target CODIGO_TOKEN = Target.the("Código de verificación")
            .locatedBy("//div[contains(@class, 'codigo')] | //span[@id='verification-code'] | //p[contains(text(), 'código')] | //code | //pre")
            .waitingForNoMoreThan(Duration.ofSeconds(15));
    
    // Botón para generar o solicitar el código (opcional)
    public static final Target BTN_GENERAR_CODIGO = Target.the("Botón generar código")
            .locatedBy("//button[contains(text(), 'Generar')] | //button[@id='generate'] | //button[contains(text(), 'Solicitar')] | //input[@type='submit']")
            .waitingForNoMoreThan(Duration.ofSeconds(10));
    
    // Alternativas adicionales para encontrar el código
    public static final Target CODIGO_EN_PARRAFO = Target.the("Código en párrafo")
            .locatedBy("//p[contains(text(), 'código') or contains(text(), 'code')] | //div[@class='token-display']")
            .waitingForNoMoreThan(Duration.ofSeconds(15));
    
    public static final Target CODIGO_EN_INPUT = Target.the("Código en input")
            .locatedBy("//input[@id='verification-code'] | //input[@readonly]")
            .waitingForNoMoreThan(Duration.ofSeconds(15));
}