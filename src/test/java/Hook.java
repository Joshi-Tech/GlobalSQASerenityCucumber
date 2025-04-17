import actions.HomePageActions;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractions;
import org.junit.jupiter.api.BeforeEach;


public class Hook extends UIInteractions {

    @Steps
    HomePageActions homePageActions;

    @BeforeEach
    public void launchHomePage() {
        homePageActions.openPage();
    }
}
