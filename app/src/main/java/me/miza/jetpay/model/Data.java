package me.miza.jetpay.model;

import java.io.Serializable;
import java.util.ArrayList;

import me.miza.jetpay.R;

public class Data implements Serializable {
    private static final int DAILY = R.string.internet_daily;
    private static final int NIGHT = R.string.internet_night;
    private static final int WEEKLY = R.string.internet_weekly;
    private static final int MONTHLY = R.string.internet_monthly;
    private static final int WEEKEND = R.string.internet_weekend;


    public static ArrayList<Bundle> getDailyInternetPackage() {
        ArrayList<Bundle> packages = new ArrayList<>();
        packages.add(new Bundle(25,3,null,DAILY));
        packages.add(new Bundle(45,5,null,DAILY));
        packages.add(new Bundle(100,10,null,DAILY));
        packages.add(new Bundle(200,15,null,DAILY));
        packages.add(new Bundle(500,35,null,DAILY));
        return packages;
    }

    public static ArrayList<Bundle> getWeeklyInternetPackage() {
        ArrayList<Bundle> packages = new ArrayList<>();
        packages.add(new Bundle(500,50,null,WEEKLY));
        packages.add(new Bundle(700,60,null,WEEKLY));
        packages.add(new Bundle(1000,80,null,WEEKLY));
        return packages;
    }

    public static ArrayList<Bundle> getNightInternetPackage() {
        ArrayList<Bundle> packages = new ArrayList<>();
        packages.add(new Bundle(50,3,null,NIGHT));
        packages.add(new Bundle(100,5,null,NIGHT));
        packages.add(new Bundle(160,7,null,NIGHT));
        return packages;
    }
    public static ArrayList<Bundle> getWeekendPackage() {
        ArrayList<Bundle> packages = new ArrayList<>();
        packages.add(new Bundle(500,35,null,WEEKEND));
        packages.add(new Bundle(1000,60,null,WEEKEND));
        packages.add(new Bundle(2000,110,null,WEEKEND));
        return packages;
    }

    public static ArrayList<Bundle> getMonthlyInternetPackage() {
        ArrayList<Bundle> packages = new ArrayList<>();
        packages.add(new Bundle(1000,100,null,MONTHLY));
        packages.add(new Bundle(2000,190,null,MONTHLY));
        packages.add(new Bundle(4000,350,null,MONTHLY));
        packages.add(new Bundle(8000,600,null,MONTHLY));
        packages.add(new Bundle(10000,700,null,MONTHLY));
        packages.add(new Bundle(20000,1300,null,MONTHLY));
        packages.add(new Bundle(30000,1800,null,MONTHLY));
        packages.add(new Bundle(30000,4900,null,MONTHLY));
        return packages;
    }

}
