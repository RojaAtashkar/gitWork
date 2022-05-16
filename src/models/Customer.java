package models;

public class Customer extends User{
    private int balance;
    public Customer(String username, String password){
        super(username, password);
        balance = 0;
    }

    public int getBalance() {

        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    @Override
    public String toString()
    {
        return this.getUsername();
    }
}