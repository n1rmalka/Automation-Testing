Feature: Application Login

Scenario: Login with valid credentials

Given User is on login page
When User login into application with "mahfuzul.islam+tu001@gmail.com" and password "57c9b4140f4b"
Then Home page is populated
And user logout from application
And browser is closed









