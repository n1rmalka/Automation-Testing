Feature: Validate Sign-In and Reset/Forgot Password Functioanlity

  Scenario Outline: Signin Forgot your password link functional test
    Given User is on home page
    Then User close the discount popup
    And Click on Signin and verify the title
    And Click on Forgot your password link
    And Enter Email address "<email>" and click on submit button
    And Click on Return to log in link
    And Click on Forgot your password link
    And Enter Email address "<email>" and click on submit button
    And Click on Resend recovery link
    And Open email and enter email address "<email>"
    And Enter the "<new password>" and the "<confirm password>" and click on submit button
    And Enter "<username>", "<password>" and click on submit button
    And user should be logged in
    And browser is closed

    Examples: 
      | ID    | Description                        | title              | email                       | new password    | confirm password | username                    | password        |
      | TC_01 | Functional test of the application | Returning Customer | atdemouser96@mailinator.com | Testbesttest@20 | Testbesttest@20  | atdemouser96@mailinator.com | Testbesttest@20 |

  Scenario Outline: sign-in with Invalid credentials
    Given User is on home page
    Then User close the discount popup
    And Click on Signin and verify the title
    And Enter "<username>", "<password>" and click on submit button
    And user should be logged in
    And click on logout and verify the message
    And browser is closed

    Examples: 
      | ID    | Description          | title              | username                    | password        |
      | TC_01 | Login to Application | Returning Customer | atdemouser96@mailinator.com | Testbesttest@20 |
