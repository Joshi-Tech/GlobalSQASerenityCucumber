package pages;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.stream.Collectors;

import static util.ExtractString.getString;

public class DialogBoxPage extends PageObject {

    @Step
    public String getUserDetails(String user) {
        WebElement frameElement = $("[class*='demo-frame lazyloaded']");
        getDriver().switchTo().frame(frameElement);
        ListOfWebElementFacades userDetails = $$("#users>tbody>tr>td");
        return userDetails.stream().filter(x -> x.getText().equals(user)).collect(Collectors.toList())
                .get(0).getText();
    }

    public void clickCreateUserButton() {
        WebElement frameElement = $("[class*='demo-frame lazyloaded']");
        getDriver().switchTo().frame(frameElement);
        $("[id='create-user']").click();
    }

    public void userDetails(String name, String email, String password) {
        $("[id='name']").clear();
        $("[id='name']").sendKeys(name);
        $("[id='email']").clear();
        $("[id='email']").sendKeys(email);
        $("[id='password']").clear();
        $("[id='password']").sendKeys(password);
        $$("[class='ui-dialog-buttonset']>button").stream()
                .filter(x -> x.getText().equals("Create an account"))
                .collect(Collectors.toList()).get(0).click();
        getDriver().switchTo().parentFrame();
    }

    public String clickOnTab(String tab) {
        WebElement tabName = $("[id='" + tab + "']");
        tabName.click();
        String confirmationText = tabName.getText();
        if (tab.equals(getString("Confirmation.Box"))) {
            WebElement confirmationFrame = $("[data-src*='modal-confirmation.html']");
            getDriver().switchTo().frame(confirmationFrame);
        } else {
            WebElement dialogueMessageFrame = $("iframe[data-src*='modal-message.html']");
            getDriver().switchTo().frame(dialogueMessageFrame);
        }
        return confirmationText;
    }

    public String getEmptyRecycleBinBoxText(String tab) {
        if (tab.equals(getString("Confirmation.Box"))) {
            return $("[id='dialog-confirm']>p").getText();
        } else {
            return $$("#dialog-message>p").get(0).getText();
        }
    }
}
