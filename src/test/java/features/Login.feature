Feature: Validate Login functionality Valid and Invalid data.

  Scenario Outline: Validate User is able to Sign In by entering valid Username and Password.
    Given User is on home page
    Then User close the discount popup
    And Click on Signin and verify the title
    And Click submit and validate the message "<Expectedresultuser>" "<ExpectedresultPassword>"
    And Enter "<username>", "<password>" and click on submit button
    And user should be logged in
    And click on logout and verify the message
    And browser is closed

    Examples: 
      | ID    | Description          | title              | username                    | password        | Expectedresultuser       | ExpectedresultPassword          |
      | TC_01 | Login to Application | Returning Customer | atdemouser96@mailinator.com | Testbesttest@20 | Email field is required. | The Password field is required. |

  Scenario Outline: Login with valid credentials
    Given User is on home page
    Then User close the discount popup
    And Click on Signin and verify the title
    And Enter "<username>", "<password>" and click on submit button
    And user should be logged in
    And click on logout and verify the message
    And browser is closed

    Examples: 
      | ID    | Description          | title              | username                    | password        |
      | TC_01 | Login to Application | Returning Customer | atdemouser96&mailinator.com | Testbesttest@20 |

  Scenario Outline: Validate User is able to Sign in by entering Invalid Username and Password.
    Given User is on home page
    Then User close the discount popup
    And Click on Signin and verify the title
    And Enter "<username>", "<password>" and click on submit button
    And user should be logged in
    And click on logout and verify the message
    And browser is closed

    Examples: 
      | ID    | Description          | title              | username                    | password      |
      | TC_01 | Login to Application | Returning Customer | atdemouser96@mailinator.com | $Testbest@20% |
      | TC_02 | Login to Application | Returning Customer | TestBest.com                | Test@         |
      | TC_03 | Login to Application | Returning Customer | atFrresh@gmail@.com         | $%^&=         |
      | TC_04 | Login to Application | Returning Customer | Atdemo%.com                 | &%hope@       |
      | TC_05 | Login to Application | Returning Customer | freetest@gmail.com          | $Testbest@20% |

  Scenario Outline: Update User and biling and shipping details
    Given User is on home page
    Then User close the discount popup
    And Click on Signin and verify the title
    And Enter "<username>", "<password>" and click on submit button
    And Click on Account information and edit the information "<firstname>","<lastname>" and save information
    And Click on Add and Fill the billing details of the user "<firstname>","<lastname>","<address1>","<address2>","<State>","<city>","<postalcode>","<phonenumber>" and Save
    And Click on Add and Fill the shipping details of the user "<firstname>","<lastname>","<address1>","<address2>","<State>","<city>","<postalcode>","<phonenumber>" and Save
    And browser is closed

    Examples: 
      | ID    | Description                                 | username                    | password        | firstname | lastname | address1                 | address2        | State    | city    | postalcode | phonenumber |
      | TC_01 | Update User and biling and shipping details | atdemouser96@mailinator.com | Testbesttest@20 | North     | See      | 3647 173rd Court Lansing | LakeView Garden | Illinois | Lansing |      60438 |        9858 |
