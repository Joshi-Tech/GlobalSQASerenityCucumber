package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)  // Use Serenity Runner
@CucumberOptions(
        features = "src/test/resources/features",  // Path to feature files
        glue = "runner.stepDef",  // Package containing step definitions
        plugin = {"pretty", "html:target/cucumber-reports.html"} // Reports
        //tags = "@DatePicker"  // Run specific scenarios (optional)
)
public class CucumberTestSuite {
}
