import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExpenseManager {
    private ExpenseDatabase database;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public ExpenseManager(ExpenseDatabase database) {
        this.database = database;
    }

    public void addExpense(String category, double amount, Date date) {
        Expense expense = new Expense(category, amount, date);
        database.addExpense(expense);
    }

    public double getTotalExpensesThisMonth() {
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

            if (currentMonth == expenseMonth && currentYear == expenseYear) {
                total += expense.getAmount();
            }
        }
        return total;
    }

    public double getTotalExpensesThisYear() {
        double total = 0;
        Date currentDate = new Date();
        for (Expense expense : database.getExpenses()) {
            if (dateFormat.format(expense.getDate()).substring(0, 4).equals(dateFormat.format(currentDate).substring(0, 4))) {
                total += expense.getAmount();
            }
        }
        return total;
    }
    public double getTotalExpensesForMonth(int month) {
        double total = 0;
        Calendar calendar = Calendar.getInstance();
        for (Expense expense : database.getExpenses()) {
            calendar.setTime(expense.getDate());
            int expenseMonth = calendar.get(Calendar.MONTH);
            int expenseYear = calendar.get(Calendar.YEAR);

            if (month == expenseMonth) {
                total += expense.getAmount();
            }
        }
        return total;
    }

}

