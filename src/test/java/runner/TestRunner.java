package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/",
        glue = { "stepDefinitions" },
        plugin = {"json:target/cucumber.json"},
        tags = "not @ignore"


)
public class TestRunner {
}
