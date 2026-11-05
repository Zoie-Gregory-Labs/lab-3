# Use Case 4: Produce Salary Report by Role

**Goal in Context:** As an HR advisor, I want to produce a report on the salary of employees with a given role so that I can support financial reporting of the organisation.

**Scope:** HR System

**Level:** User goal

**Preconditions:**
- HR advisor is logged in.
- Employee, salary and job-title records are available.

**Success Condition:** A report showing employees with the selected role and their current salaries is displayed.

**Failed Condition:** No report is produced, and the system displays an appropriate error.

**Primary Actor:** HR Advisor

**Trigger:** HR advisor selects the option to produce a salary report by role.

**Main Success Scenario:**
1. HR advisor opens the salary reports section.
2. HR advisor selects a job role.
3. HR System retrieves employees with that role.
4. HR System retrieves their current salary records.
5. HR System displays the salary report.
6. HR advisor reviews and prints or exports the report.

**Extensions:**
- If no employees match the selected role, the system displays a no-results message.
- If the database is unavailable, the system displays an error and allows the HR advisor to retry.

**Sub-variations:** HR advisor may select another role or print or export the report.

**Schedule:** To be delivered as part of the HR System reporting features.
