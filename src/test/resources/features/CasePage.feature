@SmokeTesting
Feature: Case Object related Smoke Scenarios

  @validateCaseCreationFlow 
  Scenario: 1.User logs into salesforce and creates a case
    #Case Creation
    Given I launch the Salesforce application
    When I enter the "UserName" and "Password"
    And I click on LogIn Button
    Then I logged into the Salesforce application successfully
    Given I click on Applauncher 
    And I click on Service Console
    Then I see Service Console Application
    Given I click Show Navigation Menu
    When I click Case List Item
    Then I see page with Case title Opened
    When I click New button
    Given I enter Case Origin
    And I enter Contact
    And I enter Account
    And I enter Subject
    When I click Save button
    Then I see new case is created successfully
    @FeedPost @EditCaseStatus
    Scenario: 2.User Edits the case status and Posts on feed section
    Scenario: 3.Agent can track the action on the case in the case fees
    When I Edit the case status
    Given I click on Feed Link
    And I enter details in Share feed
    When I share the feed
    Then I verify the feed in Text Posts
    And I verify the Status Changes
    @TaskCreation
    Scenario: 4.User Creates a new Task from Existing Case
    When I click Open Activities related list
 		Then I see page with Open Activities title Opened
    When I click New Task button
    Then I see New Task window opened
    Given I enter task subject 
    And I enter task comments
    When I click Save button
    Then I see new Task is created successfully
    #Then I execute the "TS-000001" script in test tracker
   
    
    
    
    
