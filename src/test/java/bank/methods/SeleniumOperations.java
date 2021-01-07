package bank.methods;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import bank.cucumbermap.ConfigReader;
import net.bytebuddy.description.type.TypeDescription.Generic.OfTypeVariable.Symbolic;

public class SeleniumOperations 
{
	public static ConfigReader config;
      public  static WebDriver driver=null;
      
                  public static   Hashtable<String,Object> outputParameters=new Hashtable<String,Object>();
    
	public static Hashtable<String,Object> browserLaunch(Object[] inputParameters)
	{
		try{
				String strBrowserName=(String) inputParameters[0];
				
				
				if(strBrowserName.equalsIgnoreCase("Chrome"))
						{
					 config= new ConfigReader();
					 
					 System.setProperty("webdriver.chrome.driver", config.getDriverPathChrome());
				
							 driver=new ChromeDriver();                                                  
							driver.manage().window().maximize();
							//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
							
						}
				
				else if(strBrowserName.equalsIgnoreCase("FF"))
				       {
					      System.setProperty("webdriver.gecko.driver",config.getDriverPathFF());	 
					
					      driver=new FirefoxDriver();                                                   
					      driver.manage().window().maximize();
					   //   driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
					      
				       }   
		   
	     outputParameters.put("STATUS", "PASS");
	     outputParameters.put("MESSAGE", "Action : browser Launch,Input Given : " +inputParameters[0].toString() );
	       
				
		
		}catch(Exception e)
		  {
			     outputParameters.put("STATUS", "FAIL");
			     outputParameters.put("MESSAGE", "Action : browser Launch,Input Given : " +inputParameters[0].toString() );
			       
		  }
		
		return outputParameters;
	}
	 
	//Application open
	
	public static Hashtable<String,Object> applicationLaunch()
	{
		try{
				
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			
				driver.get(config.getApplicationUrl());
				
				
				
	   outputParameters.put("STATUS", "PASS")	;
				   outputParameters.put("MESSAGE", "Method used : applicationLaunch ,Input Given :" +   config.getApplicationUrl().toString());
			 
				   
			
		}
			
		catch(Exception e)
			{
			outputParameters.put("STATUS", "FAIL");
		 outputParameters.put("MESSAGE", "Action : application Launch,Input Given : " + config.getApplicationUrl().toString() );	
									 
			}
	
		return outputParameters;	
		
	}
	
	
	//sendkeys
	public static Hashtable<String,Object> sendKey(Object[]inputParameters)
	{
		try{
		String xpath=(String) inputParameters[0];
		String value=(String) inputParameters[1];
		
		
		WebElement obj=driver.findElement(By.xpath(xpath));
		
		obj.clear();
		obj.sendKeys(value);
		
		   outputParameters.put("STATUS", "PASS");
		     outputParameters.put("MESSAGE", "Action : sendKey,Input Given : " +inputParameters[1].toString() );	
		
		}
		catch(Exception e)
		{

			  outputParameters.put("STATUS", "FAIL");
			     outputParameters.put("MESSAGE", "Action : sendKey,Input Given : " +inputParameters[1].toString() );
		}

		return outputParameters;		
		
	}
	
	
	//click 
	public static Hashtable<String,Object> click(Object[]inputParameters)
	{
		try{
		String xpath=(String) inputParameters[0];
		
		driver.findElement(By.xpath(xpath)).click();
		
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		     outputParameters.put("STATUS", "PASS");
		     outputParameters.put("MESSAGE", "Action : click,Input Given : " +inputParameters[0].toString() );
		
		
		}catch(Exception e)
		{
			 outputParameters.put("STATUS", "FAIL");
		     outputParameters.put("MESSAGE", "Action : click,Input Given : " +inputParameters[0].toString() );
		}
		return outputParameters;	
	}
	
	
   //dropdown
	public static Hashtable<String,Object> dropDown(Object[]inputParameters)
	{
		try{
		String xpath=(String) inputParameters[0];
		String name=(String) inputParameters[1];
		
		
		
		Select sel=new Select(driver.findElement(By.xpath(xpath)));
		sel.selectByVisibleText(name);
	//	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		outputParameters.put("STATUS", "PASS");	
		outputParameters.put("MESSAGE", "Action: dropDown, Input Given:"+inputParameters[1].toString());	  
		}catch(Exception e)
		{
			outputParameters.put("STATUS", "FAIL");	
			outputParameters.put("MESSAGE", "Action: dropDown, Input Given:"+inputParameters[1].toString());	   
		}   
		
		return outputParameters;
	}
	
	public static Hashtable<String,Object> validation(Object[]inputParameters)
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String xpath=(String)inputParameters[0];// we are giving xpath of webelement 
		String String1=(String)inputParameters[1]; // we r giving  String of that xpath  
		
		 WebElement web=driver.findElement(By.xpath(xpath));
		 
		String String2= web.getText();
		
			try 
			{	
			    
						 if(String1.equalsIgnoreCase(String2))
						 {
							 System.out.println("Test Case PASS");
						 }
			                 
						 else
						 {
							 System.out.println("Test Case FAIL");
						 }
			}
			catch (Exception e)
			{	
				 
				System.out.println(e);
					  	
				  	     
			}
			
			return outputParameters;	
			
	}	
	
	
	public static Hashtable<String, Object> alert()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		try {
		    wait.until(ExpectedConditions.alertIsPresent());
		    Alert alert = driver.switchTo().alert();
		    alert.accept();
		    System.out.println("alert was present and accepted");
		    
		    outputParameters.put("STATUS", "PASS");
	    	outputParameters.put("MESSAGE", "Action:Alert,Input Given: "+"Application shows alert message and accepted");
		    
		}
		catch(Exception e) 
		{
		    System.out.println("alert was not present");
		    System.out.print(e);
		    outputParameters.put("STATUS", "FAIL");
	    	outputParameters.put("MESSAGE", "Action:Alert,Input Given: "+"Application don't show alert message");
		   
		}
		
		return outputParameters;
	}	
	
}
