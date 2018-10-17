package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    AppiumDriver driver;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"More options\"]")
    WebElement moreOptions;

    @FindBy(id = "pad_advanced")
    WebElement pad_operators;

    @FindBy(id = "op_add")
    WebElement plus;

    @FindBy(id = "clr")
    WebElement clr;


    @FindBy(id = "op_sub")
    WebElement minus;

    @FindBy(id = "result")
    WebElement result;

    @FindBy(id = "eq")
    WebElement equal;

    @FindBy(id = "op_mul")
    WebElement multiply;

    public MainPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickDigit(char digit) {
        driver.findElement(By.id("digit_" + digit)).click();
    }

    public void clickPlus() {
        plus.click();
    }

    public void clickMinus() {
        minus.click();
    }

    public void clickMultiply() {
        multiply.click();
    }

    public void sum(String a, String b) {
        System.out.println("Summing " + a + " and " + b + " ...");
        typeNumber(a);
        clickPlus();
        typeNumber(b);
    }

    public String getResult() {
        return result.getText();
    }

    public void clickEqual() {
        equal.click();
    }

    public void subtract(String a, String b) {
        System.out.println("Subtracting  " + b + " from " + a + " ...");
        typeNumber(a);
        clickMinus();
        typeNumber(b);
    }


    public void typeNumber(String a) {
        for (char dig : a.toCharArray()) {
            clickDigit(dig);
        }
    }

    public void multiplyBy(String sec) {
        System.out.println("Multiplying by " + sec + " ...");
        clickMultiply();
        typeNumber(sec);
    }

    public void clickCLR() {
        clr.click();
    }

    public MoreOptionsPopUpPage clickMoreOptions() {
        System.out.println("Opening 'More Options' tab...");
        moreOptions.click();
        return new MoreOptionsPopUpPage(driver);
    }

    public AdvancedPage openOperators() {
        System.out.println("Opening 'Advanced' tab...");
        pad_operators.click();
        return new AdvancedPage(driver);
    }
}
