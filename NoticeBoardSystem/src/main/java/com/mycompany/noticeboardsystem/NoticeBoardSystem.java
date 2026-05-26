

package com.mycompany.noticeboardsystem;

import java.util.Scanner;


public class NoticeBoardSystem {
  // Building the Arrays
    static String[] noticeTitles = new String[100];
    static String[] noticeMessages = new String[100];
    static String[] noticeCategories = new String[100];
    static int[] noticeIDs = new int[100];
    static String[] archivedNotices = new String[100];

    static int noticeCount = 0;
    static int archiveCount = 0;

    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
         int option;

        do {

            System.out.println("\n===== CAMPUS NOTICE BOARD =====");
            System.out.println("1. Add Notice");
            System.out.println("2. Display All Notices");
            System.out.println("3. Search Notice by ID");
            System.out.println("4. Search Notices by Category");
            System.out.println("5. Delete Notice");
            System.out.println("6. Display Longest Notice");
            System.out.println("7. Generate Report");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            option = input.nextInt();
            input.nextLine();

            switch (option) {

                case 1:
                    addNotice();
                    break;

                case 2:
                    displayNotices();
                    break;

                case 3:
                    searchNoticeByID();
                    break;

                case 4:
                    searchByCategory();
                    break;

                case 5:
                    deleteNotice();
                    break;

                case 6:
                    displayLongestNotice();
                    break;

                case 7:
                    generateReport();
                    break;

                case 8:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (option != 8);

    }//End of main method
    
    // Method to Add Notice
    public static void addNotice() {

        System.out.print("Enter Notice Title: ");
        String title = input.nextLine();

        if (title.isEmpty()) {
            System.out.println("Title cannot be empty.");
            return;
        }

        System.out.print("Enter Notice Message: ");
        String message = input.nextLine();

        if (message.length() > 200) {
            System.out.println("Notice message exceeds 200 characters.");
            return;
        }

        System.out.print("Enter Category (Academic/Sports/Events/Finance): ");
        String category = input.nextLine();

        // Auto-generate ID
        int noticeID = 1000 + noticeCount + 1;

        // Store in arrays
        noticeTitles[noticeCount] = title;
        noticeMessages[noticeCount] = message;
        noticeCategories[noticeCount] = category;
        noticeIDs[noticeCount] = noticeID;

        noticeCount++;

        System.out.println("Notice successfully added.");
    }

    // Method to Display Notices
    public static void displayNotices() {

        if (noticeCount == 0) {
            System.out.println("No notices available.");
            return;
        }

        System.out.println("\n===== ALL NOTICES =====");

        for (int i = 0; i < noticeCount; i++) {

            System.out.println("Notice ID: " + noticeIDs[i]);
            System.out.println("Title: " + noticeTitles[i]);
            System.out.println("Category: " + noticeCategories[i]);
            System.out.println("Message: " + noticeMessages[i]);
            System.out.println("--------------------------------");
        }
    }

    // Method to Search by ID
    public static void searchNoticeByID() {

        System.out.print("Enter Notice ID: ");
        int searchID = input.nextInt();

        boolean found = false;

        for (int i = 0; i < noticeCount; i++) {

            if (noticeIDs[i] == searchID) {

                System.out.println("\nNotice Found");
                System.out.println("Title: " + noticeTitles[i]);
                System.out.println("Category: " + noticeCategories[i]);
                System.out.println("Message: " + noticeMessages[i]);

                found = true;
            }
        }

        if (!found) {
            System.out.println("Notice not found.");
        }
    }

    // Method to Search by Category
    public static void searchByCategory() {

        input.nextLine();

        System.out.print("Enter Category: ");
        String categorySearch = input.nextLine();

        boolean found = false;

        System.out.println("\n===== SEARCH RESULTS =====");

        for (int i = 0; i < noticeCount; i++) {

            if (noticeCategories[i].equalsIgnoreCase(categorySearch)) {

                System.out.println("Notice ID: " + noticeIDs[i]);
                System.out.println("Title: " + noticeTitles[i]);
                System.out.println("Message: " + noticeMessages[i]);
                System.out.println("--------------------------------");

                found = true;
            }
        }

        if (!found) {
            System.out.println("No notices found in this category.");
        }
    }

    // Method to Delete Notice
    public static void deleteNotice() {

        System.out.print("Enter Notice ID to delete: ");
        int deleteID = input.nextInt();

        boolean found = false;

        for (int i = 0; i < noticeCount; i++) {

            if (noticeIDs[i] == deleteID) {

                // Store deleted notice
                archivedNotices[archiveCount] =
                        "ID: " + noticeIDs[i] +
                        ", Title: " + noticeTitles[i];

                archiveCount++;

                // Shift arrays left
                for (int j = i; j < noticeCount - 1; j++) {

                    noticeTitles[j] = noticeTitles[j + 1];
                    noticeMessages[j] = noticeMessages[j + 1];
                    noticeCategories[j] = noticeCategories[j + 1];
                    noticeIDs[j] = noticeIDs[j + 1];
                }

                noticeCount--;

                System.out.println("Notice successfully deleted.");
                found = true;

                break;
            }
        }

        if (!found) {
            System.out.println("Notice ID not found.");
        }
    }

    // Method to Display Longest Notice
    public static void displayLongestNotice() {

        if (noticeCount == 0) {
            System.out.println("No notices available.");
            return;
        }

        int longestIndex = 0;

        for (int i = 1; i < noticeCount; i++) {

            if (noticeMessages[i].length() >
                    noticeMessages[longestIndex].length()) {

                longestIndex = i;
            }
        }

        System.out.println("\n===== LONGEST NOTICE =====");
        System.out.println("Notice ID: " + noticeIDs[longestIndex]);
        System.out.println("Title: " + noticeTitles[longestIndex]);
        System.out.println("Message: " + noticeMessages[longestIndex]);
    }

    // Method to Generate Report
    public static void generateReport() {

        if (noticeCount == 0) {
            System.out.println("No notices available.");
            return;
        }

        System.out.println("\n===== NOTICE REPORT =====");

        for (int i = 0; i < noticeCount; i++) {

            System.out.println("Notice ID: " + noticeIDs[i]);
            System.out.println("Title: " + noticeTitles[i]);
            System.out.println("Category: " + noticeCategories[i]);
            System.out.println("Message Length: "
                    + noticeMessages[i].length());

            System.out.println("--------------------------------");
        }
    }
    
}//End of class
