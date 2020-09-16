package dataDrivenFramework.dataDrivenFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CtaPublisherTest {
    
    WebDriver driver;
    
    @Test
    public void ctaPublisherTest() throws Exception
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Nextrow\\FFB\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        
        driver.get("https://nextrow-publish.adobesandbox.com/content/nr_finance/language-masters/en/testpage.html");
        
        //page validation in publisher
        driver.findElement(By.xpath("//*[@id=\"callToAction--content-nr_finance-language-masters-en-testpage-jcr-content-root-responsivegrid-calltoaction\"]/p[2]"));
        System.out.println("Page has published");
        
        //Button validation
        driver.findElement(By.xpath("//*[@id=\"callToAction--content-nr_finance-language-masters-en-testpage-jcr-content-root-responsivegrid-calltoaction\"]/p[2]")).click();
        Thread.sleep(2000);
        if ("English".equalsIgnoreCase(driver.getTitle())) {
            System.out.println("CTA component test pass");
        }
        else {
            System.out.println("CTA component test fail");
        }            
            driver.quit();
        }
    
    }
