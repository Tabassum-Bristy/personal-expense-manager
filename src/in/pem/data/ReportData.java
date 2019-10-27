package in.pem.data;

import in.pem.model.Report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ReportData {
    
    private Connection connection;
    private DBConnector connector;
    
    public ReportData() {
        connector = new DBConnector();
        connection = connector.getConnection();
    }
    
    public ArrayList<Report> getMonthlyReport(int month, int year) {
        ArrayList<Report>  reports = new ArrayList<>();
        connection = connector.getConnection();
        
        try {
            String query = "SELECT category.category_id, category.name, sum(expense.amount) as \"amount\", expense.date "
                    + "FROM category JOIN expense ON category.category_id = expense.category_id GROUP BY category.name "
                    + "HAVING MONTH(expense.date) = ? AND YEAR(expense.date) = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setInt(1, month);
            statement.setInt(2, year);
                        
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Report r = new Report();
                r.setMonth(month);
                r.setCategory(resultSet.getString("name"));
                r.setAmount(resultSet.getDouble("amount"));
                reports.add(r);
            }
            
            connection.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return reports;
    }    
    
    
    public ArrayList<Report> getYearlyReport(int year) {
        ArrayList<Report>  reports = new ArrayList<>();
        connection = connector.getConnection();
        
        try {
            String query = "SELECT category.category_id, category.name, sum(expense.amount) as \"amount\", "
                    + "MONTH(expense.date) as \"month\", expense.date "
                    + "FROM category JOIN expense ON category.category_id = expense.category_id "
                    + "GROUP BY MONTH(expense.date), category.name "
                    + "HAVING YEAR(expense.date) = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setInt(1, year);
                        
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Report r = new Report();
                r.setMonth(resultSet.getInt("month"));
                r.setCategory(resultSet.getString("name"));
                r.setAmount(resultSet.getDouble("amount"));
                reports.add(r);
            }
            
            connection.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return reports;
    }  
    
}
