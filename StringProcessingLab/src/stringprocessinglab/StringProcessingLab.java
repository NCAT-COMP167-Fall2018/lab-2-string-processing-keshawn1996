/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringprocessinglab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johnwashington
 */
public class StringProcessingLab {

    public static String[] records;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String filename = "records.txt";
        final int MAXRECORDS = 100;

        records = new String[MAXRECORDS];
        String output = null;
        readRecords(filename, output);
    }

    public static void readRecords(String filename, String ouput) {
        try {
            Scanner reader = new Scanner(new File(filename));
            int currentIndex = 0;
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] details = line.split(",");
                String first = details[0];
                String last = details[1];
                String gender = details[2];
                String age = details[3];
                String phone = details[4];
                String email = details[5];
                
                String output = String.format("%-10s%-10s%-10s%-10s%-10s%30s", first, last, gender, age, phone, email);
if (nameHasLetters(first, last) && genderIsValid(gender) && ageIsValid(age) && phoneNumberIsValid(phone) && emailIsValid(email)) {
                    records[currentIndex] = output;
                } else {
                    System.err.println(output);
                }
                currentIndex++;
            }

         for (String record : records) {
                System.out.println(record);
           }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StringProcessingLab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean nameHasLetters(String first, String last) {
        first = first.trim();
        last = last.trim();
        if (first.matches("[a-zA-Z]+")) {
            if (last.matches("[a-zA-Z]+")) {
                return true;
            }
        }
        return false;
    }

    public static boolean genderIsValid(String gender) {
        gender = gender.trim();
        return gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female");
    }

    public static boolean ageIsValid(String age) {
            age = age.trim();
            if(age.equals(""))
            {
                return false;
            }
            else 
            {
            int result = Integer.parseInt(age);
            return result > 1 && result <= 130;
           }
            
    } 
    
    public static boolean phoneNumberIsValid(String phone)
    {
        phone = phone.trim();
      if(phone.matches("(((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4})"))
      {
          return true;
      }
      else
      {
          return false;
      }
    }
    
    public static boolean emailIsValid(String email)
    {
        email = email.trim();
        if(email.matches("^(.+)@(.+)$"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
