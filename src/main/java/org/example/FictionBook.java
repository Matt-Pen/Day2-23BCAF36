package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Scanner;

public class FictionBook {
    Scanner scan= new Scanner(System.in);
    String uri = "mongodb://localhost:27017/";
    public void findfiction(){
        try{
            MongoClient mongoClient= MongoClients.create(uri);
            MongoDatabase database=mongoClient.getDatabase("Library");
            MongoCollection<Document> booksCollection = database.getCollection("Books");


        }
        catch (Exception e){
            System.out.println(e);
        }
    }











}
