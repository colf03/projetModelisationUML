package main;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class Transaction {

    protected int id_numtel;
    protected String date_transaction;

    protected Transaction(int i) {
        this.id_numtel = i;
        this.date_transaction = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

    }

    protected Transaction() {
        this.date_transaction = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

    }

    protected Transaction(int i, String date) {
        this.id_numtel = i;
        this.date_transaction = date;

    }

    public int getId_numtel() {
        return id_numtel;
    }

    public String getDate_transaction() {
        return date_transaction;
    }

}
