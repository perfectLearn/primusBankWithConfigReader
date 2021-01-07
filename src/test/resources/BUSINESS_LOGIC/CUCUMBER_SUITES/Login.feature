Feature: Login feature

Background: user is successfully logged in
When user opens "chrome" browser
When user enters url 



@SmokeTest
Scenario: login functionality with valid username and valid password
When user enters "Admin" as username
When user enters "Admin" as password
When user clicks on login button
Then user is on the "Admin" main page as get message as welcome to admin












