# Use Case 7: Update Employee Details

**Goal in Context:** As an HR advisor, I want to update employee details so that employee records remain up-to-date.

**Scope:** HR System

**Level:** User goal

**Preconditions:**
- HR advisor is logged in.
- The employee already exists in the system.

**Success Condition:** The employee's updated details are saved successfully.

**Failed Condition:** The changes are not saved, and the system displays an appropriate error.

**Primary Actor:** HR Advisor

**Trigger:** HR advisor selects an employee and chooses to update their details.

**Main Success Scenario:**
1. HR advisor opens the employee management section.
2. HR advisor searches for an employee.
3. HR System displays matching employees.
4. HR advisor selects the employee.
5. HR System displays the employee's current details.
6. HR advisor edits the required information.
7. HR advisor reviews and submits the changes.
8. HR System validates and saves the updated details.
9. HR System confirms that the update was successful.

**Extensions:**
- If no matching employee is found, the system displays a no-results message.
- If required information is missing, the system asks the HR advisor to complete it.
- If the database is unavailable, the system displays an error and allows the HR advisor to retry.

**Sub-variations:** HR advisor may cancel the update before submitting the changes.

**Schedule:** To be delivered as part of the HR System employee management features.
