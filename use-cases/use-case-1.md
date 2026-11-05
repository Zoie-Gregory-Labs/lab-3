# Use Case 1: Produce Salary Report for All Employees

**Goal in Context:** As an HR advisor, I want to produce a report on the salary of all employees so that I can support financial reporting of the organisation.

**Scope:** HR System

**Level:** User goal

**Preconditions:**
- HR advisor is logged in.
- Employee and current salary records are available.

**Success Condition:** A report showing each employee's name, employee number and current salary is displayed and can be printed or exported.

**Failed Condition:** No report is produced, and the system displays an appropriate error.

**Primary Actor:** HR Advisor

**Trigger:** HR advisor selects the option to produce a salary report for all employees.

**Main Success Scenario:**
1. HR advisor opens the salary reports section.
2. HR advisor selects "All employees".
3. HR System retrieves employee details and current salary records.
4. HR System matches each employee with their current salary.
5. HR System displays the salary report.
6. HR advisor reviews and prints or exports the report.

**Extensions:**
- If no records are found, the system displays a no-results message.
- If the database is unavailable, the system displays an error and allows the HR advisor to retry.

**Sub-variations:** HR advisor may print or export the report.

**Schedule:** To be delivered as part of the HR System reporting features.
