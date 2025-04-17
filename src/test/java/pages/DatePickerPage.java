package pages;

import net.serenitybdd.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.stream.Collectors;

public class DatePickerPage extends PageObject {

    @Step
    public void simpleDatePicker(String monthAndYear) {
        WebElement frameElement = $("[class*='demo-frame']");
        getDriver().switchTo().frame(frameElement);
        $("#datepicker").click();
        while (!$(".ui-datepicker-title").getText().equals(monthAndYear)) {
            $("[data-handler='next']").click();
        }
    }

    public void selectDate(String date) {
        $$("[data-handler='selectDay']")
                .stream().filter(x -> x.getText().equals(date))
                .collect(Collectors.toList())
                .get(0)
                .click();
    }

    public String getDate() {
        return $("[class='hasDatepicker']").getValue();
    }
}
