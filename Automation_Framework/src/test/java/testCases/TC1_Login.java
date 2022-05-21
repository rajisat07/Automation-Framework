package testCases;

import baseClass.driverInstance;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.login_Page;
import utilities.excel_Utility;

import java.io.IOException;

public class TC1_Login extends driverInstance {
    @Test(dataProvider = "credentials")
    public void validateLogin(String username, String password) throws InterruptedException {
    login_Page login= new login_Page(driver);
    login.enterUsername(username);
    login.enterPassword(password);
    login.clickSignIn();
    Assert.assertEquals("https://opensource-demo.orangehrmlive.com/index.php/dashboard",driver.getCurrentUrl());
    Thread.sleep(3000);

    login.logout();


    }
    @DataProvider(name="credentials")
    public Object[][] dataprovider () throws IOException {

        //Object[][] test = new Object[][]  {{"Admin","admin123"},{"Basil","admin"}};

        excel_Utility.setExcelFile("./src/test/resources/testData/testData.xlsx","testSheet");
        String testcasename=this.getClass().getSimpleName();
        int startingtestcaseRow=excel_Utility.getrowcontains(testcasename);

        Object[][] tablearray=excel_Utility.getExcelTableData(startingtestcaseRow);

        return tablearray;
    }

}
