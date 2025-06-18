package Library;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
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
                    break;

                case  2:
                    System.out.println("Enter the Author of the Book:");
                    String title2= scan.nextLine();

                    Bson filter2= Filters.eq("Author",title2);
                    booksCollection.find(filter2).forEach(doc -> System.out.println(doc.toJson()));
                    break;

                case 3:

                    System.out.println("select the category of the book: ");
                    System.out.println("1. Fiction");
                    System.out.println("2. Non-Fiction");
                    int ch1= scan.nextInt();
                    String ctgr=" ";

                    if(ch1==1)
                        ctgr="Fiction";
                    else if(ch1==2)
                        ctgr="Non-Fiction";
                    else
                        System.out.println("Enter a valid choice.");

                    Bson filter3= Filters.eq("Category",ctgr);
                    booksCollection.find(filter3).forEach(doc -> System.out.println(doc.toJson()));
                    break;
            }

        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deletebook(){
        Scanner scan= new Scanner(System.in);
        String uri = "mongodb://localhost:27017/";
        try{
            MongoClient mongoClient= MongoClients.create(uri);
            MongoDatabase database=mongoClient.getDatabase("Library");
            MongoCollection<Document> booksCollection = database.getCollection("Books");


            System.out.println("Enter the Title of the Document to be deleted: ");
            String ch="";

            ch=scan.nextLine();
            Bson filter = Filters.eq("Title", ch);
            booksCollection.deleteOne(filter);
            System.out.println("Deleted Successfully");
        }
        catch (Exception e){
            System.out.println(e);
        }

    }


}
