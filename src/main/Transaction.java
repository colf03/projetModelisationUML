package main;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class Transaction {

    protected String numTel;
    protected String date_transaction;

    protected Transaction(String numTel) {
        this.numTel = numTel;
        this.date_transaction = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

    }

    protected Transaction() {
        this.date_transaction = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

    }

    protected Transaction(String numTel, String date) {
        this.numTel = numTel;
        this.date_transaction = date;

    }

    public String getClientNumTel() {
        return numTel;
    }

    public String getDate_transaction() {
        return date_transaction;
    }

}
