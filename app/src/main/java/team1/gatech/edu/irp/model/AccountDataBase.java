package team1.gatech.edu.irp.model;

import java.util.ArrayList;

public class AccountDataBase {

    public static ArrayList<Account> accountArray = new ArrayList<>();

    public static void addToAccountDatabase(Account newAccount) {
        accountArray.add(newAccount);
    }
}
