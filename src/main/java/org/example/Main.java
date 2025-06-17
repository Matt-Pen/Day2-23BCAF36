package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        String uri = "mongodb://localhost:27017/";
//        try{
//            MongoClient mongoClient= MongoClients.create(uri);
//            MongoDatabase database=mongoClient.getDatabase("Library");
//            MongoCollection<Document> booksCollection = database.getCollection("Books");
//        }
//        catch (Exception e){
//            System.out.println(e);
//        }
        Book bk= new Book();
//        bk.insertbook();
        bk.updatebook();

    }



}