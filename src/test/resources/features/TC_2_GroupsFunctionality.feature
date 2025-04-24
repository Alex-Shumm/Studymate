Feature: Testing the adding new Groups Functionality

  Background: Successful login
    Given User provides username and password and clicks LogIn button and validates url
    When User goes to 'Groups' page

  Scenario Outline: Creating new Groups Functionality
    Then User click on the Create groups
    And User provides group name '<groupName>', description '<description>' and upload picture
    And User click Create button
    Then User validate successful group message 'Group successfully saved'

    Examples:
      | groupName | description            |
      | Batch8    | Full Stack SDET Course |
      | Batch7    | Full Stack SDET Course |