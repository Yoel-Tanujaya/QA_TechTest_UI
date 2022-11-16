Feature: Automated UI Testing

Scenario: Select all menus
  Given user go to homepage
  When user in “select menu” page
  And user choose select value “Another root option”
  And user choose select one “Other”
  And user choose old style select menu “Aqua”
  And user choose multi select drop down “all color”
  Then user success input all select menu