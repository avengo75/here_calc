package pages;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HistoryPage {
    AppiumDriver driver;

    public HistoryPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private static final String[] FORMULAS = new String[]{"2+3", "10−2", "8×2", "sin(30"};
    private static final String[] FORMULA_RESULTS = new String[]{"5", "8", "16", "0.5"};
    private List<WebElement> formulas;
    private List<WebElement> results;
    private static final String FORMULA_ID = "history_formula";
    public static final String FORMULA_RESULT_ID = "history_result";

    public List<WebElement> getFormulas() {
        System.out.println("Getting list of formulas from History tab...");
        return driver.findElements(By.id(FORMULA_ID));
    }

    public List<WebElement> getFormulaResults() {
        System.out.println("Getting list of results from History tab...");
        return driver.findElements(By.id(FORMULA_RESULT_ID));
    }

    public void historyCheck() {
        formulas = getFormulas();
        results = getFormulaResults();
        Assert.assertEquals("The number of formulas in History is wrong", FORMULAS.length, formulas.size());
        System.out.println("Verifing lists of formulas and results from History tab...");
        for (int i = 0; i < formulas.size(); i++) {
            Assert.assertEquals("Formula is displayed incorrectly in History", FORMULAS[i], formulas.get(i).getText());
            Assert.assertEquals("Formula result is displayed incorrectly in History", FORMULA_RESULTS[i], results.get(i).getText());
        }
    }


}
