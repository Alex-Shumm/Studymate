Feature: Testing Login and Logout Functionality

  Scenario: Testing happy Path Login
    Given User provides username and password and clicks LogIn button and validates url


  Scenario Outline: Testing Negative Login

    Given User provides '<username>' and '<password>'
    When User clicks signIn button and validates failed message '<message>'

    Examples:
      | username               | password       | message                                       |
      | codewiser@gmail.com    | WiseCoder2024! | User with email codewiser@gmail.com not found |
      | admin@codewise.academy | Wrong123       | Invalid email or password                     |

  Scenario: Testing happy Logout
    Given User provides username and password and clicks LogIn button and validates url
    When User clicks Administrator and Log out buttons
    And User confirms Log out and validates URL