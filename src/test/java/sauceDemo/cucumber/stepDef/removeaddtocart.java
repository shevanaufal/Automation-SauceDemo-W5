package sauceDemo.cucumber.stepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sauceDemo.cucumber.config.environment;

import java.time.Duration;

//Scenario Remove Add to Cart
public class removeaddtocart extends environment {

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
