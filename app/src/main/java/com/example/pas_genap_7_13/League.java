package com.example.pas_genap_7_13;

import com.google.gson.annotations.SerializedName;

public class League {
    @SerializedName("strLeague")
    private String strLeague;

    @SerializedName("strSport")
    private String strSport;

    public String getStrLeague() { return strLeague; }
    public String getStrSport() { return strSport; }

}
