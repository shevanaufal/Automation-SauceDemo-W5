package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class mainProgram {
    WebDriver driver = new ChromeDriver();
    String baseUrl = "https://www.saucedemo.com/";

    @Given("sauce demo login page")
    public void sauce_demo_login_page(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.get(baseUrl);
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

    ////Scenario: Success logout

    @Then("click burger button")
    public void click_burger_menu() {
        driver.findElement(By.xpath("//button[text()=\"Open Menu\"]")).click();
    }

    @And("click logout button")
    public void click_logout_button() {
        driver.findElement(By.xpath("//a[@id=\"logout_sidebar_link\"]")).click();
    }

    @Then("user successfully logout")
    public void user_successfully_logout() {
        String loginAssert = driver.findElement(By.xpath("//div[@class=\"login_logo\"]")).getText();
        Assert.assertEquals(loginAssert, "Swag Labs");
    }

    @And("click addtocart button")
    public void click_addtocart_button() {
        driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
    }

    @Then("cart will increase")
    public void cart_will_increase() {
        String cartAssert = driver.findElement(By.xpath("//span[@class='shopping_cart_badge' and text()='1']")).getText();
        Assert.assertEquals(cartAssert, "1");
    }

    @And("click remove button")
    public void click_remove_button() {
        driver.findElement(By.xpath("//button[@id=\"remove-sauce-labs-backpack\"]")).click();
    }

    @Then("product will removed from cart")
    public void product_will_removed_from_cart() {
        Duration timeout = Duration.ofSeconds(10);

        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement addToCartButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-to-cart-sauce-labs-backpack")));
        Assert.assertTrue(addToCartButton.isDisplayed());
    }
}
