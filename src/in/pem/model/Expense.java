package in.pem.model;

import java.util.Date;

/**
 *
 * @author USER
 */
public class Expense {

    private Long expenseId;

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }

    public Expense(Long expenseId, Long categoryId, Float amount, Date date, String remark) {
        this.expenseId = expenseId;
        this.categoryId = categoryId;
        this.amount = amount;
        this.date = date;
        this.remark = remark;
    }

    public Long getExpenseId() {
        return expenseId;
    }
    private Long categoryId; //foreign key
    private Float amount;
    private Date date;
    private String remark;

    public Expense() {
    }

    public Expense(Long categoryId, Float amount, Date date, String remark) {
        this.categoryId = categoryId;
        this.amount = amount;
        this.date = date;
        this.remark = remark;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
