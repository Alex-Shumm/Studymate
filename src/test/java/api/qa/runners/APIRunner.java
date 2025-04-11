package api.qa.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/api_features",
        glue = "api/qa/stepdefinitions",
        dryRun = false,
        tags = "@api",
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt",
                "json:target/cucumber-reports/cucumber.json"}
)

public class APIRunner {
}
