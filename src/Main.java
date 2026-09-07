import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("===== Library Lending System =====");
            System.out.println("1. Add Item");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Item");
            System.out.println("4. Return Item");
            System.out.println("5. List Catalog");
            System.out.println("6. Report");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            try {

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("Item type (Book/Magazine/DVD): ");
                        String type = scanner.nextLine();

                        System.out.print("Title: ");
                        String title = scanner.nextLine();

                        if (type.equalsIgnoreCase("Book")) {

                            System.out.print("Author: ");
                            String author = scanner.nextLine();

                            System.out.print("Pages: ");
                            int pages = scanner.nextInt();
                            scanner.nextLine();

                            Book book = new Book(title, author, pages);
                            library.addItem(book);

                        } else if (type.equalsIgnoreCase("Magazine")) {

                            System.out.print("Issue number: ");
                            int issueNumber = scanner.nextInt();
                            scanner.nextLine();

                            Magazine magazine =
                                    new Magazine(title, issueNumber);

                            library.addItem(magazine);

                        } else if (type.equalsIgnoreCase("DVD")) {

                            System.out.print("Runtime minutes: ");
                            int runtimeMinutes = scanner.nextInt();
                            scanner.nextLine();

                            DVD dvd =
                                    new DVD(title, runtimeMinutes);

                            library.addItem(dvd);

                        } else {
                            System.out.println("Invalid item type.");
                        }

                        break;

                    case 2:
                        System.out.print("Member id: ");
                        String memberId = scanner.nextLine();

                        System.out.print("Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Max allowed: ");
                        int maxAllowed = scanner.nextInt();
                        scanner.nextLine();

                        Member member =
                                new Member(memberId, name, maxAllowed);

                        library.addMember(member);

                        break;

                    case 3:
                        System.out.print("Member id: ");
                        String borrowMemberId = scanner.nextLine();

                        System.out.print("Item id: ");
                        String borrowItemId = scanner.nextLine();

                        try {
                            library.borrowItem(
                                    borrowMemberId,
                                    borrowItemId
                            );
                        } catch (LibraryException e) {
                            System.out.println(
                                    "Could not borrow: " + e.getMessage()
                            );
                        }

                        break;

                    case 4:
                        System.out.print("Member id: ");
                        String returnMemberId = scanner.nextLine();

                        System.out.print("Item id: ");
                        String returnItemId = scanner.nextLine();

                        try {
                            library.returnItem(
                                    returnMemberId,
                                    returnItemId
                            );
                        } catch (LibraryException e) {
                            System.out.println(
                                    "Could not return: " + e.getMessage()
                            );
                        }

                        break;

                    case 5:
                        library.listCatalog();
                        break;

                    case 6:
                        library.printReport();
                        break;

                    case 7:
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice.");

                }

            } catch (Exception e) {

                System.out.println("Invalid input.");

                scanner.nextLine();
            }
        }

        scanner.close();
    }
}