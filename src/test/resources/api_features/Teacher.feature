@api
Feature: Testing Adding New Teacher Functionality

  Scenario: Adding New Teacher Functionality (addTeacher --> POST)
    Then  User validates 'Sara', 'Hat','2003334554', 'sarahat@mail.com', 'Cucumber' and '1' from end-point

  Scenario: Happy Path Check New Teacher (addTeacher --> GET)
    Then User validates 'Sara', 'Hat','2003334554', 'sarahat@mail.com', 'Cucumber' from end-point get

  Scenario: Update Teacher Information (updateTeacher --> PUT)
    Then  User updates 'Sandra','Hat','2003334554', 'sarahat@mail.com', 'Cucumber', '1' and validates 'Instructor successfully updated' from end-point put

  Scenario: Delete Teacher Information (deleteTeacher --> DELETE)
    Then  User validates 'Instructor successfully deleted' from end-point Delete
    Then User validates message 'Data deleted successfully' delete and check it again