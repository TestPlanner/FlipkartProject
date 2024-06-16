Feature: Flipkart functionality testing
@Test
Scenario: verify homepage loads successfully
Given user at home page
Then user able to see content of page
And title of the page is correct

@Test
Scenario: search and add to cart
Given user at home page
When user enters "laptop" in search bar and clicks on any option
Then user should redirect to product details page
When user add selected laptop to the shopping cart
Then laptop should get added to the shopping cart