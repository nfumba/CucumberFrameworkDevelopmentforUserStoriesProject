package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimButton;

    @FindBy(id="menu_pim_addEmployee")
    public WebElement AddEmployBt;

    @FindBy(id="firstName")
    public WebElement firstNameLocator;

    @FindBy(id="middleName")
    public WebElement middleNameLocator;

    @FindBy(id="lastName")
    public WebElement lastNameLocator;

    @FindBy(id="employeeId")
    public WebElement IdField;

    public boolean fieldID(){
        addEmployeePage.IdField.getText().isEmpty();
        return false;
    }
    @FindBy(id="btnSave")
    public WebElement saveBT;

    @FindBy(id="personal_txtNICNo")
    public WebElement IsAdded;

    @FindBy(xpath = "//span[@class='validation-error']")
    public WebElement LasterrorMessage;

    @FindBy(xpath = "//span[@for='firstName']")
    public WebElement firstNameError;

    @FindBy(xpath = "//div[@class='message warning fadable']")
    public WebElement ExistingIdError;




    public AddEmployeePage(){
        PageFactory.initElements(driver,this);
    }

}