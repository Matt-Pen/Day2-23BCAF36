package Banking;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Updates;
import com.mongodb.internal.connection.Time;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Account {
    public void createaccount()
    {
        Scanner scan= new Scanner(System.in);
        String uri = "mongodb://localhost:27017/";
        try{
            MongoClient mongoClient= MongoClients.create(uri);
            MongoDatabase database=mongoClient.getDatabase("Banking");
            MongoCollection<Document> booksCollection = database.getCollection("Account");

            System.out.println("Enter account holder name: ");
            String name= scan.nextLine();

            System.out.println("Enter the Account number: ");
            String accno= scan.nextLine();

            System.out.println("Enter the deposit amount: ");
            double deposit= scan.nextInt();

//            System.out.println("select the category of the book: ");
//            System.out.println("1. Fiction");
//            System.out.println("2. Non-Fiction");
//            int ch= scan.nextInt();
//            String ctgr=" ";
//
//            if(ch==1)
//                ctgr="Fiction";
//            else if(ch==2)
//                ctgr="Non-Fiction";
//            else
//                System.out.println("Enter a valid choice.");
            Document doc = new Document("Name",name).append("Account num",accno).append("Balance",deposit);
            booksCollection.insertOne(doc);

            System.out.println("Account created successfully");
        }
        catch (Exception e){
            System.out.println(e);
        }
//test comment 2

    }

    public void deposit(){
        Scanner scan= new Scanner(System.in);
        String uri = "mongodb://localhost:27017/";
        try{

                MongoClient mongoClient= MongoClients.create(uri);
                MongoDatabase database=mongoClient.getDatabase("Banking");
                MongoCollection<Document> booksCollection = database.getCollection("Account");

                System.out.println("Enter your Account number: ");
                String accno= scan.nextLine();

                System.out.println("Enter the deposit amount: ");
                double deposit= scan.nextInt();
                double curbal=0,newbal=0;

                Bson filter = Filters.eq("Account num",accno);
                Bson projection = Projections.fields(Projections.include("Balance"));
                Document doc= booksCollection.find(filter).projection(projection).first();

                curbal=doc.getDouble("Balance");

                System.out.println("Current Balance: "+ curbal );
                curbal=curbal+deposit;

                Bson filter1 = Filters.eq("Account num",accno);
                Bson update= Updates.set("Balance",curbal);
                booksCollection.updateOne(filter, update);

                System.out.println("Successfully deposited.");
//                TimeUnit.SECONDS.sleep(3);

                Bson filter2 = Filters.eq("Account num",accno);
                Bson projection2 = Projections.fields(Projections.include("Balance"));
                Document doc2= booksCollection.find(filter).projection(projection2).first();
                newbal=doc2.getDouble("Balance");
                System.out.println("New Balance: "+ newbal );


        }
        catch (Exception e){
            System.out.println("Account doesn't exist.");
        }
    }
    public void withdrawal()
    {
        Scanner scan= new Scanner(System.in);
        String uri = "mongodb://localhost:27017/";
        try{

            MongoClient mongoClient= MongoClients.create(uri);
            MongoDatabase database=mongoClient.getDatabase("Banking");
            MongoCollection<Document> booksCollection = database.getCollection("Account");

            System.out.println("Enter your Account number: ");
            String accno= scan.nextLine();

            System.out.println("Enter the withdrawal amount: ");
            double deposit= scan.nextInt();
            double curbal=0,newbal=0;

            Bson filter = Filters.eq("Account num",accno);
            Bson projection = Projections.fields(Projections.include("Balance"));
            Document doc= booksCollection.find(filter).projection(projection).first();

            curbal=doc.getDouble("Balance");

            System.out.println("Current Balance: "+ curbal );
            curbal=curbal+deposit;

            Bson filter1 = Filters.eq("Account num",accno);
            Bson update= Updates.set("Balance",curbal);
            booksCollection.updateOne(filter, update);

            System.out.println("Successfully deposited.");
//                TimeUnit.SECONDS.sleep(3);

            Bson filter2 = Filters.eq("Account num",accno);
            Bson projection2 = Projections.fields(Projections.include("Balance"));
            Document doc2= booksCollection.find(filter).projection(projection2).first();
            newbal=doc2.getDouble("Balance");
            System.out.println("New Balance: "+ newbal );


        }
        catch (Exception e){
            System.out.println("Account doesn't exist.");
        }

    }
}
