package com.company;

import java.io.File;  // Import the File class
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {


//        try {
//            File myObj = new File("File1.txt");
//            Scanner reader = new Scanner(myObj);              //scans myObj - which is a file, instead of System.in which is used in consoles
//
//            while(reader.hasNextLine()) {
//                String data = reader.nextLine();
//                System.out.println(data);
//            }
//            reader.close();
//
//        } catch (IOException e) {
//            System.out.println("an error occurred.");
//            e.printStackTrace();
//        }
//

        File myObj = new File("File.txt");
        if (myObj.createNewFile())
            System.out.println("File is successfully created.");
        else
            System.out.println("File already exist.");
            //Scanner reader = new Scanner("File.txt");
        FileWriter writer = new FileWriter("File.txt");
        writer.write("A file is created\nSecond Line\nThird Line\nFourth Line\n5th Line");
        writer.close();
        
        Scanner reader = new Scanner(myObj);
        while(reader.hasNextLine()) {
            String content = reader.nextLine();
            System.out.println(content);
        }


//        File myObj = new File("File.txt");
//        if(myObj.delete())
//            System.out.println("file is successfully deleted.");









    }
}