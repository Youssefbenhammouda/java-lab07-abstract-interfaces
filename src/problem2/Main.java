package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static IHelpDesk helpDesk = new HelpDesk();

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            System.out.println("===== Help Desk =====");
            System.out.println("1. Load from input format");
            System.out.println("2. Add employee");
            System.out.println("3. Add ticket");
            System.out.println("4. Complete ticket");
            System.out.println("5. Show report");
            System.out.println("6. Reset");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> loadFromInput();
                case "2" -> {
                    System.out.print("FullName,PointLevel,Category1 Category2...: ");
                    helpDesk.addEmployee(parseEmployee(scanner.nextLine()));
                }
                case "3" -> {
                    System.out.print("Id,Name,Category,Point: ");
                    helpDesk.addTicket(parseTicket(scanner.nextLine()));
                }
                case "4" -> {
                    System.out.print("FullName,TicketId: ");
                    completeTicket(scanner.nextLine());
                }
                case "5" -> printReport();
                case "6" -> {
                    helpDesk = new HelpDesk();
                    System.out.println("Help desk reset.");
                }
                case "0" -> {
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void loadFromInput() {
        System.out.println("Paste the input:");
        int n = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < n; i++) {
            helpDesk.addEmployee(parseEmployee(scanner.nextLine()));
        }
        int m = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < m; i++) {
            helpDesk.addTicket(parseTicket(scanner.nextLine()));
        }
        int k = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < k; i++) {
            completeTicket(scanner.nextLine());
        }
        printReport();
    }

    private static IEmployee parseEmployee(String line) {
        String[] parts = line.split(",");
        List<Category> categories = new ArrayList<>();
        for (String c : parts[2].trim().split("\\s+")) {
            categories.add(Category.valueOf(c));
        }
        return new Employee(parts[0].trim(), Integer.parseInt(parts[1].trim()), categories);
    }

    private static ITicket parseTicket(String line) {
        String[] parts = line.split(",");
        return new Ticket(
                Integer.parseInt(parts[0].trim()),
                parts[1].trim(),
                Category.valueOf(parts[2].trim()),
                Integer.parseInt(parts[3].trim())
        );
    }

    private static void completeTicket(String line) {
        String[] parts = line.split(",");
        helpDesk.completeTicket(parts[0].trim(), Integer.parseInt(parts[1].trim()));
    }

    private static void printReport() {
        System.out.println("WaitingTicketCount:" + helpDesk.getWaitingTicketCount());
        System.out.println("CompletedTicketsTotalPoint:" + helpDesk.getCompletedTicketsTotalPoint());
        System.out.println("TicketsTotalPointByCategory:");
        for (CategoryNode node : helpDesk.getTicketsTotalPointByCategory()) {
            System.out.println(node.category + ":" + node.totalPoint);
        }
        System.out.println("TicketsTotalPointByEmployee:");
        for (EmployeeNode node : helpDesk.getTicketsTotalPointByEmployee()) {
            System.out.println(node.employee.getFullName() + ":" + node.totalPoint);
        }
    }
}
