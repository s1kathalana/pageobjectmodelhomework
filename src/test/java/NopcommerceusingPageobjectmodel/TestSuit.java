package NopcommerceusingPageobjectmodel;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestSuit extends BaseTest {


    RegistrationPage registrationPage = new RegistrationPage();
    EmailFriend emailfriend = new EmailFriend();
    BuyProductSuccessfully buyproductsuccess = new BuyProductSuccessfully();
    GuestBuyProductSuccessfully guestcheckout = new GuestBuyProductSuccessfully();


    @Test
    public void usershouldbeabletoregistersuccessfully()
    {
        registrationPage.clickOnRegisterbutton();
        registrationPage.verifyuserisonregisterpage();
        registrationPage.userenterregistrationdetails();
        registrationPage.verifythatuserregisteredsuccessfully();
    }

    @Test
    public void usershouldbeabletoreferproducttofriend() {
        emailfriend.clickonlogin();
        emailfriend.registrationdetails();
        emailfriend.clickonlogo();
        emailfriend.clickOnProduct();
        emailfriend.clickonemailfriendbutton();
        emailfriend.registereduserfillingdetails();
        emailfriend.verifyemailfriendsuccessful();
    }

    @Test
    public void unregisteredusershouldnotbeabletoreferproducttofriend()
    {
        emailfriend.clickonlogo();
        emailfriend.clickOnProduct();
        emailfriend.clickonemailfriendbutton();
        emailfriend.unregistereduserfillingdetails();
        emailfriend.verifyunregistereduseremailfriendunsuccessful();
    }

    @Test
    public void usershouldbeabletobuyproductsuccessfully()
    {
        emailfriend.clickonlogin();
        emailfriend.registrationdetails();
        emailfriend.clickonlogo();
        buyproductsuccess.clickonaddtocart();
        buyproductsuccess.paymentmethod();
        buyproductsuccess.verifyorderplacedsuccessfully();
    }

    @Test
    public void guestshouldbeabletobuyproductsuccessfully()
    {
        buyproductsuccess.clickonaddtocart();
        guestcheckout.clickoncheckoutasguest();
        guestcheckout.fillingguestdetails();
        guestcheckout.guestpaymentdetails();
        guestcheckout.verifyorderplacedsuccessfully();
    }

}
