$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("cucumber/region.feature");
formatter.feature({
  "line": 1,
  "name": "Regions by point",
  "description": "",
  "id": "regions-by-point",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "a point inside with just one region",
  "description": "",
  "id": "regions-by-point;a-point-inside-with-just-one-region",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "a valid region",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "a point (5, 2)",
  "keyword": "And "
});
formatter.step({
  "line": 5,
  "name": "get rectangles by point",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "should be exist exactly 1 rectangules",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "should have this rectangules:",
  "rows": [
    {
      "cells": [
        "F"
      ],
      "line": 8
    },
    {
      "cells": [
        "G"
      ],
      "line": 9
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "PointInsideRegionTest.given_a_valid_region()"
});
formatter.result({
  "duration": 118637606,
  "error_message": "java.lang.IllegalArgumentException: com.formento.algorithmexercises.pointinrectangle.Region-\u003e No such label: Valid\n\tat br.com.six2six.fixturefactory.ObjectFactory.findRule(ObjectFactory.java:162)\n\tat br.com.six2six.fixturefactory.ObjectFactory.gimme(ObjectFactory.java:60)\n\tat com.formento.algorithmexercises.pointinrectangle.PointInsideRegionTest.given_a_valid_region(PointInsideRegionTest.java:51)\n\tat ✽.Given a valid region(cucumber/region.feature:3)\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 9
    },
    {
      "val": "2",
      "offset": 12
    }
  ],
  "location": "PointInsideRegionTest.and_a_point(Integer,Integer)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PointInsideRegionTest.when_get_rectangles_by_point()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 24
    }
  ],
  "location": "PointInsideRegionTest.should_be_exist_exactly_n_rectangules(Integer)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "PointInsideRegionTest.should_have_this_rectangules(String\u003e)"
});
formatter.result({
  "status": "skipped"
});
});