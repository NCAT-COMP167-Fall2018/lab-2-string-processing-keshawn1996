/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringprocessinglab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johnwashington
 */
public class StringProcessingLab {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    String first = null;
    String last = null;
    String gender = null;
    int age = 0;
    String phone = null;
    String email = null;
        // TODO code application logic here
        String filename = "records.txt";
        final int MAXRECORDS = 100;
        String [] records;
        records = new String[MAXRECORDS];
        String output = null;
        readRecords(filename, output);   
    }
    
    public static void readRecords(String filename, String ouput) {
        try 
        {
            List<String> record = new ArrayList<>();
            Scanner reader = new Scanner(new File(filename));
            while(reader.hasNextLine())
            {
                    String line = reader.nextLine();
                    String[] details = line.split(",");
                    String first = details[0];
                    String last = details[1];
                    String gender = details[2];
                    String age = details[3];
                    String phone = details[4];
                    String email = details[5];
                String output = String.format("%-10s%-10s%-10s%-10s%-10s%30s", first, last, gender, age, phone, email);
                System.out.println(output);
                }
    }   catch (FileNotFoundException ex) {
            Logger.getLogger(StringProcessingLab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
