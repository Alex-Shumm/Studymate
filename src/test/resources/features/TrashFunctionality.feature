Feature: Testing Trash functionality

  Background: : Happy Login
    Given User provides username and password and clicks LogIn button and validates url
    When User goes to 'Trash' page

  Scenario: Testing delete from Trash
    Given User validates header and first item 'Test Test' and '2025-03-19'
    Given User deletes first item in the trash and validates 'Data deleted successfully'
    Then User validates that 'Test Test' was deleted

  Scenario: Testing recover from the trash
    Given User validates header and first item 'Tom Hanks' and '2025-03-20'
    When User recovers first item in the trash and validates 'Data successfully recovered'
    Then User validates that 'Tom Hanks' was deleted
    And User goes to 'Students' page
    Then User validates first items full name 'Tom Hanks', group 'Batch8', format 'ONLINE', phone '+1 224 296 3274'

