package com.example.pas_genap_7_13;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardFragment extends Fragment {

    private RecyclerView recyclerView;
    private LeagueAdapter adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        loadLeagues();

        return view;
    }

    private void loadLeagues() {
        RetrofitClient.getRetrofitInstance()
                .create(ApiService.class)
                .getLeagues()
                .enqueue(new Callback<LeagueResponse>() {
                    @Override
                    public void onResponse(Call<LeagueResponse> call, Response<LeagueResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            List<League> leagues = response.body().getLeagues();

                            if (leagues != null && !leagues.isEmpty()) {
                                for (League league : leagues) {
                                    System.out.println("League: " + league.getStrLeague());
                                }

                                adapter = new LeagueAdapter(requireContext(), leagues);
                                recyclerView.setAdapter(adapter);
                            } else {
                                Toast.makeText(getContext(), "Leagues list is empty!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getContext(), "Response error: " + response.code(), Toast.LENGTH_SHORT).show();
                            System.out.println("Error response body: " + response.errorBody());
                        }
                    }

                    @Override
                    public void onFailure(Call<LeagueResponse> call, Throwable t) {
                        Toast.makeText(getContext(), "Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
