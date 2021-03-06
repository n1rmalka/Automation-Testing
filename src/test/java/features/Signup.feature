Feature: Validate the sign-up functionality

  Scenario Outline: Smoke test of the application Sign-Up functional test
    Given User is on home page
    Then User close the discount popup
    And Click on Signin and verify the title
    And User Click on Signup button
    And User enters Create an Account details "<username>", "<mobilenumber>","<email>","<password>","<confirmpassword>"
    And User click on receive exclusive Marketing Offers by email checkbox
    And User click on agree to Terms of Use checkbox
    And User click on Create Account button and Verify the message
    And User Verify the email from mail link and login into application "<email>","<password>"
    # And click on logout and verify the message
    And browser is closed

    Examples: 
      | ID    | Description                         | username | mobilenumber | email | password        | confirmpassword |
      | TC_01 | New User sign-up to the application | Abhi     |         9785 | abhi  | Testbesttest@20 | Testbesttest@20 |
