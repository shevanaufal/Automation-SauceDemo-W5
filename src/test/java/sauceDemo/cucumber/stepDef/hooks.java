package sauceDemo.cucumber.stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import sauceDemo.cucumber.config.environment;

//Hooks Driver
public class hooks extends environment {
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        driver = new ChromeDriver(opt);

        driver.manage().window().maximize();
        driver.get(baseUrl);
    }


    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()){
            driver.manage().deleteAllCookies();
        }
        driver.quit();
    }
}
