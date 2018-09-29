package team1.gatech.edu.irp.model;

public class AccountDataBase {

    public static Account[] accountArray = new Account[10];
    public static int count = 0;

    public static void addToAccountDatabase(Account newAccount) {
        if (count < 10) {
            accountArray[count] = newAccount;
            count++;
        }
    }
}
