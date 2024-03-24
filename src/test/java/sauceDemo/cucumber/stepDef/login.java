package sauceDemo.cucumber.stepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import sauceDemo.cucumber.config.environment;

import java.util.concurrent.TimeUnit;

//Scenario Login
public class login extends environment {
    @Given("sauce demo login page")
    public void sauce_demo_login_page(){
       // WebDriverManager.chromedriver().setup();
        //driver.manage().window().maximize();
        //driver.get(url);
        //timeout
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String loginAssert = driver.findElement(By.xpath("//div[@class=\"login_logo\"]")).getText();
        Assert.assertEquals(loginAssert, "Swag Labs");
    }

    //This is for TDD purpose

    @When("user input (.*) as username$")
    public void user_input_username_as_username(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("user input (.*) as password$")
    public void user_input_username_as_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("click login button")
    public void click_login_button() {
        driver.findElement(By.xpath("//input[@id=\"login-button\"]")).click();
    }

    @Then("user verify (.*) login$")
    public void user_verify_status_login(String status) {
        if (status.equals("success")){
            String products = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
            Assert.assertEquals(products,"Products");
        } else {
            String ErrorLogin = driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).getText();
            Assert.assertEquals(ErrorLogin,"Epic sadface: Username and password do not match any user in this service");
        }
    }

}
