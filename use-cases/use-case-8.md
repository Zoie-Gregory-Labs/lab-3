# Use Case 8: Delete Employee Details

**Goal in Context:** As an HR advisor, I want to delete employee details to comply with data retention legislation.

**Scope:** HR System

**Level:** User goal

**Preconditions:**
- HR advisor is logged in.
- The employee exists in the system.
- The employee's records are eligible for deletion under the retention policy.

**Success Condition:** The employee's details are deleted in accordance with the organisation's data retention policy.

**Failed Condition:** The employee's details are not deleted, and the system displays an appropriate error.

**Primary Actor:** HR Advisor

**Trigger:** HR advisor selects an employee and chooses to delete their details.

**Main Success Scenario:**
1. HR advisor opens the employee management section.
2. HR advisor searches for an employee.
3. HR System displays matching employees.
4. HR advisor selects the employee.
5. HR System displays the employee's details.
6. HR advisor chooses the delete option.
7. HR System asks the HR advisor to confirm deletion.
8. HR advisor confirms the deletion.
9. HR System deletes the eligible employee details.
10. HR System confirms that the deletion was successful.

**Extensions:**
- If no matching employee is found, the system displays a no-results message.
- If the records are not eligible for deletion, the system prevents deletion and explains why.
- If the database is unavailable, the system displays an error and allows the HR advisor to retry.

**Sub-variations:** HR advisor may cancel the deletion at the confirmation stage.

**Schedule:** To be delivered as part of the HR System employee management features.
