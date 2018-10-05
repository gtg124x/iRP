package team1.gatech.edu.irp.model;

import java.util.ArrayList;

public class AccountDataBase {

    //public static Account[] accountArray = new Account[20];
    public static ArrayList<Account> accountArray = new ArrayList<>();
    public static int count = 0;
    //public static boolean AddedToAccount = false;

    public static void addToAccountDatabase(Account newAccount) {
        accountArray.add(newAccount);
        //if (count < 20) {
            //accountArray[count] = newAccount;
            //count++;
            //AddedToAccount = true;
        //} else {
          //  AddedToAccount = false;
        //}
    }
}
