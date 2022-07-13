Feature: Contact us functionality

  Scenario Outline: Test contact us as a registered customer
    Given user is on the home page
    When user clicks on the sign in link
    Then user should be navigated to Login Page
    And user logins with "<email>" and "<password>"
    And user clicks on Contact Us link
    Then user should be navigated to Contact Us Page
    And user selects "<heading>" as a subject heading
    And user email "<email>" should be auto-populated
    And user should pick "<reference>" from the reference dropdown
    And user should attach a picture from path "<picture>"
    And user should enter "<message>" in the message input
    When user clicks on send button
    Then user should see success message "<alert>"

    Examples:
      | email                 | password | heading          | reference | picture                           | message                                                            | alert                                                |
      | kevinlee123@gmail.com | Kevin123 | Customer service | CDIAWIJTG | src/java/resources/pics/error.png | I am not satisfied with this order, can I please get a replacement | Your message has been successfully sent to our team. |
      | kevinlee123@gmail.com | Kevin123 | Webmaster        | SULXKZPMN | src/java/resources/pics/error.png | I am not satisfied with this order, can I please get a replacement | Your message has been successfully sent to our team. |

  Scenario Outline: Test contact us as an un-registered customer
    Given user is on the home page
    And user clicks on Contact Us link
    Then user should be navigated to Contact Us Page
    And user selects "<heading>" as a subject heading
    And user enters "<email>" in the email input
    And user enters "<reference>" in the reference input
    And user should attach a picture from path "<picture>"
    And user should enter "<message>" in the message input
    When user clicks on send button
    Then user should see success message "<alert>"

    Examples:
      | email                 | heading          | reference | picture                           | message                                                            | alert                                                |
      | kevinlee123@gmail.com | Customer service | CDIAWIJTG | src/java/resources/pics/error.png | I am not satisfied with this order, can I please get a replacement | Your message has been successfully sent to our team. |
      | kevinlee123@gmail.com | Webmaster        | SULXKZPMN | src/java/resources/pics/error.png | I am not satisfied with this order, can I please get a replacement | Your message has been successfully sent to our team. |


  Scenario Outline: Test contact us as an un-registered negative scenario
    Given user is on the home page
    And user clicks on Contact Us link
    Then user should be navigated to Contact Us Page
    And user selects "<heading>" as a subject heading
    And user enters "<email>" in the email input
    And user enters "<reference>" in the reference input
    And user should attach a picture from path "<picture>"
    And user should enter "<message>" in the message input
    When user clicks on send button
    Then user should see success message "<alert>"

    Examples:
      | email                 | heading          | reference | picture                           | message                                                            | alert                        |
      | kevinlee123           | Customer service | CDIAWIJTG | src/java/resources/pics/error.png | I am not satisfied with this order, can I please get a replacement | Invalid email address.       |
      | kevinlee123@gmail.com | Webmaster        | SULXKZPMN | src/java/resources/pics/error.png |                                                                    | The message cannot be blank. |


  Scenario Outline: Test contact us as a registered negative scenario
    Given user is on the home page
    When user clicks on the sign in link
    Then user should be navigated to Login Page
    And user logins with "<email>" and "<password>"
    And user clicks on Contact Us link
    Then user should be navigated to Contact Us Page
    And user selects "<heading>" as a subject heading
    And user email "<email>" should be auto-populated
    And user should pick "<reference>" from the reference dropdown
    And user should attach a picture from path "<picture>"
    And user should enter "<message>" in the message input
    When user clicks on send button
    Then user should see success message "<alert>"

    Examples:
      | email                 | password | heading          | reference | picture                           | message | alert                        |
      | kevinlee123@gmail.com | Kevin123 | Customer service | CDIAWIJTG | src/java/resources/pics/error.png |         | The message cannot be blank. |


