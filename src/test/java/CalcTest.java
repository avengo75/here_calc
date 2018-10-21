import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import pages.AdvancedPage;
import pages.HistoryPage;
import pages.MainPage;
import pages.MoreOptionsPopUpPage;

public class CalcTest {
    AppiumDriver driver;
    private MainPage mainPage;
    private HistoryPage historyPage;
    private AdvancedPage advancedPage;
    private static final String DEVICE_NAME = "emulator-5554";
    private static final String APPIUM_URL = "http://127.0.0.1";
    private static final int APPIUM_PORT = 4723;

    @Before
    public void setupTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platormName", MobilePlatform.ANDROID);
        capabilities.setCapability("deviceName", DEVICE_NAME);
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        driver = new AndroidDriver<MobileElement>(new URL(APPIUM_URL + ":" + APPIUM_PORT + "/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
    }

    @Test
    public void CalculatorTest() {

        mainPage.sum("2", "3");
        Assert.assertEquals("Intermediate result is wrong ", "5", mainPage.getResult());
        mainPage.clickEqual();
        Assert.assertEquals("Final result is wrong ", "5", mainPage.getResult());

        mainPage.subtract("10", "2");
        Assert.assertEquals("Intermediate result is wrong ", "8", mainPage.getResult());
        mainPage.clickEqual();
        Assert.assertEquals("Final result is wrong ", "8", mainPage.getResult());

        mainPage.multiplyBy("2");
        Assert.assertNotEquals("Intermediate result is wrong ", "20", mainPage.getResult());
        mainPage.clickEqual();
        Assert.assertNotEquals("Final result is wrong ", "20", mainPage.getResult());

        mainPage.clickCLR();
        advancedPage = mainPage.openOperatorsTab();
        advancedPage.switchRadDeg();
        advancedPage.clickSinus();
        mainPage = advancedPage.closeOperatorsTab();
        mainPage.typeNumber("30");
        Assert.assertEquals("Intermediate result is wrong ", "0.5", mainPage.getResult());
        mainPage.clickEqual();
        Assert.assertEquals("Final result is wrong ", "0.5", mainPage.getResult());

        MoreOptionsPopUpPage moreOptionsPopUpPage = mainPage.clickMoreOptions();
        historyPage = moreOptionsPopUpPage.clickHistory();
        historyPage.historyCheck();

    }

    @After
    public void tearDown() {
        driver.closeApp();
    }


}
