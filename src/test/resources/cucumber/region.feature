Feature: Regions by point
  Scenario: a point inside with just one region
    Given a valid region
    And a point (5, 2)
    When get rectangles by point
    Then should be exist exactly 1 rectangules
    And should have this rectangules:
      | F |
      | G |
