Feature: Regions by point

  Scenario: a point inside with just one region
    Given the region with this rectangles:
      | 0 | 1 | 5 | 6 |
    And a point (2, 3)
    When get rectangles by point
    Then should be exist exactly 1 rectangles
    And should have this rectangles:
      | 0 | 1 | 5 | 6 |
