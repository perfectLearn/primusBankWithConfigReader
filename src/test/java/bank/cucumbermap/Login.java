package bank.cucumbermap;

import java.util.Hashtable;

import bank.methods.HTMLReportGenerator;
import bank.methods.SeleniumOperations;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login
{
	

	@When ("^user opens \"(.*)\" browser$")
	public void user_opens_browser_and_exe(String browserName) throws Throwable
	{
		
        Object[] input=new Object[1];
		
		input[0]=browserName;
		
		
		
		SeleniumOperations.browserLaunch(input);
		   
	}

	@When ("^user enters url$")
	public void user_enters_url() throws Throwable 
	{
		//Object[] input1=new Object[0];
		
		
		SeleniumOperations.applicationLaunch();
		  
	}

	@When("^user enters \"([^\"]*)\" as username$")
	public void username(String uname) throws Throwable
	{
		 Object[] input2=new Object[2];
			
			input2[0]="//*[@id='txtuId']"; 
			
			input2[1]=uname;
			
	Hashtable<String,Object> input2op=SeleniumOperations.sendKey(input2);
	
HTMLReportGenerator.StepDetails(input2op.get("STATUS").toString(),"user enters \"([^\"]*)\" as username" ,input2op.get("MESSAGE").toString());	

  HTMLReportGenerator.StepDetails(input2op.get("STATUS").toString(), "user enters \"([^\"]*)\" as username",input2op.get("MESSAGE").toString());


	}

	@When("^user enters \"([^\"]*)\" as password$")
	public void password(String pass) throws Throwable
	{
		 Object[] input3=new Object[2];
			
			input3[0]="//*[@id='txtPword']";
			
			input3[1]=pass;
			
			Hashtable<String,Object> input3op=SeleniumOperations.sendKey(input3);
			HTMLReportGenerator.StepDetails(input3op.get("STATUS").toString(),"user enters \"([^\"]*)\" as password" ,input3op.get("MESSAGE").toString());	
	
	}

	@When("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable
	{
		Object[] input4=new Object[1];
		input4[0]="//*[@id='login']";
		
		Hashtable<String,Object> input4op=SeleniumOperations.click(input4);
		HTMLReportGenerator.StepDetails(input4op.get("STATUS").toString(),"user clicks on login button" ,input4op.get("MESSAGE").toString());
	}

                
	
	@Then ("^user is on the \"(.*)\" main page as get message as welcome to admin$")
	   public void validation(String valid)
	   {
		Object[] login=new Object[2];
		 login[0]="//*[text()='Admin']";
		 login[1]=valid;
		 Hashtable<String,Object> loginop=SeleniumOperations.validation(login);
		 HTMLReportGenerator.StepDetails(loginop.get("STATUS").toString(),"user is on the \"(.*)\" main page as get message as welcome to admin" ,loginop.get("MESSAGE").toString());
	   }
	
	
	
	
	
	
	
}
