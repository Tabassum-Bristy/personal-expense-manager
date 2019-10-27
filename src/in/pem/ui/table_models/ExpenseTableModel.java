package in.pem.ui.table_models;

import in.pem.model.Expense;
import in.pem.util.DateUtil;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ExpenseTableModel extends AbstractTableModel {
    
    ArrayList<Expense> expenses;
    
    private String columNames[] = { "Expense ID", "Category", "Amount", "Data", "Remark" };
    
    private ArrayList< ArrayList<Object> > data;
    
    
    public ExpenseTableModel(ArrayList<Expense> expenses) {
        this.expenses = expenses;
        UpdateData();
        
    }
    
    private void UpdateData() {
        
        data = new ArrayList<>();
        
        for(int i=0; i<expenses.size(); i++) {
            
            // added a new row in the 2D table
            data.add(new ArrayList<>());
            
            
            Expense exp = expenses.get(i);
            
            ArrayList<Object> row = data.get(i);
            
            // add columns to this 2D table
            row.add(exp.getExpenseId());
            row.add(exp.getCategoryId());
            row.add(exp.getAmount());
            row.add( DateUtil.dateToString(exp.getDate()) );
            row.add( exp.getRemark() );
            
            
        }
        
    }
    
    
    @Override
    public String getColumnName(int index) {
        return columNames[index];
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return columNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return data.get(rowIndex).get(columnIndex);
    }
    
}
