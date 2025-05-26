package com.example.pas_genap_7_13;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeagueResponse {
    @SerializedName("leagues")
    private List<League> leagues;

    public List<League> getLeagues() {
        return leagues;
    }


}
