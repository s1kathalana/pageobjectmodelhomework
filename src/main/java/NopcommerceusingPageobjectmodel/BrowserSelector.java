package NopcommerceusingPageobjectmodel;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserSelector extends Utils {
LoadProp props = new LoadProp();

public void setUpBrowser()
{
    String browser = props.getProperty("browser");
    if(browser.equalsIgnoreCase("chrome"))
    {
        System.setProperty("webdriver.chrome.driver","src\\test\\Resources\\BrowserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }


    else if(browser.equalsIgnoreCase("Firefox"))
    {
        System.setProperty("webdriver.gecko.driver","src\\test\\Resources\\BrowserDriver\\geckodriver.exe");
        driver = new FirefoxDriver();
    }


    else if(browser.equalsIgnoreCase("InternetExplorer"))
    {
        System.setProperty("webdriver.ie.driver","src\\test\\Resources\\BrowserDriver\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
    }

    else
    {
        System.out.println("wrong browser");
    }
}

}
