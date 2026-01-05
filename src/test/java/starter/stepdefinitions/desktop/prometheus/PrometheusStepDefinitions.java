package starter.stepdefinitions.desktop.prometheus;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import tasks.desktop.prometheus.AbrirBrowser;

public class PrometheusStepDefinitions {

    @Given("{actor} open the browser")
    public void abreChrome(Actor actor) {
        actor.attemptsTo(
                AbrirBrowser.Chrome()
        );
    }

    /*
    @When("{actor} looks up {string}")
    public void searchesFor(Actor actor, String term) {
        actor.attemptsTo(
                LookForInformation.about(term)
        );
    }

    @Then("{actor} should see information about {string}")
    public void should_see_information_about(Actor actor, String term) throws AWTException, IOException {
        actor.attemptsTo(
                Ensure.that(TheWebPage.title()).containsIgnoringCase(term)
        );
    }
    */

}
