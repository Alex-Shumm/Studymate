Feature: Testing Teacher Functionality

  Background: Successful login
    Given User provides username and password and clicks LogIn button and validates url
    When User goes to 'Teacher' page

  Scenario Outline: Adding new Teacher Functionality
    Then User clicks on the Add teacher
    And User provides first name '<firstName>', last name '<lastName>', phone '<phone>', email '<email>', specialization '<specialization>'
    And User chooses Courses '<courses>' and clicks Add button
    Then User validates successful message 'Instructor successfully saved'


    Examples:
      | firstName | lastName | phone      | email                 | specialization   | courses  |
      | Jacob     | Grey     | 9293455566 | jacobgrey@hotmail.com | Computer Science | Selenium |
      | Alexander | Bill     | 9456345665 | alexander@hotmail.com | Computer Science | Cucumber |
      | Kira      | Pak      | 7373453344 | kirapak@hotmail.com   | Computer Science | Cucumber |

  Scenario Outline: Duplicate Teachers Addition
    Then User clicks on the Add teacher
    And User provides first name '<firstName>', last name '<lastName>', phone '<phone>', email '<email>', specialization '<specialization>'
    And User chooses Courses '<courses>' and clicks Add button
    Then User validates warning message 'User with the same email already exists'

    Examples:
      | firstName | lastName | phone      | email               | specialization | courses  |
      | Kate      | Peterson | 9293456655 | kirapak@hotmail.com | Math           | Selenium |

  Scenario Outline: Edit Button Functionality
    And User presses Actions button and clicks Edit button
    And User provides new first name '<firstName>', phone '<phone>', specialization '<specialization>'
    And User clicks Save button
    Then Validates successful edit message 'Instructor successfully updated'

    Examples:
      | firstName | phone      | specialization |
      | Jamal     | 9293458888 | Python         |

  Scenario: Delete Button Functionality
    And User presses Actions button and clicks Delete button
    And User clicks Delete button in pop up message
    Then Validates successful deletion message 'Instructor successfully deleted'