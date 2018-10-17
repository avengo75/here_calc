package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoreOptionsPopUpPage {
    AppiumDriver driver;

    @FindBy(xpath = "//android.widget.TextView[@text='History']")
    WebElement history;

    public MoreOptionsPopUpPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HistoryPage clickHistory() {
        System.out.println("Opening 'History'...");
        history.click();
        return new HistoryPage(driver);
    }

}
