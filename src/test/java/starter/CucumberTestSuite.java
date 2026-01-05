package starter;

import io.cucumber.java.BeforeAll;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("/features")
@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value = "io.cucumber.core.plugin.SerenityReporterParallel,pretty,timeline:build/test-results/timeline"
)
// 👇 Aquí defines el tag que quieres ejecutar
@ConfigurationParameter(
        key = FILTER_TAGS_PROPERTY_NAME,
        //value = "@all"   // Cambia @smoke por el tag que quieras
        value = "@restAssuredEj"
)
public class CucumberTestSuite {
    private static final Logger logger = LoggerFactory.getLogger(CucumberTestSuite.class);

    @BeforeAll
    static void logEnvironment() {
        logger.info("Java version: {}", System.getProperty("java.version"));
    }

}
