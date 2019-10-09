package NopcommerceusingPageobjectmodel;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationPage extends Utils
{

    LoadProp props = new LoadProp();

    private By _firstName = By.id("FirstName");
    private By _lastName = By.id("LastName");
    private By _email = By.id("Email");
    private By _password = By.id("Password");
    private By _confirmPassword = By.id("ConfirmPassword");
    private By _registerButton = By.id("register-button");

    public void verifythatuserregisteredsuccessfully()
    {
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class='result']")),"Your registration completed");
    }

    public void clickOnRegisterbutton()
    {
        clickOnElement(By.xpath("//a[@class='ico-register']"));
    }


    public void verifyuserisonregisterpage()
    {
        Assert.assertEquals(getTextFromElement(By.xpath("//h1['Register']")),"Register");
    }
    public void userenterregistrationdetails()
    {
        enterText(_firstName,props.getProperty("firstName"));
        enterText(_lastName,props.getProperty("lastName"));
        enterText(_email, (generateEmail("").replaceAll("[^a-zA-Z0-9]", "")) +"@gmail.com");
        System.out.println((generateEmail("").replaceAll("[^a-zA-Z0-9]", "")) +"@gmail.com");
        enterText(_password,props.getProperty("password"));
        enterText(_confirmPassword,props.getProperty("confirmPassword"));
        clickOnElement(_registerButton);
    }

}



