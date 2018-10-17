package fwk;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


import java.time.Duration;

public class Utils {
    AppiumDriver driver;

    public Utils(AppiumDriver driver) {
        this.driver = driver;
    }

    public void swipe(int[] from, int[] to, int delay) {
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(from[0], from[1])).
                waitAction(WaitOptions.waitOptions(Duration.ofMillis(delay))).
                moveTo(PointOption.point(to[0], to[1])).release().perform();
    }
}
