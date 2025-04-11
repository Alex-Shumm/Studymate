@api
Feature: Testing Login End Points

  Scenario: Happy Path Login (Auth EndPoint POST)
    Then User validates email 'admin@codewise.academy', authority 'ADMIN', workspaceId '1', language 'EN'


  Scenario Outline: Negative Path Login
    Then User provides email '<email>', password '<password>', then validates status '<status>', message '<message>' and statusCode '<statusCode>'
    Examples:
      | email                  | password       | status      | message                                   | statusCode |
      | test1@gmail.com        | WiseCoder2024! | NOT_FOUND   | User with email test1@gmail.com not found | 404        |
      | admin@codewise.academy | test           | BAD_REQUEST | Invalid email or password                 | 400        |

  Scenario: Happy reset password (Auth EndPoint POST)
    Then User validates message 'Password reset email sent to this email'