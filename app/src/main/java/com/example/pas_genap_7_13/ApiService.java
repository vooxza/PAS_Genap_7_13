package com.example.pas_genap_7_13;

import retrofit2.Call;
import retrofit2.http.GET;
public interface ApiService {
    @GET("all_leagues.php")
    Call<LeagueResponse> getLeagues();


    @GET("search_all_teams.php?l=Spanish%20La%20Liga")
    Call<TeamResponse> getLaLiga();
}
