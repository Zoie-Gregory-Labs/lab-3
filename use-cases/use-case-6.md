# Use Case 6: View Employee Details

**Goal in Context:** As an HR advisor, I want to view employee details so that I can support a promotion request.

**Scope:** HR System

**Level:** User goal

**Preconditions:**
- HR advisor is logged in.
- Employee records are available.

**Success Condition:** The selected employee's details are displayed.

**Failed Condition:** Employee details are not displayed, and the system shows an appropriate error.

**Primary Actor:** HR Advisor

**Trigger:** HR advisor searches for and selects an employee.

**Main Success Scenario:**
1. HR advisor opens the employee management section.
2. HR advisor searches for an employee.
3. HR System displays matching employees.
4. HR advisor selects the correct employee.
5. HR System retrieves the employee's details.
6. HR System displays the employee's information.
7. HR advisor reviews the information to support the promotion request.

**Extensions:**
- If no matching employee is found, the system displays a no-results message.
- If the database is unavailable, the system displays an error and allows the HR advisor to retry.

**Sub-variations:** HR advisor may search using the employee number or name.

**Schedule:** To be delivered as part of the HR System employee management features.
