package com.example.administrator.pokemonlistapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import com.example.administrator.pokemonlistapp.R;
import com.example.administrator.pokemonlistapp.model.Pokemon;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Pokemon> pokemonList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<Pokemon> pokemon){
        this.context = context;
        this.pokemonList = pokemon;
    }
    public Context getContext(){
        return this.context;
    }
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(position);
        holder.pokemonName.setText(pokemon.getName());
        switch(pokemon.getType()){
            case "fire":{
                holder.pokemonType.setImageResource(R.drawable.fire);
                break;
            }
            case "water":{
                holder.pokemonType.setImageResource(R.drawable.water);
                break;
            }
            case "grass":{
                holder.pokemonType.setImageResource(R.drawable.grass);
                break;
            }
            default:{
                holder.pokemonType.setImageResource(R.drawable.other);

            }
        }

    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }
    public  class ViewHolder extends RecyclerView.ViewHolder {
        TextView pokemonName;
        ImageView pokemonType;
        ViewHolder(View view) {
            super(view);
            pokemonName = view.findViewById(R.id.pokemon_name);
            pokemonType = view.findViewById(R.id.pokemon_type);
        }

    }
}
