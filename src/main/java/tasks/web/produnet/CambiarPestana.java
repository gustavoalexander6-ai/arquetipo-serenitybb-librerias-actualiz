package tasks.web.produnet;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class CambiarPestana implements Task {

    private final int indicePestana;

    private CambiarPestana(int indicePestana) {
        this.indicePestana = indicePestana;
    }

    public static CambiarPestana alaOriginal() {
        return new CambiarPestana(0);
    }

    public static CambiarPestana ala(int indice) {
        return new CambiarPestana(indice);
    }

    public static CambiarPestana alaUltima() {
        return new CambiarPestana(-1);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        ArrayList<String> pestanas = new ArrayList<>(driver.getWindowHandles());
        
        int indice = indicePestana;
        
        // Si es -1, cambiar a la última pestaña
        if (indicePestana == -1) {
            indice = pestanas.size() - 1;
        }
        
        if (indice < pestanas.size() && indice >= 0) {
            driver.switchTo().window(pestanas.get(indice));
            System.out.println("🔄 Cambió a pestaña " + indice);
            System.out.println("📍 URL actual: " + driver.getCurrentUrl());
        } else {
            throw new RuntimeException("No existe la pestaña con índice: " + indicePestana);
        }
    }
}