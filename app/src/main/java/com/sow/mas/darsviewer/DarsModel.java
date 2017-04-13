package com.sow.mas.darsviewer;

/**
 * Created by sow.m on 2017/04/13.
 */

public class DarsModel {
    private String title;
    private String date;
    private String fileName;

    public DarsModel(String title, String date, String fileName) {
        this.title = title;
        this.date = date;
        this.fileName = fileName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "DarsModel{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
