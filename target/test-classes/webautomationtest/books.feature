Feature: Automated UI Testing

Scenario: Browse books without results
  Given User go to books page
  When User in “Book Store” page
  And User search book “qa engineer”
  Then User see “No rows found”

Scenario: Browse Git guide books
  Given User go to books page
  When User in “Book Store” page
  And User search book “Git Pocket Guide”
  And User click book “Git Pocket Guide”
  Then User see “Git Pocket Guide”