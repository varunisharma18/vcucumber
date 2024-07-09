Feature: Amazon test cases
  I want to use this feature file to run amaon test cases
  
  @uid 
  Scenario: Validate userid
    Given i open "chrome" and get url "https://www.amazon.in/" test name "AmazonLogin" report name "LoginReport"
    And click signin
    When I enter valid userid "varunisharma18@gmail.com"
    And click continue button
    Then I error should not come
    But password should come

 @pwd
  Scenario: validate password
   Given userid is valid and password textbox displayed
   When enter a valid password "18@Mayvibha"
   Then i should login
   
   @search
   Scenario Outline: searching products
    Given i am logged in
    When i search for product <productname> and price <productprice>
    Then product must come
    And close browser
  
  @data1 
   Examples:
   | productname | productprice |
   | Shirt | 1200 |
   | Pant | 4500 |
   | Tie | 400 |
   
   @data2
   Examples:
    | productname | productprice |
   | Mobile | 15000 |
   | Mobile | 10000 |
   | Mobile | 8000 |
   
   