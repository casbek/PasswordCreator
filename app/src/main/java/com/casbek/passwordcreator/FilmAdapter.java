package com.casbek.passwordcreator;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.CardViewTasarimNesneleriniTutucu> {
    private Context mContext;
    private List<Filimler> filmList;




    public FilmAdapter(Context mContext, List<Filimler> filmList) {
        this.mContext = mContext;
        this.filmList = filmList;
    }

    @NonNull
    @Override
    public CardViewTasarimNesneleriniTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemViev= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_film_tasaim,parent,false);
        return new CardViewTasarimNesneleriniTutucu(itemViev);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimNesneleriniTutucu holder, final int position) {
     final Filimler film=filmList.get(position);

    holder.textViewepostas.setText(film.getEposta());
     holder.textViewSifrees.setText(film.getSifre());
     holder.textViewasdd.setText("Eposta :");
     holder.textView2asdd.setText("Sifre :");









    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }



    public class CardViewTasarimNesneleriniTutucu extends RecyclerView.ViewHolder{
        public TextView textViewepostas;
        public TextView textViewSifrees;
        public TextView textViewasdd;
        public TextView textView2asdd;


        public CardViewTasarimNesneleriniTutucu(@NonNull View itemView) {
            super(itemView);
            textView2asdd=itemView.findViewById(R.id.textView2asdd);
            textViewasdd=itemView.findViewById(R.id.textViewasdd);
            textViewepostas=itemView.findViewById(R.id.textViewepostas);
            textViewSifrees=itemView.findViewById(R.id.textViewSifrees);
             
        }
    }
}
