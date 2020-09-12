Feature: Validate the Home Page Functional and Broken links check

  Scenario Outline: Smoke test of the application Homepage functional test
    Given User is on home page
    Then User close the discount popup
    And Scroll down and click on see all deals
    And Verify the deal page meesage
    And Click back button of browser
    And Scroll down and left and right arrow
    And Scroll up and click on categories "<category>"
    And Click on Sub Category "<subcategory>"
    And Click on price radio button
    And Click on Show more on narrow choice
    And Click on Show less on narrow choice
    And Click on rating checkbox
    And User adds a product to cart
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
    And browser is closed

    Examples: 
      | ID    | Description                                  | category               | subcategory | coupon  | Country            | State    | firstname | lastname | address1                 | address2        | State    | city    | postalcode | phonenumber | email      | cardnumber       | cardexpdate | cardcvc | password        |
      | TC_01 | Home Page functional test of the application | Vitamins & Supplements | Amino Acids | SAVEME5 | United States (US) | New York | Franky    | Dean     | 3647 173rd Court Lansing | LakeView Garden | Illinois | Lansing |      60438 | 985-256-78  | frankydean | 4242424242424242 |        0325 |     123 | Testbesttest@20 |

  Scenario Outline: Find Broken Links
    Given User is on home page
    And finds the broken links for <url>

    Examples: 
      | url                                          |
      | https://40plusmart.com/                      |
      | https://40plusmart.com/contact/              |
      | https://40plusmart.com/about/                |
      | https://40plusmart.com/healthy-links/        |
      | https://40plusmart.com/orders-and-returns/   |
      | https://40plusmart.com/faqs/                 |
      | https://40plusmart.com/store-location/       |
      | https://40plusmart.com/specials/             |
      | https://40plusmart.com/brands/               |
      | https://40plusmart.com/terms-and-conditions/ |
      | https://40plusmart.com/privacy-policy/       |
      | https://40plusmart.com/login/                |
