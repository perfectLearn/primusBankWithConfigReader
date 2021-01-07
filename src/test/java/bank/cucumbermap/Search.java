package bank.cucumbermap;
import java.util.Hashtable;

import bank.methods.HTMLReportGenerator;
import bank.methods.SeleniumOperations;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Search 
{

@When("^user click on branches$")
public void user_click_on_branches() throws Throwable 
{
	Object[] input5=new Object[1];
	input5[0]="//*[@src='images/Branches_but.jpg']";
	
	Hashtable<String,Object> input5op=SeleniumOperations.click(input5);
	HTMLReportGenerator.StepDetails(input5op.get("STATUS").toString(), "user click on branches",input5op.get("MESSAGE").toString());									
}

@When("^user select \"([^\"]*)\" as country$")
public void user_select_as_country(String country) throws Throwable 
{
	Object[] input6=new Object[2];
	
	input6[0]="//*[@name='lst_countryS']";
	
	input6[1]=country;
	
	Hashtable<String,Object> input6op=SeleniumOperations.dropDown(input6);
	HTMLReportGenerator.StepDetails(input6op.get("STATUS").toString(), "user select \"([^\"]*)\" as country",input6op.get("MESSAGE").toString());											
}

@When("^user select \"([^\"]*)\" as state$")
public void user_select_as_state(String state) throws Throwable 
{
    
	Object[] input7=new Object[2];
	
	input7[0]="//*[@id='lst_stateS']";
	
	input7[1]=state;

	Hashtable<String,Object> input7op=SeleniumOperations.dropDown(input7);
	HTMLReportGenerator.StepDetails(input7op.get("STATUS").toString(), "user select \"([^\"]*)\" as state",input7op.get("MESSAGE").toString());								
	
}

@When("^user select \"([^\"]*)\" as city$")
public void user_select_as_city(String city) throws Throwable 
{
	Object[] input8=new Object[2];
	
	input8[0]="//*[@id='lst_cityS']";
	
	input8[1]=city;
	
	Hashtable<String,Object> input8op=SeleniumOperations.dropDown(input8);
	HTMLReportGenerator.StepDetails(input8op.get("STATUS").toString(), "user select \"([^\"]*)\" as city",input8op.get("MESSAGE").toString());									
}

@When("^user click on search button$")
public void user_click_on_search_button() throws Throwable 
{
	Object[] input9=new Object[1];
	input9[0]="//*[@type='image' and @id='btn_search']";
	
	Hashtable<String,Object> input9op=SeleniumOperations.click(input9);  
	
	HTMLReportGenerator.StepDetails(input9op.get("STATUS").toString(), "user click on search button",input9op.get("MESSAGE").toString());									
	
}

@Then("^user get result for \"([^\"]*)\" branches$")
public void user_get_result_for_branches(String valid) throws Throwable
{
	 Object[] search=new Object[2];
	 search[0]="(//*[text()='Hyderabad'])[1]";
	 search[1]=valid;
	 Hashtable<String,Object> searchop=SeleniumOperations.validation(search);
	 HTMLReportGenerator.StepDetails(searchop.get("STATUS").toString(), "user get result for \"([^\"]*)\" branches",searchop.get("MESSAGE").toString());									
	   
}


	
}
