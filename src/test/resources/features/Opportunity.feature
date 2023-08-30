@SmokeTesting 
Feature: Opportunity Object related Smoke Scenarios

  @validateLeadconversiontoOpportunity
  Scenario: 8.Approval of leads and converting to opportunity
  Given I launch the Salesforce application
  When I enter the "UserName" and "Password"
  And I click on LogIn Button
  Then I logged into the Salesforce application successfully
  Given I click on Applauncher
  When I click on Sales button
  When I click Leads Listview
  Given I click on Existing Leads
  When I try to convert Lead
  Then I see convert lead window
  When I give new opportunity name while conversion
  And I click on Convert
  Then Lead is converted into Opportunity
  
  @OpportunityListviewvalidation
  Scenario: 9.Validation of All,My and Closed opportunity list views
  Given I Click on Opportunity List View
  When I select All Opportunities List View
  Then All Opportunities are displayed
  When I select My Opportunities List View
  Then My Opportunities are displayed
  When I select Opportunities Closing next month List View
  Then Closing Opportunities are displayed
  
  @ClosinganOpportunity
  Scenario: 10.Closing an Opportunity by changing the stage to Close/won
  Given I Click on Opportunity List View
  When I try to edit the Opportunity
  Then Opportunity Edit Window is opened
  When I try to edit the Opportunity Stage to Closed Won
  Then Opportunity is saved with Closed Won Stage
  
  
  
  
  