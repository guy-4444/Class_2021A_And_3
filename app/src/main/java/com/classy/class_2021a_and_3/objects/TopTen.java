package com.classy.class_2021a_and_3.objects;

import java.util.ArrayList;

public class TopTen {

    private ArrayList<Record> records = new ArrayList<>();

    public TopTen() { }

    public TopTen(ArrayList<Record> records) {
        this.records = records;
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    public TopTen setRecords(ArrayList<Record> records) {
        this.records = records;
        return this;
    }
}
