package com.example.tripcount.Model;

public class trip_transaction_dataset {
    String PaidBy;
    int amount;

    public trip_transaction_dataset() {
    }

    public trip_transaction_dataset(String paidBy, int amount) {
        PaidBy = paidBy;
        this.amount = amount;
    }

    public String getPaidBy() {
        return PaidBy;
    }

    public void setPaidBy(String paidBy) {
        PaidBy = paidBy;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
