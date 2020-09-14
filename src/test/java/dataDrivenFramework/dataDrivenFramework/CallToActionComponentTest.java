package dataDrivenFramework.dataDrivenFramework;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CallToActionComponentTest {
	
WebDriver driver;
    
    @BeforeMethod
    public void loginTest() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Nextrow\\FFB\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://nextrow-author.adobesandbox.com/libs/granite/core/content/login.html");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("jaP#uv+QAp9l");
        driver.findElement(By.id("submit-button")).click();
    }
    
    @Test
    public void callToAction() throws Exception
    {
        driver.findElement(By.xpath("//*[@id=\"globalnav-start-home-collection\"]/coral-masonry-item[3]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"granite-shell-content\"]/div[2]/div/div[2]/coral-columnview/coral-columnview-column[1]/coral-columnview-column-content/coral-columnview-item[13]")).click();
        driver.findElement(By.xpath("//*[@id=\"granite-shell-content\"]/div[2]/div/div[2]/coral-columnview/coral-columnview-column[2]/coral-columnview-column-content/coral-columnview-item[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"granite-shell-content\"]/div[2]/div/div[2]/coral-columnview/coral-columnview-column[3]/coral-columnview-column-content/coral-columnview-item[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"granite-shell-content\"]/div[2]/div/div[2]/coral-columnview/coral-columnview-column[4]/coral-columnview-column-content/coral-columnview-item[7]/coral-columnview-item-thumbnail/img")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/coral-actionbar/coral-actionbar-primary/coral-actionbar-item[2]/button")).click();
        
        //window handles
        String parent=driver.getWindowHandle();
        Set<String>s=driver.getWindowHandles();
        Iterator<String>i1=s.iterator();
        while(i1.hasNext())
        {

 

        String child_window=i1.next();

 

        if(!parent.equals(child_window))
        {
        driver.switchTo().window(child_window);
        
        Thread.sleep(5000);
        
      //delete cta
        driver.findElement(By.xpath("//div[@class='cq-droptarget cq-subdroptarget cq-Overlay-subdroptarget' and @style='top: 0px; left: 12px; width: 1152px; height: 211px;']")).click();
        driver.findElement(By.xpath("//*[@id=\"EditableToolbar\"]/button[4]")).click();//delete
        driver.findElement(By.xpath("//*[@class='coral3-Button coral3-Button--warning']")).click();
        
        Thread.sleep(5000);
        
        driver.findElement(By.xpath("//div[contains(@class,'cq-Overlay cq-Overlay--component cq-droptarget cq-Overlay--placeholder')]")).click();//drag components here
        driver.findElement(By.xpath("//*[@id=\"EditableToolbar\"]/button[1]")).click();//insert component
        driver.findElement(By.xpath("/html/body/coral-dialog/div[2]/coral-dialog-content/coral-search/input")).sendKeys("Call to action");
//        Robot r=new Robot();
//        r.keyPress(KeyEvent.VK_DOWN);
//        r.keyRelease(KeyEvent.VK_DOWN);
//        r.keyPress(KeyEvent.VK_DOWN);
//        r.keyRelease(KeyEvent.VK_DOWN);
        
        driver.findElement(By.xpath("//*[text()='Call to Action']")).click();//select call to action option
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='cq-droptarget cq-subdroptarget cq-Overlay-subdroptarget' and @style='top: 0px; left: 12px; width: 1152px; height: 166px;']")).click();
        driver.findElement(By.xpath("//*[@id=\"EditableToolbar\"]/button[1]")).click();//edit dialog
        driver.findElement(By.xpath("//input[@name='./heading']")).sendKeys("Heading");
        driver.findElement(By.xpath("//*[@name='./message']")).sendKeys("message");
        driver.findElement(By.xpath("//*[@name='./callToAction']")).sendKeys("Button");
        driver.findElement(By.xpath("/html/body/coral-dialog/div[2]/form/coral-dialog-content/div/div/div[4]/foundation-autocomplete/div/div/span/button")).click();
        driver.findElement(By.xpath("//*[@id=\"granite-ui-pathfield-picker-collection\"]/coral-columnview-column[2]/coral-columnview-column-content/coral-columnview-item[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"granite-ui-pathfield-picker-collection\"]/coral-columnview-column[3]/coral-columnview-column-content/coral-columnview-item[1]/coral-columnview-item-thumbnail/img")).click();
        driver.findElement(By.xpath("/html/body/coral-dialog[2]/div[2]/coral-dialog-content/form/div[1]/div/div[2]/button[2]")).click();
        
        
        driver.findElement(By.xpath("//button[@class='granite-pickerdialog-submit coral3-Button coral3-Button--primary']")).click();//select button
        driver.findElement(By.xpath("//button[@class='js-browse-activator coral3-Button coral3-Button--secondary']")).click();
        Thread.sleep(2000);
        
        //iframe    
        driver.switchTo().frame(3);
        driver.findElement(By.xpath("//*[@id=\"cq-damadmin-admin-assetselector-collection\"]/coral-columnview-column/coral-columnview-column-content/coral-columnview-item[6]")).click();
        driver.findElement(By.xpath("//img[@src='/content/dam/nrdemo/precondo-ca-uJ7NOEbTd80-unsplash.jpg/_jcr_content/renditions/cq5dam.thumbnail.48.48.png?ch_ck=1587642491000']")).click();
        driver.findElement(By.xpath("//*[text()='Select']")).click();
        driver.switchTo().defaultContent();
            
        driver.findElement(By.xpath("//button[@class='cq-dialog-header-action cq-dialog-submit coral3-Button coral3-Button--minimal']")).click();//done for dialog
        Thread.sleep(2000);
        driver.findElement(By.id("pageinfo-trigger")).click();
        driver.findElement(By.xpath("//*[@id=\"pageinfo-data\"]/button[4]")).click();//publish page
        
    }
    }
    }

 

    @DataProvider(name="ctaData")
    //2D array with object data type
    public Object[][] passData()
    {
        ExcelDataConfig config=new ExcelDataConfig("/dataDrivenFramework/src/main/java/com/testdata/ctaButton.xlsx");
        int rows=config.getRowCount(0);
       
        Object[][] data=new Object[rows][6];
       
        for(int i=0;i<rows;i++)
        {
            data[i][0]=config.getData(0, i, 0);//user name
            data[i][1]=config.getData(0, i, 1);//password
            data[i][2]=config.getData(0, i, 2);//cta
            data[i][3]=config.getData(0, i, 3);//heading
            data[i][4]=config.getData(0, i, 4);//message
            data[i][5]=config.getData(0, i, 5);//button text
           
        }
        return data;
        
        }
    
       @AfterMethod
        public void tearDown()
        {
            driver.quit();
        }
    }


