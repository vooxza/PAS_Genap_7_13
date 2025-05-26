package com.example.pas_genap_7_13;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LeagueAdapter extends RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder> {
    private Context context;
    private List<League> leagueList;

    public LeagueAdapter(Context context, List<League> leagueList) {
        this.context = context;
        this.leagueList = leagueList;
    }

    @NonNull
    @Override
    public LeagueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_league, parent, false);
        return new LeagueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeagueViewHolder holder, int position) {
        League league = leagueList.get(position);
        holder.leagueName.setText(league.getStrLeague());
        holder.leagueSport.setText(league.getStrSport());
    }

    @Override
    public int getItemCount() {
        return (leagueList != null) ? leagueList.size() : 0;
    }

    public static class LeagueViewHolder extends RecyclerView.ViewHolder {
        TextView leagueName;
        TextView leagueSport;

        public LeagueViewHolder(View itemView) {
            super(itemView);
            leagueName = itemView.findViewById(R.id.leagueName);
            leagueSport = itemView.findViewById(R.id.leagueSport);
        }
    }
}