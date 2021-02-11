package com.casbek.passwordcreator;
/* Proje ekibi
 1711012002 Kadir Güler
1711012032 Muhammet Furkan Yiğit */
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Sifre extends AppCompatActivity {
 private RecyclerView rv;
 private ArrayList<Filimler> filimlerArrayList;
 private FilmAdapter adapter;
 private Button button1SifreOlustur,button1Kayit;

 private ConstraintLayout constraintLayout;
 private LinearLayout linearLayout1;
 private CardView cardView;

    private VeritabaniYardimcisi vt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sifre);
        button1Kayit=findViewById(R.id.button1Kayit);

        button1SifreOlustur=findViewById(R.id.button1SifreOlustur);
        constraintLayout=findViewById(R.id.constrait1);
        linearLayout1=findViewById(R.id.linearLayout1);
        cardView=findViewById(R.id.cardview);
        vt=new VeritabaniYardimcisi(this);
        rv=findViewById(R.id.rv);
        rv.setHasFixedSize(true);


        rv.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

        ArrayList<Filimler> gelenler=new Sifrelerdao().tumSifreler(vt);

        adapter = new FilmAdapter(this,gelenler);

        rv.setAdapter(adapter);

        button1SifreOlustur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(Sifre.this,MainActivity.class);
                startActivity(intent3);
            }
        });
        button1Kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4=new Intent(Sifre.this,Kayit.class);
                startActivity(intent4);
            }
        });


    }
}