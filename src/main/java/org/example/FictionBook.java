package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Scanner;

public class FictionBook {
    Scanner scan= new Scanner(System.in);
    String uri = "mongodb://localhost:27017/";
    public void findbook(){
        try{
            MongoClient mongoClient= MongoClients.create(uri);
            MongoDatabase database=mongoClient.getDatabase("Library");
            MongoCollection<Document> booksCollection = database.getCollection("Books");

            System.out.println("Enter the search criteria: ");
            System.out.println("1. Title:");
            System.out.println("2. Author:");
            System.out.println("3. Category:");
            int ch;
            ch=scan.nextInt();
            scan.nextLine();

            switch(ch){
                case 1:
                    System.out.println("Enter the Title of the Book:");
                    String title= scan.nextLine();

                    Bson filter= Filters.eq("Title",title);
                    booksCollection.find(filter).forEach(doc -> System.out.println(doc.toJson()));

                case  2:

                case 3:


            }

        }
        catch (Exception e){
            System.out.println(e);
        }
    }











}
