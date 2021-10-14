package banking;

import java.util.Random;
import java.util.Scanner;

public class Account {
    Scanner scanner = new Scanner(System.in);
    String cardNumber;
    String pin;
    int balance;
    static Random random = new Random();

    public Account() {
        cardNumber =  "400000" + createNewRandom() + "4";
        int pinInt = random.nextInt(9999 - 1000) + 1000;
        pin =  String.format("%04d", pinInt);

    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getBalance() {
        balance = 0;
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    static String createNewRandom() {
        int newRandom = random.nextInt(999999999);
        return String.format("%09d", newRandom);
    }

    public String toString() {
        return "Account{" +
                "cardNumber='" + cardNumber + '\'' +
                ", pin='" + pin + '\'' +
                ", balance=" + balance +
                '}';
    }
}