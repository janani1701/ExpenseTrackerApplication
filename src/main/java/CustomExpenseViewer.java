import java.util.Calendar;
import java.util.Date;

public class CustomExpenseViewer {
    private ExpenseDatabase database;

    public CustomExpenseViewer(ExpenseDatabase database) {
        this.database = database;
    }

    public double getTotalExpensesForCategoryThisMonth(String category) {
        double total = 0;
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentYear = calendar.get(Calendar.YEAR);

        for (Expense expense : database.getExpenses()) {
            calendar.setTime(expense.getDate());
            int expenseMonth = calendar.get(Calendar.MONTH);
            int expenseYear = calendar.get(Calendar.YEAR);

            if (category.equalsIgnoreCase(expense.getCategory()) && currentMonth == expenseMonth && currentYear == expenseYear) {
                total += expense.getAmount();
            }
        }
        return total;
    }

    public double getTotalExpensesForCategoryThisYear(String category) {
        double total = 0;
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);

        for (Expense expense : database.getExpenses()) {
            calendar.setTime(expense.getDate());
            int expenseYear = calendar.get(Calendar.YEAR);

            if (category.equalsIgnoreCase(expense.getCategory()) && currentYear == expenseYear) {
                total += expense.getAmount();
            }
        }
        return total;
    }

    public double getTotalExpensesForCategoryCustomMonth(String category, int customMonth) {
        double total = 0;
        Calendar calendar = Calendar.getInstance();

        for (Expense expense : database.getExpenses()) {
            calendar.setTime(expense.getDate());
            int expenseMonth = calendar.get(Calendar.MONTH);

            if (category.equalsIgnoreCase(expense.getCategory()) && customMonth - 1 == expenseMonth) {
                total += expense.getAmount();
            }
        }
        return total;
    }
}
