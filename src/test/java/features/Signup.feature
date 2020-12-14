Feature: Sign-up/Registration with Valid and Invalid Scenarios

  Scenario Outline: Validate the Signin functionality with Valid data
    Given User is on home page
    Then User close the discount popup
    And Click on Signin and verify the title
    And User Click on Signup button
    And User click on Create Account button and verify the messages "<firstname>" "<lastname>" "<email>" "<password>" "<confirmpassword>" "<agreeterms>"
    And browser is closed

    Examples: 
      | ID    | Description                         | Firstname                     | Lastname                     | Email Address            | password                    | confirmpassword                     | agreeterms              |
      | TC_01 | New User sign-up to the application | First Name field is required. | Last Name field is required. | Email field is required. | Password field is required. | Confirm Password field is required. | Please agree with terms |

  Scenario Outline: Regression test of the application Sign-Up functional test with Valid
    Given User is on home page
    Then User close the discount popup
    And Click on Signin and verify the title
    And User Click on Signup button
    And User enters Create an Account details "<username>", "<mobilenumber>","<email>","<password>","<confirmpassword>"
    And User click on receive exclusive Marketing Offers by email checkbox
    And User click on agree to Terms of Use checkbox
    And User click on Create Account button and Verify the message
    And User Verify the email from mail link and login into application "<email>","<password>"
    And browser is closed

    Examples: 
      | ID    | Description                         | username     | mobilenumber | email        | password        | confirmpassword |
      | TC_01 | New User sign-up to the application | Nirmal_Patel |         9924 | nirmal.patel | Testbesttest@20 | Testbesttest@20 |

  Scenario Outline: Regression test of the application Sign-Up functional test with Invalid
    Given User is on home page
    Then User close the discount popup
    And Click on Signin and verify the title
    And User Click on Signup button
    And User enters Create an Account details "<username>", "<mobilenumber>","<email>","<password>","<confirmpassword>"
    And User click on receive exclusive Marketing Offers by email checkbox
    And User click on agree to Terms of Use checkbox
    And User click on Create Account button and Verify the message
    And User Verify the email from mail link and login into application "<email>","<password>"
    And browser is closed

    Examples: 
      | ID    | Description                         | username     | mobilenumber | email     | password        | confirmpassword |
      | TC_01 | New User sign-up to the application | Deno_Test@%^ |         3645 | testbest$ | Testbesttest@20 | Testbesttest@20 |
