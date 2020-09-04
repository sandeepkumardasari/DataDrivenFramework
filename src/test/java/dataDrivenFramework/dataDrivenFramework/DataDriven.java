package dataDrivenFramework.dataDrivenFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataDriven {
    
    WebDriver driver;
    @BeforeMethod
    public void run()
    {
    System.setProperty("webdriver.chrome.driver", "C:\\Nextrow\\FFB\\chromedriver.exe");
    driver=new ChromeDriver();
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("https://nextrow-author.adobesandbox.com/libs/granite/core/content/login.html");
    }
    
    @Test(dataProvider="loginData")
    public void login(String username,String password)
    {
        
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit-button")).click();
        //validation
        Assert.assertTrue(driver.getTitle().contains("Sign In"), "User not able to login-Invalid credentials");
        System.out.println("User able to login-Valid credentials");
    }
    
    @DataProvider(name="loginData")
    //2D array with object data type
    public Object[][] passData()
    {
        ExcelDataConfig config=new ExcelDataConfig("C:\\Nextrow\\My Stuff\\workspace\\dataDrivenFramework\\src\\main\\java\\com\\testdata\\testdata.xlsx");
        int rows=config.getRowCount(0);
        
        Object[][] data=new Object[rows][2];
        
        for(int i=0;i<rows;i++)
        {
            data[i][0]=config.getData(0, i, 0);//username
            data[i][1]=config.getData(0, i, 1);//password
        }
        return data;
        }
}
