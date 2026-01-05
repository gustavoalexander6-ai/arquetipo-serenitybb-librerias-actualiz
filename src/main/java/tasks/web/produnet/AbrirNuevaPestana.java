package tasks.web.produnet;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class AbrirNuevaPestana implements Task {

    private final String url;

    private AbrirNuevaPestana(String url) {
        this.url = url;
    }

    public static AbrirNuevaPestana enLaUrl(String url) {
        return new AbrirNuevaPestana(url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        
        // Guarda la ventana original
        String ventanaOriginal = driver.getWindowHandle();
        
        // Abre nueva pestaña con JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('" + url + "', '_blank');");
        
        // Espera un momento para que la pestaña se abra
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Cambia a la nueva pestaña
        ArrayList<String> pestanas = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pestanas.get(pestanas.size() - 1));
        
        System.out.println("✅ Nueva pestaña abierta: " + url);
        System.out.println("📊 Total de pestañas abiertas: " + pestanas.size());
    }
}