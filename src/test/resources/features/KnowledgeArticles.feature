@SmokeTesting
Feature: Knowledge Object related Smoke Scenarios

@validateKnowledgearticlesCreationFlow 
Scenario: 11:Creation of a draft Knowledge article
    Given I launch the Salesforce application
    When I enter the "UserName" and "Password"
    And I click on LogIn Button
    Then I logged into the Salesforce application successfully
    Given I click on Applauncher 
    And I click on Service Console
    Then I see Service Console Application
    Given I click Show Navigation Menu
    When I click Knowledge List Item
    Then I see Knowledge page is Opened
    Given I click New button on Knowledge page
    When I enter Knowledge Article Title
    And I enter URL Name
    And I click Save Knowledge button
    Then I see new draft Article is created successfully
    
@PublishKnowledgearticle
Scenario: 12:Publish a draft knowledge article
    
    Given I click Show Navigation Menu
    When I click Knowledge List Item
    Then I see Knowledge page is Opened
    Given I click to view the available Knowledge List Views
    When I click on Draft Articles list view
    Then I can view the list of Draft Articles
    Given I click to view options on the Action button
    When I select the Publish option
    And I click the Publish button
    Given I click Show Navigation Menu
    When I click Knowledge List Item
    Then I see Knowledge page is Opened
    #Given I click to view the available Knowledge List Views
    When I click on Publish Articles list view
    Then I can view the list of Published Articles
    And I can view the new draft Artcle Published
    
 @Editthepublishedarticles
 Scenario: 13:Edit the Published Articles
 
    Given Action button of a Published Article is clicked
    When I select Edit as Draft
    Then window to confirm Edit as Draft is displayed
    Given I click the Edit as Draft button
    When I Edit the Knowledge Article URL
     And I click Save Knowledge button
    Then The Publication Status changed to Draft
    
