<<<<<<< HEAD
//package ui.qa.runners;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = "src/test/resources/features",
//        glue = "ui/qa/stepdefinitions",
//        dryRun = false,
//        tags = "",
//        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt",
//                "json:target/cucumber-reports/cucumber.json"}
//)
//public class APIRunner {
//}
=======
package ui.qa.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "",
        glue = "",
        dryRun = false,
        tags = "",
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt",
                "json:target/cucumber-reports/cucumber.json"}
)
public class Runner {
}
>>>>>>> a2449daa31dd99644a30ecd6ac12006d2ac9672e
