package wesite.wesite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
    	 ChromeOptions chromeOptions = new ChromeOptions();
    	 WebDriver driver = new ChromeDriver(chromeOptions);

    	 System.out.println("Running test for index.php");
    	 

     	 String expectedP1 = "This is about page.";
     	 String expectedP2 = "It is a long established fact that a reader";
    	 driver.get("http://localhost:8081/index.php");

    	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	 driver.findElement(By.id("About Us")).click();

    	 System.out.println("====================== P1 ======================");
    	 System.out.println(driver.findElement(By.id("PID-ab2-pg")).getText());
    	 
    	 if(driver.findElement(By.id("PID-ab2-pg")).getText().startsWith(expectedP1)) {
        	 System.out.println("P1 DOES matches");
    	 }else{
        	 System.out.println("P1 DOES NOT matches");
    	 };

    	 System.out.println("====================== P2 ======================");
    	 System.out.println(driver.findElement(By.xpath("/html/body/p[2]")).getText());
    	 
    	 if(driver.findElement(By.xpath("/html/body/p[2]")).getText().startsWith(expectedP2)) {
        	 System.out.println("P2 DOES matches");
    	 }else{
        	 System.out.println("P2 DOES NOT matches");
    	 };
    	 
    	 
    	 driver.quit();
    	 
    }
}
