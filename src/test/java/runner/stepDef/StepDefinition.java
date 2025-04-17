package runner.stepDef;

import actions.HomePageActions;
import hook.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import pages.DatePickerPage;
import pages.DialogBoxPage;

import static enums.MenuItemsID.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.ExtractString.getString;

public class StepDefinition extends Hook {

    @Steps
    HomePageActions homePageActions;

    @Steps
    DatePickerPage datePickerPage;

    @Steps
    DialogBoxPage dialogBoxPage;

    @Given("I go the home page")
    public void i_go_the_home_page() {
        homePageActions.openPage();
    }

    @Given("User is on DatePicker page")
    public void user_is_on_date_picker_page() {
        homePageActions.openPage();
        homePageActions.hoverOver(TESTERS_HUB.getId(), DEMO_TESTING_SITE.getId(), DATE_PICK.getId());
    }

    @Given("user goes to the Dialog Box")
    public void user_goes_to_the_dialog_box() {
        homePageActions.openPage();
        homePageActions.hoverOver(TESTERS_HUB.getId(), DEMO_TESTING_SITE.getId(), DIALOG_BOX.getId());
    }


    @Given("user is on dialog box page")
    public void user_is_on_dialog_box_page() {
        homePageActions.openPage();
        homePageActions.hoverOver(TESTERS_HUB.getId(), DEMO_TESTING_SITE.getId(), DIALOG_BOX.getId());
    }

    @When("they click create user button")
    public void they_click_create_user_button() {
        dialogBoxPage.clickCreateUserButton();
    }

    @When("they provide name {string}, email {string} and password {string}")
    public void they_provide_name_email_and_password(String userName, String email, String password) {
        dialogBoxPage.userDetails(userName, email, password);
    }

    @When("they select month {string} year {string}")
    public void they_select_month_year(String month, String year) {
        datePickerPage.simpleDatePicker(month + " " + year);
    }

    @When("they select date {string}")
    public void they_select_date(String date) {
        datePickerPage.selectDate(date);
    }

    @When("I click Date picker link within Tester's Hub")
    public void i_click_date_picker_link_within_tester_s_hub() {
        homePageActions.hoverOver(TESTERS_HUB.getId(), DEMO_TESTING_SITE.getId(), DATE_PICK.getId());
    }

    @When("I click Alert link within Tester's Hub")
    public void i_click_alert_link_within_tester_s_hub() {
        homePageActions.hoverOver(TESTERS_HUB.getId(), DEMO_TESTING_SITE.getId(), ALERT_BOX.getId());
    }

    @Then("I'll be in DatePicker page")
    public void i_ll_be_in_date_picker_page() {
        Serenity.reportThat("Date picker page is open",
                () -> assertEquals(getString("date.picker"), $(".page_heading").getText()));
    }

    @Then("I'll be in Alert page")
    public void i_ll_be_in_alert_page() {
        Serenity.reportThat("Date picker page open",
                () -> assertEquals(getString("alert.box"), $(".page_heading").getText()));
    }

    @Then("they will have date as {string}")
    public void they_will_have_date_as(String expectedDate) {
        assertEquals(expectedDate, datePickerPage.getDate());
    }

    @Then("they can see user name {string}")
    public void they_can_see_user_name(String userName) {
        assertEquals(getString("person.name"), dialogBoxPage.getUserDetails(userName));
    }

    @Then("they can see user name {string} in the existing users list")
    public void they_can_see_user_name_in_the_existing_users_list(String userName) {
        assertEquals(userName, dialogBoxPage.getUserDetails("Ram Singh"));
    }


    @When("they click on {string} tab")
    public void they_click_on_tab(String tab) {
        dialogBoxPage.clickOnTab(tab);
    }

    @Then("they can see for {string} message {string}")
    public void they_can_see_for_message(String tab, String message) {
        assertEquals(message, dialogBoxPage.getEmptyRecycleBinBoxText(tab));
    }
}
