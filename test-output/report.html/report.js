$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/InputMethods.feature");
formatter.feature({
  "name": "Check the input methods in feature file",
  "description": "  I want Check the input methods in feature file",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Title for scenario outline",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@so"
    }
  ]
});
formatter.step({
  "name": "I lauch the URL\"https://phptravels.com/demo/\"",
  "keyword": "Given "
});
formatter.step({
  "name": "I want to write a step with \"\u003cfirstname\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "I check for the \"\u003clastname\u003e\" in step",
  "keyword": "Then "
});
formatter.step({
  "name": "I verify the \"\u003cbusinessname\u003e\" in step",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "firstname",
        "lastname",
        "businessname"
      ]
    },
    {
      "cells": [
        "NIB",
        "PT",
        "QEA"
      ]
    },
    {
      "cells": [
        "AJU",
        "Rahma",
        "Q2"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Title for scenario outline",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@so"
    }
  ]
});
formatter.before({
  "status": "skipped"
});
formatter.before({
  "status": "skipped"
});
formatter.step({
  "name": "I lauch the URL\"https://phptravels.com/demo/\"",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdef.i_lauch_the_URL(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I want to write a step with \"NIB\"",
  "keyword": "When "
});
formatter.match({
  "location": "Stepdef.i_want_to_write_a_step_with(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I check for the \"PT\" in step",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdef.i_check_for_the_in_step(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I verify the \"QEA\" in step",
  "keyword": "And "
});
formatter.match({
  "location": "Stepdef.i_verify_the_in_step(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "skipped"
});
formatter.scenario({
  "name": "Title for scenario outline",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@so"
    }
  ]
});
formatter.before({
  "status": "skipped"
});
formatter.before({
  "status": "skipped"
});
formatter.step({
  "name": "I lauch the URL\"https://phptravels.com/demo/\"",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdef.i_lauch_the_URL(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I want to write a step with \"AJU\"",
  "keyword": "When "
});
formatter.match({
  "location": "Stepdef.i_want_to_write_a_step_with(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I check for the \"Rahma\" in step",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdef.i_check_for_the_in_step(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I verify the \"Q2\" in step",
  "keyword": "And "
});
formatter.match({
  "location": "Stepdef.i_verify_the_in_step(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "skipped"
});
});