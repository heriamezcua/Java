/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.regex.Pattern;

/**
 *
 * @author amezc
 */
public class Account {

    private String id, name;
    private int balance;

    public Account(String id, String name, int balance) {
        if (!Pattern.matches("[ A-Za-záéíóúÁÉÍÓÚñÑ]{4,}", name)) {
            throw new IllegalArgumentException("The name entered is not valid.");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("The balance entered is not valid.");
        }

        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(String id, String name) {
        this(id, name, 0);
    }

    public Account() {
        this("111111111", "aaaaaaaaa", 0);
    }

    public String getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getBalance() {
        return this.balance;
    }

    /**
     * Add amount to balance, return final balance.
     *
     * @param amount the amount to add to the balance
     * @return the final balance
     */
    public int credit(int amount) {
        if (amount > 0) {
            this.balance += amount;
        }

        return this.balance;
    }

    /**
     * Subtract amount to balance, return final balance.
     *
     * @param amount the amount to add to the balance
     * @return the final balance
     */
    public int debit(int amount) {
        if (amount > 0) {
            if (amount <= balance) {
                this.balance -= amount;
            } else {
                System.out.println("Amount exceeded balance");
            }
        }

        return this.balance;
    }

    /**
     * Transfer amount from one account to another.
     *
     * @param another the account that will receive the amount
     * @param amount the amount to be transferred from one account to another
     * @return the final balance of the account that transfer
     */
    public int transferTo(Account another, int amount) {
        if (amount > 0) {
            if (amount <= balance) {
                this.balance -= amount;
                another.balance += amount;
            } else {
                System.out.println("Amount exceeded balance");
            }
        }

        return this.balance;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", name=" + name + ", balance=" + balance + "]";
    }

}

/*
        Account a1 = new Account("A101", "Tan Ah Teck", 88);
        System.out.println(a1);  // toString();
        Account a2 = new Account("A102", "Kumar"); // default balance
        System.out.println(a2);

        // Test Getters
        System.out.println("ID: " + a1.getID());
        System.out.println("Name: " + a1.getName());
        System.out.println("Balance: " + a1.getBalance());

        // Test credit() and debit()
        a1.credit(100);
        System.out.println(a1);
        a1.debit(50);
        System.out.println(a1);
        a1.debit(500);  // debit() error
        System.out.println(a1);

        // Test transfer()
        a1.transferTo(a2, 100);  // toString()
        System.out.println(a1);
        System.out.println(a2);
*/
