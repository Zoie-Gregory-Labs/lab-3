# Use Case 5: Add New Employee Details

**Goal in Context:** As an HR advisor, I want to add new employee details so that the employee can be paid.

**Scope:** HR System

**Level:** User goal

**Preconditions:**
- HR advisor is logged in.
- The new employee's information is available.

**Success Condition:** The new employee's details are saved successfully in the HR System.

**Failed Condition:** The employee's details are not saved, and the system displays an error.

**Primary Actor:** HR Advisor

**Trigger:** HR advisor selects the option to add a new employee.

**Main Success Scenario:**
1. HR advisor opens the employee management section.
2. HR advisor selects "Add new employee".
3. HR System displays the employee information form.
4. HR advisor enters the employee's personal and employment details.
5. HR advisor reviews the information.
6. HR advisor submits the form.
7. HR System validates and saves the details.
8. HR System confirms that the employee has been added.

**Extensions:**
- If required information is missing, the system asks the HR advisor to complete it.
- If the employee number already exists, the system displays an error.
- If the database is unavailable, the system displays an error and allows the HR advisor to retry.

**Sub-variations:** HR advisor may cancel the process before submitting the form.

**Schedule:** To be delivered as part of the HR System employee management features.
