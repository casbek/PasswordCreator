package com.casbek.passwordcreator;
/* Proje ekibi
 1711012002 Kadir Güler
1711012032 Muhammet Furkan Yiğit */

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
//sifre olusturma kopyalama sayfası
    private ImageButton imageButtonYeniSifre;
    private Button buttonKopyala,buttonOlustur,buttonKayitGit,buttonSifreOlusturGit,buttonSifrelerimGit;
    private TextView textViewSifre;
    private EditText editTextParolaUzunlugu;
    private Switch sRakam,sBuyukHarf,sKarakter;

     void SifreOlusturucu(int uzunlukk,String kıraker){
        String sifre="";
        Random rnd=new Random();


        for (int i=0;i<uzunlukk;i++){
            int rSayi=(int)Math.floor(Math.random()*kıraker.length());
            sifre=sifre+kıraker.substring(rSayi,rSayi+1);
        }
        textViewSifre.setText(sifre);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButtonYeniSifre=findViewById(R.id.imageButtonYeniSifre);
        buttonKopyala=findViewById(R.id.buttonKopyala);
        buttonOlustur=findViewById(R.id.buttonOlustur);
        buttonKayitGit=findViewById(R.id.buttonKayitGit);
        buttonSifreOlusturGit=findViewById(R.id.buttonSifreOlusturGit);
        buttonSifrelerimGit=findViewById(R.id.buttonSifrelerimGit);
        textViewSifre=findViewById(R.id.textViewSifre);
        sRakam=findViewById(R.id.sRakam);
        sBuyukHarf=findViewById(R.id.sBuyukHarf);
        sKarakter=findViewById(R.id.sKarakter);
        editTextParolaUzunlugu=findViewById(R.id.editTextParolaUzunlugu);



        buttonSifrelerimGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Sifre.class);
                startActivity(intent);
            }
        });
        buttonKayitGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Kayit.class);
                startActivity(intent);
            }
        });
        imageButtonYeniSifre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Yapıldı---algoritmaa buraya random şifre oluşturan kod textviewe yaz

                String sifre="";
                String karakterler="0123456789abcdefghijklmnopqrstuvwxtzABCDEFGHIJKLMNOPQRSTUVWXTZ!@#$^&*()_+?><:{}[]";
                Random rnd=new Random();

                int karakterSayisi=(int)(Math.random()*12+8);

                for (int i=0;i<karakterSayisi;i++){
                    int rSayi=(int)Math.floor(Math.random()*karakterler.length());
                    sifre=sifre+karakterler.substring(rSayi,rSayi+1);
                }
                textViewSifre.setText(sifre);

            }
        });
   buttonOlustur.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           //en zor algoritma switc sayı bilgisini alıp ona göre textviewe sonuc yazdır
            Boolean Harf=sBuyukHarf.isChecked();//harflerin durumu
            Boolean Karakter=sKarakter.isChecked();//karakter durumu
            Boolean Rakam=sRakam.isChecked();//rakam durumu
           int uzunluk= Integer.parseInt(editTextParolaUzunlugu.getText().toString());//girilen sayi
          if(uzunluk>3&&uzunluk<64) {//karaktersayısı kontrol

              //koşuldurumları
              if (Harf && Karakter && Rakam) {
                  String karakterler = "0123456789abcdefghijklmnopqrstuvwxtzABCDEFGHIJKLMNOPQRSTUVWXTZ!@#$^&*()_+?><:{}[]";
                  SifreOlusturucu( uzunluk, karakterler);
              } else if (Harf && !Karakter && Rakam) {
                  String karakterler = "0123456789abcdefghijklmnopqrstuvwxtzABCDEFGHIJKLMNOPQRSTUVWXTZ";
                  SifreOlusturucu( uzunluk, karakterler);
              } else if (!Harf && !Karakter && !Rakam) {
                  String karakterler = "abcdefghijklmnopqrstuvwxtz";
                  SifreOlusturucu( uzunluk, karakterler);
              } else if (Harf && Karakter && !Rakam) {
                  String karakterler = "abcdefghijklmnopqrstuvwxtzABCDEFGHIJKLMNOPQRSTUVWXTZ!@#$^&*()_+?><:{}[]";
                  SifreOlusturucu( uzunluk, karakterler);
              } else if (!Harf && Karakter && Rakam) {
                  String karakterler = "0123456789abcdefghijklmnopqrstuvwxtz!@#$^&*()_+?><:{}[]";
                  SifreOlusturucu( uzunluk, karakterler);
              } else if (Harf && !Karakter && !Rakam) {
                  String karakterler = "abcdefghijklmnopqrstuvwxtzABCDEFGHIJKLMNOPQRSTUVWXTZ";
                  SifreOlusturucu( uzunluk, karakterler);
              } else if (!Harf && Karakter && !Rakam) {
                  String karakterler = "abcdefghijklmnopqrstuvwxtz!@#$^&*()_+?><:{}[]";
                  SifreOlusturucu( uzunluk, karakterler);
              } else if (!Harf && !Karakter && Rakam) {
                  String karakterler = "0123456789abcdefghijklmnopqrstuvwxtz";
                  SifreOlusturucu( uzunluk, karakterler);
              } else {
                  Toast.makeText(MainActivity.this,"Birseyler yanlis gitti",Toast.LENGTH_LONG).show();
              }

          }
          else{
              Toast.makeText(MainActivity.this,"4-64 arası bir sayi giriniz",Toast.LENGTH_LONG).show();
          }


       }
   });
   buttonKopyala.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           //yapıldı----buton kopyala textviewni içindeki sifreyi kopyalayacak
           ClipboardManager kopyala=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
           ClipData kopy=ClipData.newPlainText("sifrekopyala",textViewSifre.getText().toString());
           kopyala.setPrimaryClip(kopy);
           Toast.makeText(MainActivity.this,"Kopyalandi",Toast.LENGTH_SHORT).show();
       }
   });

    }
}