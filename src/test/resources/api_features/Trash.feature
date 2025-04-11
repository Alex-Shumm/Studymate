@api
Feature: Testing Trash End Points

  Scenario: Happy Path Get All Trash's Items (GET)
    Then User validates name 'Test Test', type 'STUDENT', entityId '287', createdAt '2025-04-11', restorer 'ADMIN', courseId '0'

  Scenario: Happy Path Recover From Trash (PUT)
    Then User validates message 'Data successfully recovered' recover and check it again

  Scenario: Happy Path Delete From Trash (DELETE)
    Then User validates message 'Data deleted successfully' delete and check it again