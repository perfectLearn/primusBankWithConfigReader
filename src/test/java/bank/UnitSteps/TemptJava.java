package bank.UnitSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TemptJava 
{
	public static void main(String[] args)
	{	
        System.setProperty("webdriver.chrome.driver","D:\\OwnPracticeProjectPrimus\\primusBank\\src\\test\\resources\\DRIVERS\\chromedriver.exe" );	
		
		ChromeDriver driver=new ChromeDriver();                                                  //browser launch 
		driver.manage().window().maximize();
		driver.get("http://primusbank.qedgetech.com/");   
		
		//url open
		
		
		WebElement abc=driver.findElementByXPath("//*[@id='txtuId']");
		
		          abc.sendKeys("Admin");
		
		
		//sendKeys
		driver.findElementByXPath("//*[@id='txtPword']").sendKeys("Admin");
		driver.findElementByXPath("//*[@id='login']").click();                     //click
		driver.findElementByXPath("//*[@src='images/Branches_but.jpg']").click();
		
	     
	}
		
}
