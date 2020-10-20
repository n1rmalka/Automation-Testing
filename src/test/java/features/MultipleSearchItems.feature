Feature: Validate Login To Application and Search Product and Add to Cart and Place Order

  Scenario Outline: Login with valid credentials
    Given User is on home page
    Then User close the discount popup
    And Click on Signin and verify the title
    And Enter "<username>", "<password>" and click on submit button

    Examples: 
      | ID    | Description          | title              | username                  | password        |
      | TC_01 | Login to Application | Returning Customer | northsee24@mailinator.com | Testbesttest@20 |

  Scenario Outline: Smoke test of the application from Search product to Add product
    And search product "<searchtext>" and click on search product
    And Click on Add to Cart

    Examples: 
      | ID    | Description                            | searchtext |
      | TC_01 | Search Product and Add to cart product | now        |
      | TC_02 | Search Product and Add to cart product | arginine   |
      | TC_03 | Search Product and Add to cart product | organic    |
      | TC_04 | Search Product and Add to cart product | tea oil    |
      | TC_05 | Search Product and Add to cart product | sulfate    |
      | TC_06 | Search Product and Add to cart product | herbs      |
      | TC_07 | Search Product and Add to cart product | kidney     |
      | TC_08 | Search Product and Add to cart product | heart      |
      | TC_09 | Search Product and Add to cart product | rosewater  |
      | TC_10 | Search Product and Add to cart product | LYSINE     |

  Scenario Outline: Smoke test of the application from Search product to Quick View  product to Place order
    And search product "<searchtext>" and click on search product
    And Click on Quick view
    And Click on plus button and click on add to cart
    And Enter coupon code "<coupon>" and click on apply coupn button
    And Click on Change address and enter new local address "<Country>","<State>","<city>","<postalcode>"
    And click on Proceed to checkout button
    And Fill the billing details of the  user "<firstname>","<lastname>","<address1>","<address2>","<State>","<city>","<postalcode>","<phonenumber>","<email>"
    And User entering new password "<Password>"
    And Click on Shipping diffrent address checkbox
    And Fill the shipping details of the  user "<firstname>","<lastname>","<address1>","<address2>","<State>","<city>","<postalcode>","<phonenumber>","<email>"
    And User enter credit card details "<cardnumber>","<cardexpdate>","<cardcvc>"
    And User click on website terms and conditions
    And Click on Place order button
    And Verify the Total amount

    Examples: 
      | ID    | Description                            | password        | searchtext | coupon  | qty | Country            | State    | firstname | lastname | address1                 | address2        | State    | city    | postalcode | phonenumber | email    | cardnumber       | cardexpdate | cardcvc |
      | TC_01 | Search Product and Add to cart product | Testbesttest@20 | Almond     | SAVEME5 |   1 | United States (US) | New York | George    | Kon      | 3647 173rd Court Lansing | LakeView Garden | Illinois | Lansing |      60438 |        9856 | gorgekon | 4242424242424242 |        0325 |     123 |
