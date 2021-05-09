#Author:- Jaganmohan Appagari
# Functionality:- End to End flow of Order an item in the given application
@Tricentis
Feature: Verify user is able to order a book successfully in the Demo Web Shop Tricentis application

  Scenario: SC_01_Verify given user is able to login to Demo Web Shop Tricentis application
    Given Launch the application
      | URL                               |
      | http://demowebshop.tricentis.com/ |
    When User click on the login button
    Then "Welcome, Please Sign In!" message should be displayed
    And Login into Demo Web Shop Tricentis application
      | Email                     | Password |
      | testdemowebshop@gmail.com | Test123  |
    And "testdemowebshop@gmail.com" should be displayed in home page

  Scenario: SC_02_Clear the shopping cart
    When user click on Shopping cart
    And clear the shopping cart
    Then "Your Shopping Cart is empty!" should be displayed

  Scenario: SC_03_Verify product added to shopping cart
    When Navigate to Books menu item from categories
    And Select book from the list
    And get the price details
    And Enter the quantity as "2"
    And click on the Add to cart
    Then "The product has been added to your shopping cart" notification message should be displayed

  Scenario: SC_04_Validate the product sub total and check out
    When user click on Shopping cart
    Then verify the sub total price of the selected item
    And click on check out button

  Scenario: SC_05_Enter Billing address, Payment method and Confirm the order
    When user Selct the billing address as "New Address"
    And Enter the below details
      | Country | City | Address1 | Zip_PostalCode | PhoneNumber |
      | India   | Hyd  | Hyd1     | 500080         | 9876543210  |
    And Select the Shipping address as billing address
      | Billing_Address                    |
      | demo test, Hyd1, Hyd 500080, India |
    And Select the shipping method as "Next Day Air"
    And choose payment method as "Cash on delivery"
    Then "You will pay by COD" message in payment info
    And click on Payment info section
    And click on Confirm order
    And "Your order has been successfully processed!" Confirm order message should be displayed
    And Get The Order number
    And click on Continue order
    And user click on Log out of the application
