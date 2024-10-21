package ModelTransaksi;

public class Transaction {

    private String date;
    private int amount;
    private String description;
    private boolean isExpense;

    public Transaction(String date, int amount, String description, boolean isExpense) {
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.isExpense = isExpense;
    }

    public String getDate() { return date; }
    public int getAmount() { return amount; }
    public String getDescription() { return description; }
    public boolean isExpense() { return isExpense; }
}
