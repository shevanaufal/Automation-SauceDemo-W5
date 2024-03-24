package sauceDemo.cucumber.stepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import sauceDemo.cucumber.config.environment;

////Scenario: Success Checkout
public class checkout extends environment {

    @When("click shopping cart icon")
    public void click_shopping_cart_icon(){
        driver.findElement(By.xpath("//div[@class=\"shopping_cart_container\"]")).click();
    }

    @Then("click checkout button")
    public void click_checkout_button() {
        driver.findElement(By.xpath("//button[@id=\"checkout\"]")).click();
    }

    @Then("user input (.*) as firstname$")
    public void user_input_firstname_as_firstname(String firstname) {
        driver.findElement(By.id("first-name")).sendKeys(firstname);
    }

    @And("user input (.*) as lastname$")
    public void user_input_lastname_as_lastname(String lastname) {
        driver.findElement(By.id("last-name")).sendKeys(lastname);
    }

    @And("user input (.*) as postalcode$")
    public void user_input_postalcode_as_postalcode(String postalcode) {
        driver.findElement(By.id("postal-code")).sendKeys(postalcode);
    }

    @Then("user click continue button")
    public void user_click_continue_button() {
        driver.findElement(By.xpath("//input[@id=\"continue\"]")).click();
    }

    @Then("user click finish button")
    public void user_click_finish_button() {
        driver.findElement(By.xpath("//button[@id=\"finish\"]")).click();
    }

    @Then("user successfully checkout")
    public void user_successfully_checkout() {
        String checkoutAssert = driver.findElement(By.xpath("//h2[@class=\"complete-header\"]")).getText();
        Assert.assertEquals(checkoutAssert, "Thank you for your order!");
    }
}
