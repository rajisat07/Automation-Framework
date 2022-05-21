package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.extentReport_Utility;

public class login_Page {
    WebDriver driver;

    public login_Page(WebDriver driver)
    {
        this.driver=driver;
    }

    public void enterUsername(String username)
    {
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
        extentReport_Utility.logger.log(Status.INFO,"Succesfully entered Username: "+username);
    }
    public void enterPassword(String password)
    {
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
        extentReport_Utility.logger.log(Status.INFO,"Succesfully entered Password: "+password);
    }
    public void clickSignIn() {
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

        extentReport_Utility.logger.log(Status.INFO, "Succesfully clicked on Sign In");
    }
    public void logout() throws InterruptedException {
        driver.findElement(By.xpath("//a[@id='welcome']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        extentReport_Utility.logger.log(Status.INFO, "Succesfully Logged out");

    }

}
