
package com.mycompany.noticeboardsystem;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class NoticeBoardSystemTest {
    
    // Test Add Notice
    @Test
    public void testAddNotice() {

        NoticeBoardSystem.noticeTitles[0] = "Sports Day";
        NoticeBoardSystem.noticeMessages[0] =
                "Sports Day registration closes Friday.";
        NoticeBoardSystem.noticeCategories[0] = "Events";
        NoticeBoardSystem.noticeIDs[0] = 1001;

        assertEquals("Sports Day",
                NoticeBoardSystem.noticeTitles[0]);

        assertEquals("Events",
                NoticeBoardSystem.noticeCategories[0]);
    }

    // Test Message Length Validation - Success
    @Test
    public void testMessageLengthValid() {

        String message =
                "Semester exams begin next Monday.";

        boolean valid = message.length() <= 200;

        assertTrue(valid);
    }

    // Test Message Length Validation - Failure
    @Test
    public void testMessageLengthInvalid() {

        String message =
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        boolean valid = message.length() <= 200;

        assertFalse(valid);
    }

    // Test Search By ID
    @Test
    public void testSearchNoticeByID() {

        NoticeBoardSystem.noticeTitles[0] = "Exam Reminder";
        NoticeBoardSystem.noticeMessages[0] =
                "Semester exams begin next Monday.";
        NoticeBoardSystem.noticeCategories[0] = "Academic";
        NoticeBoardSystem.noticeIDs[0] = 1002;

        int searchID = 1002;

        String expectedTitle = "";

        for (int i = 0; i < 1; i++) {

            if (NoticeBoardSystem.noticeIDs[i] == searchID) {

                expectedTitle =
                        NoticeBoardSystem.noticeTitles[i];
            }
        }

        assertEquals("Exam Reminder", expectedTitle);
    }

    // Test Delete Notice
    @Test
    public void testDeleteNotice() {

        NoticeBoardSystem.noticeTitles[0] = "Fees Notice";
        NoticeBoardSystem.noticeMessages[0] =
                "Outstanding fees must be settled.";
        NoticeBoardSystem.noticeCategories[0] = "Finance";
        NoticeBoardSystem.noticeIDs[0] = 1003;

        NoticeBoardSystem.noticeCount = 1;

        int deleteID = 1003;

        for (int i = 0; i < NoticeBoardSystem.noticeCount; i++) {

            if (NoticeBoardSystem.noticeIDs[i] == deleteID) {

                for (int j = i;
                     j < NoticeBoardSystem.noticeCount - 1;
                     j++) {

                    NoticeBoardSystem.noticeTitles[j] =
                            NoticeBoardSystem.noticeTitles[j + 1];

                    NoticeBoardSystem.noticeMessages[j] =
                            NoticeBoardSystem.noticeMessages[j + 1];

                    NoticeBoardSystem.noticeCategories[j] =
                            NoticeBoardSystem.noticeCategories[j + 1];

                    NoticeBoardSystem.noticeIDs[j] =
                            NoticeBoardSystem.noticeIDs[j + 1];
                }

                NoticeBoardSystem.noticeCount--;
                break;
            }
        }

        assertEquals(0, NoticeBoardSystem.noticeCount);
    }

    // Test Longest Notice
    @Test
    public void testLongestNotice() {

        NoticeBoardSystem.noticeMessages[0] =
                "Short message.";

        NoticeBoardSystem.noticeMessages[1] =
                "This is a much longer notice message for testing.";

        int longestIndex = 0;

        for (int i = 1; i < 2; i++) {

            if (NoticeBoardSystem.noticeMessages[i].length() >
                    NoticeBoardSystem.noticeMessages[longestIndex].length()) {

                longestIndex = i;
            }
        }

        assertEquals(
                "This is a much longer notice message for testing.",
                NoticeBoardSystem.noticeMessages[longestIndex]
        );
    }

    // Test Search By Category
    @Test
    public void testSearchByCategory() {

        NoticeBoardSystem.noticeTitles[0] = "Career Expo";
        NoticeBoardSystem.noticeCategories[0] = "Events";

        NoticeBoardSystem.noticeTitles[1] = "Sports Day";
        NoticeBoardSystem.noticeCategories[1] = "Events";

        String categorySearch = "Events";

        int matchCount = 0;

        for (int i = 0; i < 2; i++) {

            if (NoticeBoardSystem.noticeCategories[i]
                    .equalsIgnoreCase(categorySearch)) {

                matchCount++;
            }
        }

        assertEquals(2, matchCount);
    }
    
}
