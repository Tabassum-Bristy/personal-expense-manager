
package in.pem.model;

public class Report {
    private int month;
    private String category;
    private double amount;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Report() {
    }

    public Report(int month, String category, double amount) {
        this.month = month;
        this.category = category;
        this.amount = amount;
    }
    
    
}
