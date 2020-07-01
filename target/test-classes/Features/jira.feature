Feature: validating task creation in Jira

Scenario Outline: Creating issue in Jira

Given Session created with "<username>" and "<password>"
And "CreateIssue" payload is transferred
When "HttpCreateIssuePOSTMethos" is called
Then Issue is successfully created.

Examples:
|username     |password |
|dhana17111985|June@2020|
