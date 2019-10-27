package in.pem.data;

import in.pem.model.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;

public class CategoryData {

    private Connection connection;
    private DBConnector connector;

    public CategoryData() {
        connector = new DBConnector();
    }

    public ArrayList<Category> getAllCategories() {

        ArrayList<Category> categories = new ArrayList<>();

        String query = "SELECT * FROM category";

        connection = connector.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                Category cat = new Category();
                cat.setCategoryId(resultSet.getLong("category_id"));
                cat.setName(resultSet.getString("name"));

                categories.add(cat);

            }
            
            connection.close();

        } catch (Exception ex) {
            ex.printStackTrace();;
        }

        return categories;
    }
    
    public Category getCategory(int id) {
        Category cat = null;
        String query = "SELECT * FROM category WHERE category_id = ?";

        connection = connector.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                cat = new Category();
                cat.setCategoryId(resultSet.getLong("category_id"));
                cat.setName(resultSet.getString("name"));

            }
            
            connection.close();

        } catch (Exception ex) {
            ex.printStackTrace();;
        }

        return cat;
    }
    
    public boolean addCategory(Category cat) {
        connection = connector.getConnection();

        String query = "Insert INTO Category(name) VALUES (?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, cat.getName());
            statement.execute();
            
            connection.close();
            
            return true;
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return false;

    }
    
    public boolean removeCategory(Category cat) {
        
        connection = connector.getConnection();
        
        String query = "DELETE FROM Category WHERE category_id = ?";
        
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, cat.getCategoryId());
            statement.execute();
            connection.close();
            return true;
        }
        catch(Exception ex) { ex.printStackTrace();
        
        }
        return false;
        
        
    }
    

}
