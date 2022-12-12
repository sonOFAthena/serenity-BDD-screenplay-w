@login
Feature: Login into the application
  @suite1 @dev @login
  Scenario: Successful login
    Given Sergey has a activated account
    When he sends their valid credentials
    Then he should have access to manage his account

  @suite2
  Scenario: Remember things
    Given Pepito wants to remember something
    When he tries to remember Foo
    Then he should get Foo

  @suite3
  Scenario: Remember things
    Given Pepito wants to remember something
    When he tries to remember Foo
    Then he should get Foo

  @foo
  Scenario: Remember things 2
    Given Pepito wants to remember something

  @dev
  Scenario: Successful login 5
    Given Pepito has a token

  @test
  Scenario: Failed 1
    Given Pepito failed 1

  @test
  Scenario: Failed 2
    Given Pepito failed 2

  @test
  Scenario: Compromised 1
    Given Pepito compromised