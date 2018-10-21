package pages;

import fwk.Utils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvancedPage {
    AppiumDriver driver;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='More options']")
    WebElement moreOptions;

    @FindBy(id = "toggle_mode")
    WebElement toggleRadDeg;

    @FindBy(id = "fun_sin")
    WebElement sinus;

    private final static int[] LEFT_ADVANCED = new int[]{300, 1000};
    private final static int[] RIGHT_ADVANCED = new int[]{1000, 1000};
    private static final int DELAY = 1000;
    Utils utils;

    public AdvancedPage(AppiumDriver driver) {
        this.driver = driver;
        utils = new Utils(driver);
        PageFactory.initElements(driver, this);
    }

    public void switchRadDeg() {
        System.out.println("Switching between radians and degrees...");
        toggleRadDeg.click();
    }

    public void clickSinus() {
        System.out.println("Clicking Sinus...");
        sinus.click();
    }

    public MainPage closeOperatorsTab() {
        System.out.println("Closing Operators tab...");
        utils.swipe(LEFT_ADVANCED, RIGHT_ADVANCED, DELAY);
        return new MainPage(driver);
    }
}
