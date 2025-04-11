Feature: Testing Trash functionality

  Background: : Happy Login
    Given User provides username and password and clicks LogIn button and validates url
    When User goes to 'Trash' page

  Scenario: Testing delete from Trash
    Given User validates header and first item 'Jamal Pak' and '2025-03-28'
    Given User deletes first item in the trash and validates 'Data deleted successfully'
    Then User validates that 'Jamal Pak' was deleted

  Scenario: Testing recover from the trash
    Given User validates header and first item 'Clay Drake' and '2025-03-28'
    When User recovers first item in the trash and validates 'Data successfully recovered'
    Then User validates that 'Clay Drake' was deleted
    And User goes to 'Students' page
    Then User validates first items full name 'Clay Drake', group 'Our group', format 'ONLINE', phone '+1 224 296 3274'

