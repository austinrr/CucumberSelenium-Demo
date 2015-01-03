$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("iterationTests/userCreation.feature");
formatter.feature({
  "line": 1,
  "name": "User Creation",
  "description": "",
  "id": "user-creation",
  "keyword": "Feature"
});
formatter.before({
  "duration": 10916127100,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Create Valid User",
  "description": "",
  "id": "user-creation;create-valid-user",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Runme"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I am on the NewUser page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I submit a new user:",
  "rows": [
    {
      "cells": [
        "name",
        "email"
      ],
      "line": 7
    },
    {
      "cells": [
        "Austin",
        "austin@rhodes.com"
      ],
      "line": 8
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I am directed to the User list page",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "The user appears in the list",
  "keyword": "And "
});
formatter.match({
  "location": "userCreationStepDefs.i_am_on_the_NewUser_page()"
});
formatter.result({
  "duration": 485346600,
  "status": "passed"
});
formatter.match({
  "location": "userCreationStepDefs.i_submit_a_new_user(DataTable)"
});
formatter.result({
  "duration": 1446327600,
  "status": "passed"
});
formatter.match({
  "location": "userCreationStepDefs.i_am_directed_to_the_User_list_page()"
});
formatter.result({
  "duration": 26234500,
  "status": "passed"
});
formatter.match({
  "location": "userCreationStepDefs.the_user_appears_in_the_list()"
});
formatter.result({
  "duration": 35855830900,
  "error_message": "java.lang.AssertionError: Matches needed should be equal to matches found.\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat iterationTests.userCreationStepDefs.the_user_appears_in_the_list(userCreationStepDefs.java:83)\r\n\tat ✽.And The user appears in the list(iterationTests/userCreation.feature:10)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 388874200,
  "status": "passed"
});
});