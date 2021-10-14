package banking;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Account account = new Account();
    static Map<String, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        boolean exit = false;

        do
        {
            System.out.println("Simple Banking System");
            System.out.println("1. Create an account");
            System.out.println("2. Log into account");
            System.out.println("0. Exit");

            for (Account a : accounts.values())
                System.out.println(a);

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println();
                    createAccount();
                    break;
                }
                case 2: {
                    System.out.println();
                    enterAccount();
                    break;
                }
                case 3: {
                    System.out.println("Bye!");
                    exit = true;
                    break;
                }
            }

        } while (!exit);

    }

    private static void createAccount() {
        account = new Account();
        accounts.put(account.getCardNumber(), account);
    }

    private static void enterAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your card number:");
        String cardNumber = scanner.next();
        System.out.println("Enter your card PIN:");
        int pin = scanner.nextInt();

        Account foundAccount = accounts.get(cardNumber);

        if (foundAccount != null && foundAccount.getPin().equals(pin)) {
            System.out.println("You are logged in");
            account = foundAccount;

            boolean menu = false;
            do {
                System.out.println("1. Balance\n" + "2. Log out\n" + "3. Exit\n");
                int choice2 = scanner.nextInt();
                switch (choice2) {
                    case 1:
                        System.out.println("Balance " + account.getBalance() + "\n");
                      //  menu = false;
                        break;
                    case 2:
                        System.out.println("You have successfully logged out!\n");
                        menu = false;
                        break;
                    case 3:
                        System.out.println("Bye");
                        menu = true;
                        break;
                }
            } while (!menu);

        } else {
            System.out.println("Wrong card number or pin");
        }

    }

}

