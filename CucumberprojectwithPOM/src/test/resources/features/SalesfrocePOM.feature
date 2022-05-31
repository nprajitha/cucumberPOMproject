
Feature: SDFC Login
 Background:
      Given navigate to "https://login.salesforce.com"
 
 
  Scenario:  Naviagte to SFDC
    When user on "Loginpage"
    And user enter username as "nanduri@student.com"
    And  user enter password should  be empty
    And click on login  button
    Then  verify error message text "Please enter your password."
 
  Scenario: Login with valid details
    When user on "Loginpage"
    And user enter username as "nanduri@student.com"
    And  user enter password as "Data#123"
    And click on login  button
    When user on "Homepage"  
    Then I verify page title as "Home Page ~ Salesforce - Developer Edition" 
      
    Scenario:  check remember me
    When user on "Loginpage"
    And user enter username as "nanduri@student.com"
    And  user enter password as "Data#123"
    And  user click on check box
    And click on login  button
    When user on "Homepage"
    And user click on dropdown
    And user click logout link
    When user on "Loginpage"
    Then  verify displayname "nanduri@student.com"
    
    
    Scenario:  forgot password
    When user on "Loginpage"
    And user click on forgot password link
    When  user on "Forgotpassword"
    And  user enter  resetusername  as "nanduri@student.com"
    And click on  continue button
    When user on "Resetpage"
    Then  verify  resetpage header text is "Check Your Email"
    
    Scenario: Login with invalid cerdentials
   
    When user on "Loginpage"
    And user enter username as "123"
    And  user enter password as "2231"
    And click on login  button
    Then message with the text "Please check your username and password. If you still can't log in, contact your Salesforce administrator."