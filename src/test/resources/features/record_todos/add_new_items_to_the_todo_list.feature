@cucumber
@adding
Feature: Add new todos

  In order to avoid having to remember things that need doing
  As a forgetful person
  I want to be able to record what I need to do in a place where I won't forget about them

  @jacob21
  Scenario: Adding an item to an empty list in Cucumber
    Given that James has an empty todo list
    When he adds 'Buy some milk' to his list
    Then 'Buy some milk' should be recorded in his list

  @jacob22
  Scenario: Adding an item to a list with other items in Cucumber
    Given that Jane has a todo list containing Buy some milk, Walk the dog
    When she adds 'Buy some cereal' to her list
    Then her todo list should contain Buy some milk, Walk the dog, Buy some cereal

  @jacob23
  Scenario: Adding items to several peoples lists in Cucumber
    Given that James has a todo list containing Buy some milk, Walk the dog
    And that Jill has a todo list containing Buy some milk, Buy some cheese
    When she adds 'Buy some cereal' to her list
    Then Jill's todo list should contain Buy some milk, Buy some cheese, Buy some cereal
    And James's todo list should contain Buy some milk, Walk the dog
