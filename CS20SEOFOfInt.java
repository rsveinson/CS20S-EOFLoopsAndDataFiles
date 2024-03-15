import java.util.Scanner;
import javax.swing.*;
import java.io.*;
import java.text.NumberFormat;

/** ***************************************************
 *  Name:           sveinson
 *  Class:          CS20S
 * 
 *  Assignment:     Read a file of int values
 * 
 *************************************************************/

public class CS20SEOFOfInt {

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
        int n = 0;          // number from the file
        int count = 0;      // how many numbers are read
        
        int smallest = Integer.MAX_VALUE;
    //System.out.println(smallest);

        // ***** objects *****
        //Scanner scanner = new Scanner(System.in);
        //NumberFormat currency = NumberFormat.getCurrencyInstance();

        // file io buffers for reading and writing to text files

        BufferedReader fin = new BufferedReader(new FileReader("FileOfInts.txt"));
        //PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("outfle.txt")));

        // ***** print banners *****

        banner = "*****************************" + nl;
        banner += "Name:        Sveinson" + nl;
        banner += "Class:       CS20S" + nl;
        banner += "Assignment:  Read a file of int values" + nl;
        banner += "*****************************" + nl + nl;

        System.out.println(banner);
        //fout.print(banner);

        // ***** Get Input *****
        // ***** Main Processing *****

        // pre-loop processing
        count = 0;          // set counter to starting point

        // prime the control variable
        strin = fin.readLine();
        //System.out.println(strin);

        while(strin != null){
            //System.out.println(strin);

            // computation per iteration
            try{
                n = Integer.parseInt(strin);
            }// end try
            catch(NumberFormatException e){
                System.out.println("Error, incompatible data");
                System.out.println(strin + " can't be converted to int");
            }// end catch

            // find the smallest number in the file
            if(n < smallest)
            smallest = n;
            //System.out.println(n);

            // iteration computation
            count++;        // count numbers read from file

            // update control variabls            
            strin = fin.readLine();
        }// end of eof

        // ***** Print Formatted Output *****

        System.out.println("There are " + count + " ints in the file.");

        // ***** Closing Message *****

        System.out.println();
        System.out.println("end of processing");
        //fout.println("End of Processing");

        // **** close io buffers *****

        //fin.close();
        //fout.close();
    } // end main 

} // end FormatTemplate
