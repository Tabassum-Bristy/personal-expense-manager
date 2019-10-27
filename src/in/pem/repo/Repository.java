package in.pem.repo;

import in.pem.model.Expense;
import in.pem.model.Category;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class Repository {

    public List<Expense> explist=new ArrayList();
    public List<Category> catList=new ArrayList();
    private static Repository repository;

    private Repository() {
    }

    public static Repository getRepository() {
        if (repository == null) {
            repository = new Repository();
        }

        return repository;
    }

}
