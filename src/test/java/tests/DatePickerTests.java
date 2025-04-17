package tests;

import actions.HomePageActions;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static enums.MenuItemsID.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SerenityJUnit5Extension.class)
class DatePickerTests extends UIInteractionSteps {

    @Steps
    HomePageActions homePageActions;

    @BeforeEach
    public void launchHomePage() {
        homePageActions.openPage();
    }

    @Test
    void userNavigatesToDatePickerPage() {
        homePageActions.hoverOver(TESTERS_HUB.getId(), DEMO_TESTING_SITE.getId(), DATE_PICK.getId());
        Serenity.reportThat("Date picker page open",
                () -> assertEquals("DatePicker", $(".page_heading").getText()));
    }

    @Test
    void userNavigatesToAlertBox() {
        homePageActions.hoverOver(TESTERS_HUB.getId(), DEMO_TESTING_SITE.getId(), ALERT_BOX.getId());
        Serenity.reportThat("Date picker page open",
                () -> assertEquals("AlertBox", $(".page_heading").getText()));
    }
}
