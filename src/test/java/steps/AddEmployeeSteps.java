package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;

import java.io.IOException;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on PIM button")
    public void user_clicks_on_pim_button() {
        // addEmployeePage.pimButton.click();
        waitForElementToBeClickable(addEmployeePage.pimButton);
    }
    @When("user clicks on AddEmployee")
    public void user_clicks_on_add_emploee() {
        waitForElementToBeClickable(addEmployeePage.AddEmployBt);
    }
    @When("user enters employee firstName, middleName and lastName")
    public void user_enters_employee_first_name_middle_name_and_last_name() throws IOException {
        sendText(ConfigReader.read("firstname"),addEmployeePage.firstNameLocator);
        sendText(ConfigReader.read("middlename"), addEmployeePage.middleNameLocator);
        sendText(ConfigReader.read("lastname"), addEmployeePage.lastNameLocator);




    }
    @Then("employee id is generated automatically")
    public void employee_id_is_generated_automaticaly() {
        addEmployeePage.IdField.isDisplayed();

    }

    @When("user clicks on SaveBt")
    public void user_clicks_on_save_bt() {
        waitForElementToBeClickable(addEmployeePage.saveBT);
    }


    @Then("employee is added successfully")
    public void employee_is_added_succesfully() {
        addEmployeePage.IsAdded.isDisplayed();
    }

    @When("user clears Id field and enters new id")
    public void user_clears_id_field_and_enters_new_id() throws IOException {
        addEmployeePage.IdField.clear();
        sendText(ConfigReader.read("userId"), addEmployeePage.IdField);
        ConfigReader.incrementUserId();
    }
    @When("user enters employee firstName")
    public void user_enters_employee_first_name() throws IOException {
        sendText(ConfigReader.read("firstname"),addEmployeePage.firstNameLocator);
    }
    @Then("lastName error is displayed")
    public void last_name_error_is_displayed() {
        addEmployeePage.LasterrorMessage.isDisplayed();
    }
    @When("user enters employee lastname")
    public void user_enters_employee_lastname() throws IOException {
        sendText(ConfigReader.read("lastname"), addEmployeePage.lastNameLocator);
    }
    @Then("the firstname error is displayed")
    public void the_firstname_error_is_displayed() {
        addEmployeePage.firstNameError.isDisplayed();

    }
    @When("user enters existing IdNumber")
    public void user_enters_existing_id_number() throws IOException {
        sendText(ConfigReader.read("existingUserid"), addEmployeePage.IdField);

    }
    @Then("existing id error is displayed")
    public void existing_id_error_is_displayed() {
        addEmployeePage.ExistingIdError.isDisplayed();

    }






}