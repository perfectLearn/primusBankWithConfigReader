Feature: Search Feature

Background: user is successfully logged in
When user opens "chrome" browser
When user enters url 
When user enters "Admin" as username
When user enters "Admin" as password
When user clicks on login button

   
@RegressionTest
Scenario: Search functionality with valid data
When user click on branches
When user select "INDIA" as country
When user select "Andhra Pradesh" as state
When user select "Hyderabad" as city
When user click on search button
Then user get result for "Hyderabad" branches


