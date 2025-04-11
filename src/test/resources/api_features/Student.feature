@api
Feature: Testing Students End Points

  Scenario: Happy Path Create New Students (Student-Create Endpoint) --> POST
    Then User validates 'Anna','Black', '2242862598','anna@gmail.com', '1' and 'ONLINE' from end-point and validates 'New student successfully saved' message

  Scenario:  Happy Path Check Students (Student-Check Endpoint) --> GET
    Then User validates 'Anna', 'Black','ONLINE', '2242862598','anna@gmail.com' from end-point Get

  Scenario:  Happy Path Students (Student-Check Endpoint) --> PUT
    Then User validates 'Student successfully blocked' from end-point Put

  Scenario:  Happy Path Check Students (Student-Check Endpoint) --> DELETE
    Then User validates 'Student successfully deleted' Delete
    Then User validates message 'Data deleted successfully' delete and check it again