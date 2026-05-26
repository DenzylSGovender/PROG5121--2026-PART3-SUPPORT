# Campus Notice Board System

## Programming 1A Practical Project

---

# Overview

Develop a **console-based Java application** for a Campus Notice Board System.

The system will allow staff members to:

- Add notices
- Store notices in arrays
- Search notices
- Delete notices
- Generate reports

This project focuses on:

- Arrays
- Loops
- Methods
- String manipulation

---

# Scenario

A college wants a digital notice board system where staff members can create and manage student notices.

The system must store notices and allow users to search, delete, and display reports.

---

# Arrays Required

Create arrays for the following:

| Array Name | Purpose |
|---|---|
| `noticeTitles` | Stores notice titles |
| `noticeMessages` | Stores notice messages |
| `noticeCategories` | Stores categories |
| `noticeIDs` | Stores generated notice IDs |
| `archivedNotices` | Stores deleted notices |

---

# Notice Information

Each notice must contain:

| Field | Description |
|---|---|
| Notice ID | Auto-generated number |
| Title | Short title |
| Message | Notice content |
| Category | Academic, Sports, Events, Finance |

---

# Main Menu

Display the following menu repeatedly until the user exits:

```text
1. Add Notice
2. Display All Notices
3. Search Notice by ID
4. Search Notices by Category
5. Delete Notice
6. Display Longest Notice
7. Generate Report
8. Exit
```

---

# Functional Requirements

## Option 1 — Add Notice

Allow the user to:

- Enter a title
- Enter a message
- Select a category

### Validation Rules

- Title cannot be empty
- Message cannot exceed 200 characters

### Output Messages

Success:

```text
Notice successfully added.
```

Failure:

```text
Notice message exceeds 200 characters.
```

---

## Option 2 — Display All Notices

Display:

- Notice ID
- Title
- Category
- Message

---

## Option 3 — Search Notice by ID

Allow the user to enter a Notice ID.

### Display

- Title
- Category
- Message

If not found:

```text
Notice not found.
```

---

## Option 4 — Search Notices by Category

Allow the user to search using a category.

### Example

Input:

```text
Events
```

Output:

```text
Sports Day Registration
Career Expo 2026
```

---

## Option 5 — Delete Notice

Allow the user to delete a notice using the Notice ID.

Deleted notices must be moved into the `archivedNotices` array.

### Output

```text
Notice successfully deleted.
```

---

## Option 6 — Display Longest Notice

Display the notice containing the longest message.

### Output Must Include

- Notice ID
- Title
- Full message

---

## Option 7 — Generate Report

Generate a report displaying:

- Notice ID
- Title
- Category
- Message Length

### Example Output

```text
NOTICE REPORT
---------------------------------
ID: 1001
Title: Sports Day
Category: Events
Message Length: 95
```

---

# Required Methods

Create a class named `NoticeManager`.

| Method | Purpose |
|---|---|
| `addNotice()` | Adds a notice |
| `displayNotices()` | Displays all notices |
| `searchNoticeByID()` | Searches by ID |
| `searchByCategory()` | Searches by category |
| `deleteNotice()` | Deletes a notice |
| `displayLongestNotice()` | Finds longest notice |
| `generateReport()` | Displays report |

---

# Suggested Test Data

| Notice ID | Title | Category | Message |
|---|---|---|---|
| 1001 | Sports Day | Events | Sports Day registration closes Friday. |
| 1002 | Exam Reminder | Academic | Semester exams begin next Monday at 9am. |
| 1003 | Fees Notice | Finance | Outstanding fees must be settled before registration. |
| 1004 | Career Expo | Events | Companies from the IT industry will attend the expo. |

---

# Unit Tests

Create unit tests for:

1. Notice successfully added
2. Message length validation
3. Search by ID
4. Delete notice
5. Longest notice displayed correctly
6. Search by category

---

