package Banking;

import com.mongodb.client.MongoDatabase;
import org.example.Book;
import org.example.FictionBook;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scan= new Scanner(System.in);
        Account acnt= new Account();

        while(true){
            System.out.println("Enter your choice:");
            System.out.println("1. Create a New Account.");
            System.out.println("2. Deposit into your account.");
            System.out.println("3. Withdraw from your account.");
            System.out.println("4. Check your account balance.");
            System.out.println("5. Transfer.");
            int ch;
            ch=scan.nextInt();
            switch(ch){
                case 1:
                    acnt.createaccount();
                    break;
                case 2:
                    acnt.deposit();
                    break;
                case 3:
                    acnt.withdrawal();
                    break;
                case 4:
                    acnt.checkbal();
                    break;
                case 5:
                    acnt.Transfer();
                    break;


            }
        }
//

    }

}
