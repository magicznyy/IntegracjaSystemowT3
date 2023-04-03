import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Exporter {

    public void exportDataFromJTable(JTable jt, JFrame f ){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("outputData.txt"));
            PrintWriter fileWriter = new PrintWriter(bufferedWriter);

            for(int i = 0; i < jt.getColumnCount(); i++)
            {
                String headers = String.valueOf(jt.getColumnName(i));
                fileWriter.print(headers);
                fileWriter.print("\t");
            }
            fileWriter.println("");

            Boolean flag = false;
            for(int i=0; i<jt.getRowCount(); ++i)
            {
                if(flag==true)
                    break;
                for(int j=0; j<jt.getColumnCount(); ++j)
                {
                    String s = null;

                    if(!(jt.getValueAt(i,j)==null)){
                    s = jt.getValueAt(i,j).toString();
//                    if(j==9)
//                        if(s!="HDD")
//                        if(s!="SSD")
//                        {
//                            JOptionPane.showMessageDialog(f, "Niepoprawny format danych, ma być SSD lub HDD w 10 kolumnie!");
//                            flag=true;
//                            break;
//                        }

                    if(j==6 || j==7)
                        if(!(isNumeric(s))) {
                            JOptionPane.showMessageDialog(f, "Niepoprawny typ danych!");
                            flag=true;
                            break;
                        }}
                    else {
                        s="brak";
                        JOptionPane.showMessageDialog(f, "Wartości w komórkach nie mogą być puste!");
                      flag=true;
                        break;
                    }
                    fileWriter.print(s);
                    fileWriter.print("\t\t");
                }
                fileWriter.println("");
            }
            fileWriter.close();
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("XD");
        }

    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
