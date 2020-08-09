package edu.depaul.cdm.se452.concept;

import java.sql.Date;

public class Utility {

    public static String updatedValue(String updated, String original) {
        return (updated == null) ? original : updated;
    }

    public static Date updatedValue(Date updated, Date original) {
        return (updated == null) ? original : updated;
    }
}