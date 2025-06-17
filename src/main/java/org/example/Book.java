package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;


import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.*;

public class Book {
    public void insertbook()
    {
        Scanner scan= new Scanner(System.in);
        String uri = "mongodb://localhost:27017/";
        try{
            MongoClient mongoClient= MongoClients.create(uri);
            MongoDatabase database=mongoClient.getDatabase("Library");
            MongoCollection<Document> booksCollection = database.getCollection("Books");

            System.out.println("Enter the Title of the book: ");
            String Title= scan.nextLine();

            System.out.println("Enter the Author of the book: ");
            String author= scan.nextLine();

            System.out.println("select the category of the book: ");
            System.out.println("1. Fiction");
            System.out.println("2. Non-Fiction");
            int ch= scan.nextInt();
            String ctgr=" ";

            if(ch==1)
                ctgr="Fiction";
            else if(ch==2)
                ctgr="Non-Fiction";
            else
                System.out.println("Enter a valid choice.");
            Document doc = new Document("Title",Title).append("Author",author).append("Category",ctgr);
            booksCollection.insertOne(doc);

            System.out.println("Inserted successfully");
        }
        catch (Exception e){
            System.out.println(e);
        }
//test comment 2

    }
    public void updatebook() {
        Scanner scan = new Scanner(System.in);
        String uri = "mongodb://localhost:27017/";
        try {
            MongoClient mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("Library");
            MongoCollection<Document> booksCollection = database.getCollection("Books");

//            String choice="";
            System.out.println("Enter the field to update:");
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

                    System.out.println("Enter the New Title of the Book:");
                    String ntitle= scan.nextLine();
                    Bson filter = Filters.eq("Title",title);
                    Bson update= Updates.set("Title",ntitle);
                    booksCollection.updateOne(filter, update);
                    break;
                case  2:
                    System.out.println("Enter the Title of the Book:");
                    String title2= scan.nextLine();

                    System.out.println("Enter the new Author name:");
                    String ntitle2= scan.nextLine();
                    Bson filter2 = Filters.eq("Title",title2);
                    Bson update2= Updates.set("Author",ntitle2);
                    booksCollection.updateOne(filter2, update2);
                    break;
                case 3:
                    System.out.println("Enter the Title of the Book:");
                    String title3= scan.nextLine();

                    System.out.println("Enter the new Category name:");
                    int ch1=scan.nextInt();
                    System.out.println("1. Fiction");
                    System.out.println("2. Non-Fiction");
                    String ntitle3= "";
                    if(ch1==1)
                        ntitle3="Fiction";
                    else if(ch1==2)
                        ntitle3="Non-Fiction";
                    else
                        System.out.println("Enter a valid option.");

                    Bson filter3 = Filters.eq("Title",title3);
                    Bson update3= Updates.set("Category",ntitle3);
                    booksCollection.updateOne(filter3, update3);
                    break;

            }


        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

}
