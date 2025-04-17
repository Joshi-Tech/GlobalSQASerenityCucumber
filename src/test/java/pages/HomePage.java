package pages;

import lombok.AllArgsConstructor;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static util.ExtractString.getString;

@AllArgsConstructor
public class HomePage extends PageObject {

    @Managed
    WebDriver driver;

    public void openUrl() {
        openUrl(getString("baseUrl"));
        getDriver().manage().window().maximize();
        if (find(By.xpath("//p[text()='Consent']")).isPresent()) {
            find(By.xpath("//p[text()='Consent']")).click();
        } else {
            //do nothing
        }
        Serenity.reportThat("Global SQA home page opens: ",
                () -> Assert.assertEquals(getString("homePage.title"), getDriver().getTitle()));
    }
}
