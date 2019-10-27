
package in.pem.ui.table_models;

import in.pem.model.Report;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ReportTableModel extends AbstractTableModel {
    
     ArrayList<Report> reports;
     
    private String months[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
        "October", "November", "December"
    };
    
    private String columNames[] = { "Month", "Category", "Amount"};
    
    private ArrayList< ArrayList<Object> > data;
    
    
    public ReportTableModel(ArrayList<Report> reports) {
        this.reports = reports;
        UpdateData();
        
    }
    
    private void UpdateData() {
        
        data = new ArrayList<>();
        
        for(int i=0; i<reports.size(); i++) {
            
            // added a new row in the 2D table
            data.add(new ArrayList<>());
            
            
            Report rep = reports.get(i);
            
            ArrayList<Object> row = data.get(i);
            
            // add columns to this 2D table
            row.add( months[ rep.getMonth() - 1 ] );
            row.add( rep.getCategory() );
            row.add( rep.getAmount() );
            
            
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
