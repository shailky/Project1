Feature: Buisness Use cases

  @TC1
  Scenario: Use Case 1
    Given I am on Home page
    And I navigate to popular items section
    And I add the element with lowest price "ELEMENT_NAME" into the cart
    When I navigate to the cart
    Then I verify that "ELEMENT_NAME" should be successfully added to the cart

  @TC2
  Scenario: Use case 2
    Given I am on Home page
    When I navigate to popular items section
    Then I verify the count of discounted items as "COUNT" on Home page
    And I verify the discounted value is correct

