package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        Book bk= new Book();
        FictionBook fbk=new FictionBook();
        while(true){
            System.out.println("Enter your choice:");
            System.out.println("1. Insert a new book.");
            System.out.println("2. Find an existing book.");
            System.out.println("3. Update book details.");
            System.out.println("4. Delete book details.");
            int ch;
            ch=scan.nextInt();
            switch(ch){
                case 1:
                    bk.insertbook();
                    break;
                case 2:
                    fbk.findbook();
                    break;
                case 3:
                    bk.updatebook();
                    break;
                case 4:
                    fbk.deletebook();
                    break;


            }
        }
//

    }



}