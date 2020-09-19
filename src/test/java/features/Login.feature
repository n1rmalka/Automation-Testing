Feature: Validate Login To Application and Edit the account

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
      | ID    | Description                                 | username                  | password        | firstname | lastname | address1                 | address2        | State    | city    | postalcode | phonenumber |
      | TC_01 | Update User and biling and shipping details | northsee24@mailinator.com | Testbesttest@20 | North     | See      | 3647 173rd Court Lansing | LakeView Garden | Illinois | Lansing |      60438 |        9858 |
