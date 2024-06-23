Feature: login button options
@Loginf1
Scenario: Verify list of options in login button
Given user at home page
When user scrolls on login button
Then user can see all six options 
| My Profile |
| Flipkart Plus Zone |
| Orders |
| Wishlist |
| Rewards |
|Gift Cards|
