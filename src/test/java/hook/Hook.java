package hook;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class Hook extends UIInteractionSteps {

    @BeforeAll
    public static void setup() {
        // Initialize the browser session
        Serenity.initializeTestSession();
        System.out.println("=== Starting the Test Suite ===");
    }

    @AfterAll
    public static void tearDown() {
        // Close the browser session after all scenarios
        ThucydidesWebDriverSupport.getDriver().quit();
        System.out.println("=== Closing the Test Suite ===");
    }
}
