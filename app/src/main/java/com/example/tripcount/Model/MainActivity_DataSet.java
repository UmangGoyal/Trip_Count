package com.example.tripcount.Model;

public class MainActivity_DataSet {
    static String TripName;
    static int no_of_people;

    public MainActivity_DataSet() {
    }
    public MainActivity_DataSet(String tripName, int no_of_people) {
        TripName = tripName;
        MainActivity_DataSet.no_of_people = no_of_people;
    }

    public static String getTripName() {
        return TripName;
    }

    public static void setTripName(String tripName) {
        TripName = tripName;
    }

    public static int getNo_of_people() {
        return no_of_people;
    }

    public static void setNo_of_people(int no_of_people) {
        MainActivity_DataSet.no_of_people = no_of_people;
    }
}
