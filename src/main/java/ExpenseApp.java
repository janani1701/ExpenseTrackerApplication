import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.List;

public class ExpenseApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User registration
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        User user = new User(username, email);

        ExpenseDatabase database = new ExpenseDatabase();
        ExpenseManager expenseManager = new ExpenseManager(database);
        CustomExpenseViewer customExpenseViewer = new CustomExpenseViewer(database);

        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add new expense");
            System.out.println("2. View expenses for this month");
            System.out.println("3. View expenses for this year");
            System.out.println("4. View expenses for custom month");
            System.out.println("5. View expenses for custom category this month");
            System.out.println("6. View expenses for custom category this year");
            System.out.println("7. View expenses for custom category custom month");
            System.out.println("8. Exit");

            System.out.print("Enter your choice (1-8): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addNewExpense(expenseManager, scanner);
                    break;
                case 2:
                    double monthlyTotal = expenseManager.getTotalExpensesThisMonth();
                    System.out.println("Total expenses for this month: $" + monthlyTotal);
                    break;
                case 3:
                    double yearlyTotal = expenseManager.getTotalExpensesThisYear();
                    System.out.println("Total expenses for this year: $" + yearlyTotal);
                    break;
                case 4:
                    viewCustomMonth(expenseManager, scanner);
                    break;
                case 5:
                    viewCustomCategoryThisMonth(customExpenseViewer, scanner);
                    break;
                case 6:
                    viewCustomCategoryThisYear(customExpenseViewer, scanner);
                    break;
                case 7:
                    viewCustomCategoryCustomMonth(customExpenseViewer, scanner);
                    break;
                case 8:
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose 1, 2, 3, 4, 5, 6, 7, or 8.");
            }
        }
    }

    // Add methods to get user details, add a new expense, and view custom categories

    private static void addNewExpense(ExpenseManager expenseManager, Scanner scanner) {
        System.out.print("Enter expense category: ");
        String category = scanner.next();
        System.out.print("Enter expense amount: $");
        double amount = scanner.nextDouble();
        System.out.print("Enter expense date (yyyy-MM-dd): ");
        scanner.nextLine();  // Consume the newline
        String dateString = scanner.nextLine();
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            //xExpense expense = new Expense(category, amount, date);
            expenseManager.addExpense(category,amount,date);
            System.out.println("Expense added successfully.");
        } catch (Exception e) {
            System.err.println("Invalid date format. Expense not added.");
        }
    }

    private static void viewCustomMonth(ExpenseManager expenseManager, Scanner scanner) {
        System.out.print("Enter month (1-12) to view expenses: ");
        int customMonth = scanner.nextInt();
        double customMonthTotal = expenseManager.getTotalExpensesForMonth(customMonth - 1);
        System.out.println("Total expenses for the selected month: $" + customMonthTotal);
    }

    private static void viewCustomCategoryThisMonth(CustomExpenseViewer viewer, Scanner scanner) {
        System.out.print("Enter category (1-Food, 2-Travel, 3-Rent, 4-Utilities, 5-Entertainment): ");
        int categoryChoice = scanner.nextInt();
        String selectedCategory = getCategoryFromChoice(categoryChoice);

        double totalCategoryThisMonth = viewer.getTotalExpensesForCategoryThisMonth(selectedCategory);
        System.out.println("Total expenses for the selected category this month: $" + totalCategoryThisMonth);
    }

    private static void viewCustomCategoryThisYear(CustomExpenseViewer viewer, Scanner scanner) {
        System.out.print("Enter category (1-Food, 2-Travel, 3-Rent, 4-Utilities, 5-Entertainment): ");
        int categoryChoiceYear = scanner.nextInt();
        String selectedCategoryYear = getCategoryFromChoice(categoryChoiceYear);

        double totalCategoryThisYear = viewer.getTotalExpensesForCategoryThisYear(selectedCategoryYear);
        System.out.println("Total expenses for the selected category this year: $" + totalCategoryThisYear);
    }

    private static void viewCustomCategoryCustomMonth(CustomExpenseViewer viewer, Scanner scanner) {
        System.out.print("Enter category (1-Food, 2-Travel, 3-Rent, 4-Utilities, 5-Entertainment): ");
        int categoryChoiceCustom = scanner.nextInt();
        System.out.print("Enter custom month (1-12): ");
        int customMonthChoice = scanner.nextInt();
        String selectedCategoryCustom = getCategoryFromChoice(categoryChoiceCustom);

        double totalCategoryCustomMonth = viewer.getTotalExpensesForCategoryCustomMonth(selectedCategoryCustom, customMonthChoice);
        System.out.println("Total expenses for the selected category in the selected custom month: $" + totalCategoryCustomMonth);
    }

    private static String getCategoryFromChoice(int categoryChoice) {
        switch (categoryChoice) {
            case 1:
                return "Food";
            case 2:
                return "Travel";
            case 3:
                return "Rent";
            case 4:
                return "Utilities";
            case 5:
                return "Entertainment";
            default:
                return "";
        }
    }
}
