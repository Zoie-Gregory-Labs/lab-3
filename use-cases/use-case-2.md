# Use Case 2: Produce Salary Report by Department

**Goal in Context:** As an HR advisor, I want to produce a report on the salary of employees in a department so that I can support financial reporting of the organisation.

**Scope:** HR System

**Level:** User goal

**Preconditions:**
- HR advisor is logged in.
- Employee and salary records are available.

**Success Condition:** A report showing employees and their current salaries in the selected department is displayed.

**Failed Condition:** No report is produced, and the system displays an appropriate error.

**Primary Actor:** HR Advisor

**Trigger:** HR advisor selects the option to produce a salary report by department.

**Main Success Scenario:**
1. HR advisor opens the salary reports section.
2. HR advisor selects the department.
3. HR System retrieves employees belonging to that department.
4. HR System retrieves their current salary records.
5. HR System displays the department salary report.
6. HR advisor reviews and prints or exports the report.

**Extensions:**
- If no employees are found, the system displays a no-results message.
- If the database is unavailable, the system displays an error and allows the HR advisor to retry.

**Sub-variations:** HR advisor may select a different department or print or export the report.

**Schedule:** To be delivered as part of the HR System reporting features.
