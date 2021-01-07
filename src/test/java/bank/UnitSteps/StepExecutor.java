package bank.UnitSteps;

import bank.methods.SeleniumOperations;

public class StepExecutor 
{
	
	public static void main(String[] args) 
	{
		//Browsr Launch
		Object[] input=new Object[2];
		
		input[0]="FF";
		
		input[1]="D:\\Morning 8.30am batch(indra)\\primusBank\\src\\test\\resources\\DRIVERS\\chromedriver.exe";
		
		SeleniumOperations.browserLaunch(input);
		
		
		
		//application launch
		Object[] input1=new Object[1];
		input1[0]="http://primusbank.qedgetech.com/";
		
		SeleniumOperations.applicationLaunch();
		
		//sendkey for ID
        Object[] input2=new Object[2];
		
		input2[0]="//*[@id='txtuId']";
		
		input2[1]="Admin";
		
		SeleniumOperations.sendKey(input2);
		
		//sendkey for password
		
		    Object[] input3=new Object[2];
			
			input3[0]="//*[@id='txtPword']";
			
			input3[1]="admin";
			
			SeleniumOperations.sendKey(input3);
		
		  //Click o Login
			
			Object[] input4=new Object[1];
			input4[0]="//*[@id='login']";
			
			SeleniumOperations.click(input4);
			
			//validation login
			/*Object[] login=new Object[2];
			 login[0]="//*[text()='Admin']";
			 login[1]="Admin";
			 SeleniumOperations.validation(login);*/
			
			
			
		   //click on branches	
			Object[] input5=new Object[1];
			input5[0]="//*[@src='images/Branches_but.jpg']";
			
			SeleniumOperations.click(input5);
			
		  //Country
			
			Object[] input6=new Object[2];
			
			input6[0]="//*[@name='lst_countryS']";
			
			input6[1]="INDIA";
			
			SeleniumOperations.dropDown(input6);
			
				
          //State
			
			Object[] input7=new Object[2];
			
			input7[0]="//*[@id='lst_stateS']";
			
			input7[1]="MAHARASTRA";
			
			SeleniumOperations.dropDown(input7);
			
			
          //City
			
			Object[] input8=new Object[2];
			
			input8[0]="//*[@id='lst_cityS']";
			
			input8[1]="MUMBAI";
			
			SeleniumOperations.dropDown(input8);	
			
	      //click on search
			
			Object[] input9=new Object[1];
			input9[0]="//*[@type='image' and @id='btn_search']";
			
			SeleniumOperations.click(input9);   
		
			// validation search
			 Object[] search=new Object[2];
			 search[0]="(//*[text()='MUMBAI'])[1]";
			 search[1]="MUMBAI";
			 SeleniumOperations.validation(search);
			
		
		
		
		
		
		
	}
	
	
	
	
	
	

}
