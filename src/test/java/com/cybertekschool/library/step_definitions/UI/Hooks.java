package com.cybertekschool.library.step_definitions.UI;


import com.cybertekschool.library.utils.common.Environment;
import com.cybertekschool.library.utils.ui.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp() {
        String browser = Environment.getProperty("browser");
        if(!browser.contains("mobile")){
            Driver.getDriver().manage().window().maximize();
        }
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", "screenshot");
        }

        Driver.closeDriver();
    }

}
