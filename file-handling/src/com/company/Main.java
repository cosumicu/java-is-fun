package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        // file creation
//        File myFile = new File("File.txt");
//        if(myFile.createNewFile())
//            System.out.println("file successfully created.");
//        else
//            System.out.println("file already exist");
//
//        // file writing
//        FileWriter writer = new FileWriter("File.txt");
//        writer.write("File created\n1st line\n2nd line\n3rd line\n4th line\n5th line");
//        writer.close();
//
//        // file reading
//        String content = "";
//        Scanner reader = new Scanner(myFile);
//        while(reader.hasNextLine()) {
//            content = reader.nextLine();
//            System.out.println(content);
//        }

        FileInputStream fileIn = new FileInputStream("C:\\Users\\User\\IdeaProjects\\Refresher 1\\file.txt");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Save importedSave0 = (Save)in.readObject();
        fileIn.close();
        in.close();

        System.out.println(importedSave0.x);
        System.out.println(importedSave0.y);
        System.out.println(importedSave0.state);


    }
}
