package in.pem.data;

import in.pem.model.Expense;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class ExpenseData {
    private Connection connection;
    private DBConnector connector;

    public ExpenseData() {
        connector = new DBConnector();
    }
    
    public ArrayList<Expense> getAllExpenses() {
        ArrayList<Expense> expenses = new ArrayList<>();
        
        connection = connector.getConnection();
        
        try {
            String query = "SELECT * FROM expense";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Expense exp = new Expense();
                exp.setExpenseId(resultSet.getLong("id") );
                exp.setCategoryId( resultSet.getLong("category_id"));
                exp.setAmount(resultSet.getFloat("amount"));
                exp.setDate(resultSet.getDate("date"));
                exp.setRemark(resultSet.getString("remark"));
                
                expenses.add(exp);
            }
            
            connection.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return expenses;
    }
    
     public ArrayList<Expense> getAllExpensesByDate(Date date) {
        ArrayList<Expense> expenses = new ArrayList<>();
        
        connection = connector.getConnection();
        
        try {
            String query = "SELECT * FROM expense WHERE date = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDate(1, new java.sql.Date( date.getTime() ));
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Expense exp = new Expense();
                exp.setExpenseId(resultSet.getLong("id") );
                exp.setCategoryId( resultSet.getLong("category_id"));
                exp.setAmount(resultSet.getFloat("amount"));
                exp.setDate(resultSet.getDate("date"));
                exp.setRemark(resultSet.getString("remark"));
                
                expenses.add(exp);
            }
            
            connection.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return expenses;
    }
    
    public Expense getExpenseById(int id) {
        Expense exp = null;
        
        connection = connector.getConnection();
        
        try {
            String query = "SELECT * FROM expense WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                exp = new Expense();
                exp.setExpenseId(resultSet.getLong("id") );
                exp.setCategoryId( resultSet.getLong("category_id"));
                exp.setAmount(resultSet.getFloat("amount"));
                exp.setDate(resultSet.getDate("date"));
                exp.setRemark(resultSet.getString("remark"));
                
            }
            
            connection.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return exp;
    }
    
    
    public boolean addExpense(Expense exp)
    {
        connection = connector.getConnection();
        
        try {
            String query = "INSERT INTO expense(category_id, amount, date, remark) VALUES( ?, ?, ? , ? )";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, exp.getCategoryId());
            statement.setFloat(2, exp.getAmount());
            statement.setDate(3, new java.sql.Date( exp.getDate().getTime() ));
            statement.setString(4, exp.getRemark());
            
            statement.execute();
            
            connection.close();
            return true;
            
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    
    
    public boolean removeExpenseById(int id) {
        connection = connector.getConnection();
        
        String query = "DELETE FROM expense WHERE id = ?";
        
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            statement.execute();
            connection.close();
            return true;
        }
        catch(Exception ex) { ex.printStackTrace();
        
        }
        return false;
    }
    
    public boolean removeExpenseByCategoryId(int id) {
        connection = connector.getConnection();
        
        String query = "DELETE FROM expense WHERE category_id = ?";
        
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            statement.execute();
            connection.close();
            return true;
        }
        catch(Exception ex) { ex.printStackTrace();
        
        }
        return false;
    }
    
}
