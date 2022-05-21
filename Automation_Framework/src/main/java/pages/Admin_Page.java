package pages;

import baseClass.driverInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Admin_Page
{
    WebDriver driver;
    public Admin_Page(WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickonAdmin()
    {
        driver.findElement(By.xpath("//b[text()='Admin']")).click();
    }
    public void clickonAdd()
    {
        driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
    }
    public void addUserRole(String userrole)
    {

        Select s=new Select(driver.findElement(By.id("systemUser_userType")));
        //select[@id='systemUser_userType']
        s.selectByVisibleText(userrole);
        //s.selectByVisibleText("ESS");
    }
    public void addEmployeeName(String empname)
    {
        driver.findElement(By.xpath("//input[@id='systemUser_employeeName_empName']")).sendKeys(empname);
    }
    public void addUserName(String username)
    {
        driver.findElement(By.xpath("//input[@id='systemUser_userName']")).sendKeys(username);
    }
    public void addStatus(String status)
    {
        Select s=new Select(driver.findElement(By.id("systemUser_status")));
        //select[@id='systemUser_userType']
        s.selectByVisibleText(status);
       // s.selectByVisibleText("Disabled");
    }
    public void addPassword(String password)
    {
        driver.findElement(By.xpath("//input[@id='systemUser_password']")).sendKeys(password);
    }
    public void confirmPassword(String confpassword)
    {
        driver.findElement(By.xpath("//input[@id='systemUser_confirmPassword']")).sendKeys(confpassword);
    }
    public void save()
    {
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();
    }
    public void cancel()
    {
        driver.findElement(By.xpath("//input[@id='btnCancel']")).click();
    }


}
