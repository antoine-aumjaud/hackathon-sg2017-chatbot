package com.tesobe.obp.botclient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DataUserMock {

    public double cc_amount             = 346.83;
    public double epargne_amount        = 151;
    public double credit_amount         = -149696.12;
    
    public double cc_last_pay           = 2200.15;
    public double cc_last_invoice_edf   = 123.10;
    public double cc_last_invoice_engie = 542;
    
    public double cc_seuil              = 100;

    public double pay_amount            = 2205;

    public List<FakeTransaction> transactions = new ArrayList<>();
    {
        transactions.add(new FakeTransaction("01/07", "Lidl Supermarché", 33));
        transactions.add(new FakeTransaction("05/07", "LDLC - casque gamer", 145));
        transactions.add(new FakeTransaction("06/07", "Lidl Supermarché", 63));
    }
    public void addTransaction(String date, String label, double amount) {
        cc_amount += amount;
        transactions.add(new FakeTransaction(date, label, amount));
    }
    
    public static class FakeTransaction {
        public String date;
        public String label;
        public double amount;
        public FakeTransaction (String date, String label, double amount) {
            this.date = date;
            this.label = label;
            this.amount = amount;
        }
    }
}