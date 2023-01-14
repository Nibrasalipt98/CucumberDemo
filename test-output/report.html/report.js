$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/Feature1.feature");
formatter.feature({
  "name": "Navigate to google",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Navigate to google",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I open browser and navigate to \"https://www.google.com\"",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdef.i_open_browser_and_navigate_to_google(String)"
});
formatter.write("Opened the url with https://www.google.com");
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:Features/Feature2.feature");
formatter.feature({
  "name": "Navigate to amazon",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Navigate to amazon",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I open browser and navigate to \"https://www.amazon.com\"",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdef.i_open_browser_and_navigate_to_google(String)"
});
formatter.write("Opened the url with https://www.amazon.com");
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});