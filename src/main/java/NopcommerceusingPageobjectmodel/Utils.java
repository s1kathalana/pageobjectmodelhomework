package NopcommerceusingPageobjectmodel;
import NopcommerceusingPageobjectmodel.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BasePage {
    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public void enterText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public String generateEmail(String startValue) {
        String email = startValue.concat(new Date().toString());
        return email;
    }

    public static String randomDate() {
        DateFormat format = new SimpleDateFormat("ddMMyyHHmmss");
        return format.format(new Date());
    }

    public String getTextFromElement(By by) {
        String actual = driver.findElement(by).getText();
        return actual;

    }

    public static void waitforClickable(By by, long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitforAlertPresent(long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void waitforElementVisible(By by, long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void selectByText(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public static void selectByValue(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(text);
    }
    public static void capturescreenshot()
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source,new File("src\\test\\Resources\\Screenshots"+randomDate()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void delay() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}


