package sauceDemo.cucumber.stepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import sauceDemo.cucumber.config.environment;

////Scenario: Success logout
public class logout extends environment {

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
}
