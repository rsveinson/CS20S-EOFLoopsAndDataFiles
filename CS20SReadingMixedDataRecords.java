import java.util.Scanner;
import javax.swing.*;
import java.io.*;
import java.text.NumberFormat;

/** ***************************************************
 *  Name:           Sveinson
 *  Class:          CS20S
 * 
 *  Assignment:     Reading Mixed Data Records
 * 
 *************************************************************/

public class CS20SReadingMixedDataRecords {

    public static void main(String[] args) throws IOException{
        // ***** constants *******
        // a new line character that works on every computer system
        final String nl = System.lineSeparator();
        
        // ***** variables *****

        String banner = "";             // output banner
        String prompt = "";             // prompt for user input

        String strin = "";              // string fro keyboard input
        String strout = "";             // string for formatted output

        String delim = "[ ]+";          // delimiter for splitting input records
        String[] tokens = null;         // used to split input records

        // local variables
        String firstName = "";
        String lastName = "";
        int salary = 0;         // yearly salary
        double bonus = 0.0;     // bonus pay
        
        // ***** objects *****
        //Scanner scanner = new Scanner(System.in);
        //NumberFormat currency = NumberFormat.getCurrencyInstance();
        
        // file io buffers for reading and writing to text files
        
        BufferedReader fin = new BufferedReader(new FileReader("empData.txt"));
        //PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("outfle.txt")));

        // ***** print banners *****

        banner = "*****************************" + nl;
        banner += "Name:        Sveinson" + nl;
        banner += "Class:       CS20S" + nl;
        banner += "Assignment:  Reading Mixed Data Records" + nl;
        banner += "*****************************" + nl + nl;

        System.out.println(banner);
        //fout.print(banner);

        // ***** Get Input *****
        // ***** Main Processing *****
        
        // pre-loop processing here
        
        // prime the loop
        strin = fin.readLine();
        //System.out.println(strin);
        
        while(strin != null){
            //System.out.println(strin);
            
            // parse input record
            tokens = strin.split(delim);
            //System.out.println(tokens.length);
            
            try{
                firstName = tokens[0];
                lastName = tokens[1];
                salary = Integer.parseInt(tokens[2]);
                bonus = Double.parseDouble(tokens[3]);
            }// end try
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, banner + "Incompatible data type.");
            }// end catch number format exception
            catch(ArrayIndexOutOfBoundsException e){
                JOptionPane.showMessageDialog(null, banner + "Incomplete input.");
            }// end index out of bounds
            
            // calculations
            
            // formatted output
            System.out.format("%-15s %-15s", firstName, lastName);
            System.out.format("%8d %10.2f%s", salary, bonus, nl);
            
            // update control
            strin = fin.readLine();
        }// end eof
        
        // post loop pocessing
        

        // ***** Print Formatted Output *****

        // ***** Closing Message *****

        System.out.println();
        System.out.println("end of processing");
        //fout.println("End of Processing");
        
         // **** close io buffers *****
    
        //fin.close();
        //fout.close();
    } // end main 

} // end FormatTemplate
