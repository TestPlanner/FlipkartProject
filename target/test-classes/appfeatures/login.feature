
Feature: Become seller to the application

@Test
Scenario: Validationg sell Online contains all 7 options
Given user at home page
When user clicks on become seller button
Then validate options available in sell online dropdown
|Create Account|
|List Products|
|Storage & Shipping|
|Recieve Payments|
|Grow Faster|
|Seller App|
|Help & Support|

@Test
Scenario Outline: Become seller using multiple data
Given user at home page
When user clicks on become seller button
And user clicks on start selling button
And user enters mobile number "<MobileNo>"
And user enters emailid "<EmailID>"
And user enter gst number "<GSTNo>"
And user clicks on register button
Then verify error msg get displayed
Examples:
| MobileNo | EmailID | GSTNo |
| 9405973923 | amitn156@gmail.com | 3ZNAQQIOKHHJSN |
| 9405973923 | amittest@gmail.com | 4ZNAQQIOKHHJTG |
| 9405973923 | wiretest@gmail.com | 6ZNAQQIOKHHJTG |



