package tasks.web.produnet;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class CerrarPestanaActual implements Task {

    private CerrarPestanaActual() {
    }

    public static CerrarPestanaActual yRegresarALaPrimera() {
        return new CerrarPestanaActual();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        
        // Cierra la pestaña actual
        driver.close();
        System.out.println("❌ Pestaña cerrada");
        
        // Cambia a la primera pestaña
        ArrayList<String> pestanas = new ArrayList<>(driver.getWindowHandles());
        if (!pestanas.isEmpty()) {
            driver.switchTo().window(pestanas.get(0));
            System.out.println("🔄 Regresó a la pestaña original");
        }
    }
}