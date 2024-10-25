package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;


import java.io.IOException;
import java.time.Duration;

public class LoginSteps extends CommonMethods {
    //LoginPage loginPage=new LoginPage();

    @Given("user is able to access HRMS application")
    public void user_is_bale_to_access_hrms_application() {
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Then("user  only enters password")
    public void user_only_enters_password() throws IOException {
        // passwordField.sendKeys("Hum@nhrm123");
        sendText(ConfigReader.read("password"),loginPage.passwordField);


    }
    @Then("user enters log in button")
    public void user_enters_log_in_button() {
        waitForElementToBeClickable(loginPage.LoginBt);



    }
    @Then("user can see error message\"Username cannot be empty\"")
    public void user_can_see_error_message_username_cannot_be_empty() {
        String uSactualMessage = loginPage.userspamMessage.getText();
        Assert.assertEquals("Username cannot be empty", uSactualMessage);


    }
    @Then("user only enters username")
    public void user_only_enters_username() throws IOException {
        //userField.sendKeys("admin");
        sendText(ConfigReader.read("userName"),loginPage.userField);
    }
    @Then("user can see error message\"Password is empty\"")
    public void user_can_see_error_message_password_is_empty() {

        String passActualMessage= loginPage.userspamMessage.getText();
        Assert.assertEquals("Password is Empty",passActualMessage);
    }

    @Then("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() throws IOException {

        // WebElement userField =driver.findElement(By.id("txtUsername"));
        //  WebElement passwordField =driver.findElement(By.id("txtPassword"));
        sendText(ConfigReader.read("InvalidUsername"),loginPage.userField);
        sendText(ConfigReader.read("InvalidPassword"),loginPage.passwordField);
    }
    @Then("user can see error message\"Invalid credentials")
    public void user_can_see_error_message_invalid_credentials() {
        String uSactualMessage= loginPage.userspamMessage.getText();
        Assert.assertEquals("Invalid credentials",uSactualMessage);
    }
    @Then("user clearly can see error message")
    public void user_clearly_can_see_error_message() {
        WebElement spvisible =driver.findElement(By.id("spanMessage"));
        spvisible.isDisplayed();
    }
    @Then("it is placed near the respective input fields")
    public void it_is_placed_near_the_respective_input_fields() {
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertTrue(loginPage.isLocatedNearLoginBt());

    }
    @Then("users enters valid userName and Password")
    public void users_enters_valid_user_name_and_password() throws IOException {

        sendText(ConfigReader.read("password"),loginPage.passwordField);
        sendText(ConfigReader.read("userName"),loginPage.userField);
    }
    @Then("user can see dashboard")
    public void user_can_see_dashboard() {
        loginPage.WelcomeDash.isDisplayed();
    }

    @Then("username and password should be clear again")
    public void username_and_password_should_be_clear_again() {
        loginPage.userField.getText().isEmpty();
        loginPage.passwordField.getText().isEmpty();

    }










}