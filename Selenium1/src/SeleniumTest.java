
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {

        protected static WebDriver driver ;
     static String getCurrentDateTime()
     {  //creat object of simple date format class and decide format
       DateFormat dateformat = new SimpleDateFormat("MMddyyyyHHmmss");
      // get current date time with date()
         Date date = new Date();
    // new format for date
     String date1 = dateformat.format(date);
     // print the date
         System.out.println(" Current date and time is "+date1 );
         return date1;
     }

    public static void main(String [] arg ){
       System.setProperty("webdriver.chrome.driver","src\\Selenium\\chromedrive.exe");
        driver = new ChromeDriver();
        //implicit wait applied to driver instance - which will be applied to driver until driver instance
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       //asking driver to get url
       driver.get("https://demo.nopcommerce.com/");
       //register for new user
       driver.findElement(By.xpath("//a[@class= \'ico-register\']")).click();
       driver.findElement(By.id("FirstName")).sendKeys("Martin");
       driver.findElement(By.id("LastName")).sendKeys("Patel");
       driver.findElement(By.id("Email")).sendKeys("kd"+getCurrentDateTime()+"@yahoo.com");
       driver.findElement(By.id("Password")).sendKeys("pruthvi");
       driver.findElement(By.id("ConfirmPassword")).sendKeys("pruthvi");
       driver.findElement(By.id("register-button")).click();
       String actualRegistrationSuccessMessage = driver.findElement(By.xpath("//div[@class'result']")).getText();
        Assert.assertEquals("Your registration  completed ",actualRegistrationSuccessMessage);

        driver.quit();
     }

}