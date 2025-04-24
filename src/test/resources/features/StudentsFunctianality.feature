Feature: Testing the adding new Students Functionality

  Background: Successful login
    Given User provides username and password and clicks LogIn button and validates url
    When User goes to 'Students' page

  Scenario Outline: Creating new Students Functionality
    Then User click on the Add students
    And User provides first name '<firstName>', last name '<lastName>', phone '<phone>', email '<email>'
    And User choose Group '<group>' and Study format '<studyFormat>' and click Add button
    Then User validate successful message 'New student successfully saved'

    Examples:
      | firstName | lastName | phone      | email            | group  | studyFormat |
      | Marilyn   | Monroe   | 2242963285 | monroe@gmail.com | Batch8 | ONLINE      |
      | Robert    | Downey   | 2242945869 | rob@gmail.com    | Batch7 | OFFLINE     |
      | Tom       | Hanks    | 2242963274 | tom@gmail.com    | Batch8 | ONLINE      |

  Scenario Outline: Duplication Students Functionality
    Then User click on the Add students
    And User provides first name '<firstName>', last name '<lastName>', phone '<phone>', email '<email>'
    And User choose Group '<group>' and Study format '<studyFormat>' and click Add button
    Then User validate negative message 'User with the same email already exists'

    Examples:
      | firstName | lastName | phone      | email            | group  | studyFormat |
      | Marilyn   | Monroe   | 2242963285 | monroe@gmail.com | Batch8 | ONLINE      |
      | Robert    | Downey   | 2242945869 | rob@gmail.com    | Batch7 | OFFLINE     |