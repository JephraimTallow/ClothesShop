
Feature: Clothes Store Purchase
	Example test cases for BJSS

Scenario: Happy path purchase journey
Given The clothes store homepage has loaded successfully
 And A user clicks the Sign in link
 And The login page is displayed
 And A user logs in successfully
 And The My Account page is displayed
 And A user clicks the Women link on My Accounts page
 And The Women page is displayed 
 And A user clicks the first item quick view icon
 And A user changes size to medium
 And A user buys a quick view item
 And A user clicks on Continue Shopping
 And A user clicks the second item quick view icon
 And A user buys a quick view item
 And The calculated totals will be correct
 And The user proceeds to checkout
 And The user proceeds on Address stage checkout
 And The user proceeds on Shipping stage checkout
 And The user clicks Pay by Wire button
When The user clicks Confirm Order button
Then The Order Confirmation page is displayed
And The user logs out

Scenario: Review previous orders
Given A user logs in to view order history
When A user selects product for comment "Sleeves are much too long"
Then The comments "Sleeves are much too long" are displayed in the Messages section
And The user logs out
 
Scenario: Review previous orders to test screenshot on failure
Given A user logs in to view order history
When A user selects product for comment "Sleeves are much too long"
Then The comments "Sleeves are much t00 long" are displayed in the Messages section
And The user logs out
 
 
