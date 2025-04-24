@api
Feature: Testing Announcement End Points

  Scenario: Happy Path Create Announcement (POST)
    Then User provides text 'Test', groupId '175' and validates message 'Announcement successfully saved' announcement

  Scenario: Happy Path Get All Announcements (GET)
    Then User validates text 'Test', createdBy 'ADMIN', type 'FOR_GROUP', groupName 'Batch7', groupID '175', date '2025-04-11'.

  Scenario: Happy Path Get New Announcement (GET)
    Then User validates text 'Test', createdBy 'ADMIN', type 'FOR_GROUP', groupName 'Batch7', groupID '175', active 'false', date '2025-04-11', workspaceID '1'

  Scenario Outline: Happy Path Activate/Deactivate Announcement (PUT)
    Then User provides active status '<status>' and validate message '<message>'

    Examples:
      | status | message                               |
      | true   | Announcement successfully activated   |
      | false  | Announcement successfully deactivated |

  Scenario: Happy Path Update Announcement (PUT)
    Then User provides text 'Update', groupId '174' and validates message 'Announcement successfully saved' announcement update
    And User validates text 'Update', createdBy 'ADMIN', type 'FOR_GROUP', groupName 'Batch8', groupID '174', active 'false', date '2025-04-11', workspaceID '1'

  Scenario: Happy Path Delete Announcement (DELETE)
    When User deletes announcement, validates deleted message 'ANNOUNCEMENT successfully deleted' and checks again status 'NOT_FOUND', message 'ANNOUNCEMENT not found'