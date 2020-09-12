@test1
Feature: Smoke Test

  Scenario Outline: Smoke test of the application from Add product to Place order
    Given User is on home page
    Then User close the discount popup
    When User adds a product to cart
    And user click on term & condtions checkbox
    And clicks checkout button
    Then click here to login link should be displayed
    And Fill the billing details of the  user "<firstname>","<lastname>","<address1>","<address2>","<State>","<city>","<postalcode>","<phonenumber>","<email>"
    And Click on Shipping diffrent address checkbox
    And Fill the shipping details of the  user "<firstname>","<lastname>","<address1>","<address2>","<State>","<city>","<postalcode>","<phonenumber>","<email>"
    And User enter credit card details "<cardnumber>","<cardexpdate>","<cardcvc>"
    And User click on website terms and conditions
    And Click on Place order button
    And Verify the Total amount
    And browser is closed

    Examples: 
      | ID    | Description                        | firstname | lastname | address1                 | address2 | State    | city    | postalcode | phonenumber | email    | cardnumber       | cardexpdate | cardcvc |
      | TC_01 | End to End test of the application | Evan      | More     | 3647 173rd Court Lansing | Circle   | Illinois | Lansing |      60438 | 987-456-78  | evanmore | 4242424242424242 |        0325 |     123 |

  @Searchproduct
  Scenario Outline: Smoke test of the application from Search product to Add product to Place order
    Given User is on home page
    Then User close the discount popup
    And search product "<searchtext>" and click on search product
    And Click on Quick view
    And Click on plus button and click on add to cart
    And Enter coupon code "<coupon>" and click on apply coupn button
    #And Enter count "<qty>"
    And Click on Change address and enter new local address "<Country>","<State>","<city>","<postalcode>"
    And click on Proceed to checkout button
     And Fill the billing details of the  user "<firstname>","<lastname>","<address1>","<address2>","<State>","<city>","<postalcode>","<phonenumber>","<email>"
    And Click on Shipping diffrent address checkbox
    And Fill the shipping details of the  user "<firstname>","<lastname>","<address1>","<address2>","<State>","<city>","<postalcode>","<phonenumber>","<email>"
    And User enter credit card details "<cardnumber>","<cardexpdate>","<cardcvc>"
    And User click on website terms and conditions
    And Click on Place order button
    And Verify the Total amount
    And browser is closed

    Examples: 
      | ID    | Description                            | searchtext | coupon  | qty | Country | State   | firstname | lastname | address1         | address2        | city     | postalcode | phonenumber | email      | cardnumber       | cardexpdate | cardcvc |
      | TC_01 | Search Product and Add to cart product | Almond     | SAVEME5 |   1 | India   | Gujarat | Franky    | Dean     | First Cross Road | LakeView Garden | Vadodara |       3960 |    98525678 | frankydean | 4242424242424242 |        0325 |     123 |

  @signin
  Scenario Outline: Smoke test of the application Signin Forgot your password link functional test
    Given User is on home page
    Then User close the discount popup
    And Click on Signin and verify the title "<title>"
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
      | ID    | Description                        | title              | email                     | new password | confirm password | username                  | password |
      | TC_01 | Functional test of the application | Returning Customer | northsee24@mailinator.com | Test@123     | Test@123         | northsee24@mailinator.com | Test@123 |

 
