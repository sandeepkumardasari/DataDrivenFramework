package dataDrivenFramework.dataDrivenFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactUsFormTest {
	   
    WebDriver driver;
    @BeforeMethod
    public void run()
    {
    System.setProperty("webdriver.chrome.driver", "C:\\Nextrow\\FFB\\chromedriver.exe");
    driver=new ChromeDriver();
    driver.get("https://nextrow-publish.adobesandbox.com/content/nr_finance/us/en/contact-us.html");
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   
    }
    @Test(dataProvider="contactUs")
    public void contactUs(String firstname,String preference,String lastname,String email,String text,String phone) throws InterruptedException
    {
       
        driver.findElement(By.id("first_name")).sendKeys(firstname);
        //drop down handling
        Select sel = new Select(driver.findElement(By.id("preference")));
        sel.selectByVisibleText(preference);
        driver.findElement(By.id("last_name")).sendKeys(lastname);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("textarea")).sendKeys(text);
        driver.findElement(By.id("phone")).sendKeys(phone);
        Thread.sleep(2000);
        driver.findElement(By.name("submit")).click();
        Thread.sleep(3000);
        //Validation
        Assert.assertTrue(driver.getTitle().contains("Successful submission"), "Page title verified-Submission UnSuccessful");
        System.out.println("Page title verified-Successful submission");
   
    }
   
    @DataProvider(name="contactUs")
    public String[][] formData() throws Exception
    {
        Thread.sleep(3000);
        ExcelDataConfig eData=new ExcelDataConfig("C:\\Nextrow\\My Stuff\\workspace\\dataDrivenFramework\\src\\main\\java\\com\\testdata\\ContactUsFormData.xlsx");
        int rows=eData.getRowCount(0);
       
        String[][] data1=new String[rows][6];
       
        for(int i=0;i<rows;i++)
        {
            data1[i][0]=eData.getData(0, i, 0);//first name
            data1[i][1]=eData.getData(0, i, 1);//preference
            data1[i][2]=eData.getData(0, i, 2);//last name
            data1[i][3]=eData.getData(0, i, 3);//email
            data1[i][4]=eData.getData(0, i, 4);//text
            data1[i][5]=eData.getData(0, i, 5);//phone
        }
        return data1;
     }
  
}
