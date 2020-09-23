package dataDrivenFramework.dataDrivenFramework;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddAssetsTest {
    WebDriver driver;
   
@BeforeMethod
public void login() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Nextrow\\FFB\\chromedriver.exe");
    driver=new ChromeDriver();
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    //Login script
    driver.get("https://nextrow-author.adobesandbox.com/libs/granite/core/content/login.html");
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.id("password")).sendKeys("jaP#uv+QAp9l");
    driver.findElement(By.id("submit-button")).click();
}
    @Test(dataProvider="addAsset")
    public void addAsset(String asset) throws Exception {
    driver.findElement(By.xpath("//*[@class='globalnav-homecard-icon coral3-Icon coral3-Icon--asset coral3-Icon--sizeXL']")).click();//assets
    driver.findElement(By.xpath("//*[@class='globalnav-homecard-title' and text()='Files']")).click();//files
    driver.findElement(By.xpath("//*[@id=\"granite-shell-content\"]/div[2]/div/div[2]/coral-masonry/coral-masonry-item[9]/a/coral-card/div")).click();//aemboxplugin
    driver.findElement(By.xpath("//*[@class='foundation-collection-item-title coral3-Card-title' and text()='demo']")).click();//demo
    Thread.sleep(4000);
    driver.findElement(By.xpath("//*[@class='foundation-collection-item-title coral3-Card-title' and text()='vijaya test']")).click();//vijaya test folder
    driver.findElement(By.xpath("//button[@class='granite-collection-create cq-damadmin-admin-createasset foundation-collection-action foundation-toggleable-control coral3-Button coral3-Button--primary']")).click();//create button
    driver.findElement(By.xpath("//a[@id='coral-id-7']")).click();//files
   
    //Robot class to upload file from local folders
    Robot robot = new Robot();
    StringSelection str=new StringSelection(asset);
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
   
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
   
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_V);
   
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
   
    driver.findElement(By.xpath("/html/body/coral-dialog[3]/div[2]/coral-dialog-footer/button[2]")).click();//Upload button
    Thread.sleep(4000);
}
   
    @DataProvider(name="addAsset")
    //2D array with object data type
    public Object[][] passData()
    {
        ExcelDataConfig config=new ExcelDataConfig("\\dataDrivenFramework\\src\\main\\java\\com\\testdata.xlsx");
        int rows=config.getRowCount(0);
        Object[][] data=new Object[rows][1];
      
        for(int i=0;i<rows;i++)
        {
            data[i][0]=config.getData(0, i, 0);//user name
        }
        return data;
}
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
