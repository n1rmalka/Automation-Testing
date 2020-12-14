Feature: Sign Up for first time for smoke suite run

  Scenario Outline: Smoke test of the application Sign-Up functional test
    Given User is on home page
    Then User close the discount popup
    And Click on Signin and verify the title
    And User Click on Signup button
    And User enters Create an Account details "<username>", "<mobilenumber>","atdemouser96@mailinator.com","<password>","<confirmpassword>"
    And User click on receive exclusive Marketing Offers by email checkbox
    And User click on agree to Terms of Use checkbox
    And User click on Create Account button and Verify the message
    And User Verify the email from mail link and login into application "<email>","<password>"
    And browser is closed

    Examples: 
      | ID    | Description                         | username | mobilenumber | email                       | password        | confirmpassword |
      | TC_01 | New User sign-up to the application | northsee |         9924 | atdemouser96@mailinator.com | Testbesttest@20 | Testbesttest@20 |
