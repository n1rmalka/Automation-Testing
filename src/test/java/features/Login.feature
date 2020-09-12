Feature: Validate Login To Application

  Scenario Outline: Login with valid credentials
    Given User is on home page
    Then User close the discount popup
    And Click on Signin and verify the title
    And Enter "<username>", "<password>" and click on submit button
    And user should be logged in
    And click on logout and verify the message
    And browser is closed

    Examples: 
      | ID    | Description          | title              | username                  | password        |
      | TC_01 | Login to Application | Returning Customer | northsee24@mailinator.com | Testbesttest@20 |
