package NopcommerceusingPageobjectmodel;

import org.openqa.selenium.By;
import org.testng.Assert;

public class EmailFriend extends Utils {
    LoadProp props = new LoadProp();
    private By _friendEmail = By.xpath("//input[@class='friend-email']");
    private By _personalMessage = By.xpath("//textarea[@class='your-email']");
    private By _clickonsubmit = By.xpath("//input[@class='button-1 send-email-a-friend-button']");
    private By _login = By.xpath("//a[@class=\"ico-login\"]");
    private By _email = By.xpath("//input[@class='email']");
    private By _password = By.xpath("//input[@class='password']");
    private By _loginbutton = By.xpath("//input[@class='button-1 login-button']");
    private By _yourEmail = By.xpath("//input[@class='your-email']");
    private By _unsuccesfultext = By.xpath("//li[text()='Only registered customers can use email a friend feature']");

    public void clickonlogin()
    {
        clickOnElement(_login);
    }

    public void registrationdetails()
    {
        enterText(_email,props.getProperty("Email"));
        enterText(_password,props.getProperty("password"));
        clickOnElement(_loginbutton);
    }


    public void clickonlogo() {
        clickOnElement(By.xpath("//img[@alt='nopCommerce demo store']"));
    }

    public void clickOnProduct() {
        clickOnElement((By.xpath("//img[@alt='Picture of Apple MacBook Pro 13-inch']")));
    }

    public void clickonemailfriendbutton() {
        clickOnElement((By.xpath("//input[@value='Email a friend']")));
    }

    public void registereduserfillingdetails()
    {
        enterText(_friendEmail,props.getProperty("friendEmail"));
        enterText(_personalMessage,props.getProperty("personalMessage"));
        clickOnElement(_clickonsubmit);
    }

    public void verifyemailfriendsuccessful()
    {
        Assert.assertEquals(getTextFromElement(By.xpath("//div[@class='result']")),"Your message has been sent.");

    }

    public void unregistereduserfillingdetails()
    {
        enterText(_friendEmail,props.getProperty("friendEmail"));
        enterText(_yourEmail,props.getProperty("unregisteredEmail"));
        enterText(_personalMessage,props.getProperty("personalMessage"));
        clickOnElement(_clickonsubmit);
    }

    public void verifyunregistereduseremailfriendunsuccessful()
    {
        Assert.assertEquals(getTextFromElement(_unsuccesfultext),"Only registered customers can use email a friend feature");
    }


}