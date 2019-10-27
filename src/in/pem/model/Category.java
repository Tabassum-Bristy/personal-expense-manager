
package in.pem.model;

/**
 *
 * @author USER
 */
public class Category {
    //temporary id generation
    private  Long categoryId;
     private String name;

    public Category(String name) {
        this.name=name;
    }

    public Category(Long categoryId,String name) {
        this.categoryId=categoryId;
        this.name=name;
    }

    public Category() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
     
    
}
