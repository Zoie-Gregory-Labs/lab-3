# Use Case 3: Produce Salary Report for Own Department

**Goal in Context:** As a department manager, I want to produce a report on the salary of employees in my department so that I can support my department's financial reporting.

**Scope:** HR System

**Level:** User goal

**Preconditions:**
- Department manager is logged in.
- Employee and current salary records are available.
- The manager is assigned to a department.

**Success Condition:** A report showing employees and their current salaries in the manager's department is displayed.

**Failed Condition:** No report is produced, and the system displays an appropriate error.

**Primary Actor:** Department Manager

**Trigger:** Department manager selects the option to produce a salary report for their department.

**Main Success Scenario:**
1. Department manager opens the salary reports section.
2. HR System identifies the manager's department.
3. HR System retrieves employees belonging to that department.
4. HR System retrieves their current salary records.
5. HR System displays the department salary report.
6. Department manager reviews and prints or exports the report.

**Extensions:**
- If no employees are found, the system displays a no-results message.
- If the database is unavailable, the system displays an error and allows the manager to retry.

**Sub-variations:** Department manager may print or export the report.

**Schedule:** To be delivered as part of the HR System reporting features.
