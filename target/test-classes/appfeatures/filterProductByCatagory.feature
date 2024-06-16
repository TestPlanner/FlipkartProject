Feature: Filter product by catagory
@filter
Scenario: user filter product by brand and prize

Given user at home page
When user search for "mobile"
And user select brand "SAMSUNG" and "REDMI" from the brand filter
And user selects price range from 15000 to 30000
Then validate oprions showing are of "SAMSUNG" and "REDMI"   