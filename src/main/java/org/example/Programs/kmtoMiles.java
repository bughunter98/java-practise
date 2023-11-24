package org.example.Programs;

public class kmtoMiles {
    public static long toMilesPerHour(double kilometersPerHour){
        if (kilometersPerHour<0){
            return -1;
        }
        else {
            long miles;
            miles = (long)(kilometersPerHour*1.609);
            return Math.round(miles);
        }
    }
}
