package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"steps"},
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true,
    tags="@CT_01"
)
public class CT_01_ComprarCamisaRunner {
}
