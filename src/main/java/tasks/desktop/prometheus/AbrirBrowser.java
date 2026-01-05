package tasks.desktop.prometheus;

import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.Actor;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class AbrirBrowser implements Task   {
    private String browser;


    public AbrirBrowser(String browser){
        this.browser = browser;
    }

    public static AbrirBrowser Chrome(){
        return Tasks.instrumented(AbrirBrowser.class, "Chrome");
    }



    @Override
    public <T extends Actor> void performAs(T actor){
        Screen screen = new Screen();
        ImagePath.add("src/test/resources/imgs/prometheus");
        try {
            // Define image patterns for the browser icon and address bar
            Pattern browserIcon = new Pattern("chromeIcono.jpg");
            Pattern addressBar = new Pattern("buscador.jpg");
            // Click on the browser icon to open it
            screen.click(browserIcon);
            // Wait for the address bar to appear
            screen.wait(addressBar, 10);
            // Click on the address bar and type a URL
            screen.click(addressBar);
            screen.type("https://www.google.com\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
