package in.pem.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class DateUtil {
    public static final String[] MONTHS={"January","February","March","April","May","June","July","August","September","October","November","Desember"};

    public static Date getDate(String dateAsString) {

        try {
            SimpleDateFormat df = new SimpleDateFormat();
            return df.parse(dateAsString);
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }

    }
    
     public static Date stringToDate(String dateAsString) {

        try {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
             return df.parse(dateAsString);
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }

    }
 public static String  dateToString(Date date) {

            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            return df.format(date);
        

    }
 public static  String getYearandMonth(Date date) {

            SimpleDateFormat df = new SimpleDateFormat("yyyy,MM");
            return df.format(date);
        

    }
 public static String getMonthName(Integer monthNo){
     return MONTHS[monthNo-1];
 }
}
