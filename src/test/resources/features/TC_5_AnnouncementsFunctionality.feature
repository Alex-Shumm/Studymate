
Feature: Testing the adding new Announcements Functionality
  Background: : Happy Login
    Given User provides username and password and clicks LogIn button and validates url
    When User goes to 'Announcements' page

  Scenario Outline: Creating new Announcements Functionality
    Given User clicks on the Add an announcement
    And User provides text of announcement '<text>', choose group '<group>' and click Add button
    Then User validate successful announcement message 'Announcement successfully saved'

    Examples:
      | text                                                                  | group  |
      | Dear Students! You have mock interview in upcoming Friday! 03/28/2025 | Batch8 |

  Scenario: Validate created announcement
    Then User validates type 'Hidden', for whom 'Batch8', who created 'ADMIN', text 'Dear Students! You have mock interview in upcoming Friday! 03/28/2025' and data '03.28.25'


  Scenario: Change visibility and validate it
    When User clicks three dots and clicks Show button
    And User applies and validates 'Announcement successfully activated'

  Scenario: Deleting Announcement Functionality
    Given User clicks three dots and clicks Delete button
    When User confirms delete and validates 'ANNOUNCEMENT successfully deleted'
