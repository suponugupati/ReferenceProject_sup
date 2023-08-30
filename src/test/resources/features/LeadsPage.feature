@SmokeTesting
Feature: Lead Object related Smoke Scenarios

@validateLeadCreationFlow
Scenario: 5.User logs into salesforce and creates a new Lead
Given I launch the Salesforce application
When I enter the "UserName" and "Password"
And I click on LogIn Button
Then I logged into the Salesforce application successfully
Given I click on Applauncher
When I click on Sales button
#Then I see Sales Console Application
When I click Leads Listview
And I click New Button
Then I see New Leads Page
Given I create a New Lead
Then New Lead is created

@EditLeadStatusandSubmitforapproval
Scenario: 6.User Edits the Lead status and submits it for approval
Given I try to Edit the Lead
And I submit the lead for approval

@CampaignAdditiontoLead
Scenario: 7. Associate Campaigns to the lead after Submission
Given I click on Campaign History tab
When I Add an existing campaign
And I Choose a campaign
Then I save the campaign


