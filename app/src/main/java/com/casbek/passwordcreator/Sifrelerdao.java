package com.casbek.passwordcreator;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by kasimadalan on 16.01.2017.
 */

public class Sifrelerdao {

    public void SifreEkle(VeritabaniYardimcisi vt,String eposta ,String sifre){

        SQLiteDatabase dbx=vt.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put("eposta",eposta);
        values.put("sifre",sifre);
        dbx.insertOrThrow("sifreler", null, values);
        dbx.close();

    }
    public ArrayList<Filimler> tumSifreler(VeritabaniYardimcisi vt){

        ArrayList<Filimler> sifrelerArrayList=new ArrayList<>();
        SQLiteDatabase dbx=vt.getWritableDatabase();
        Cursor cursor=dbx.rawQuery("SELECT * FROM sifreler", null);

        while(cursor.moveToNext()){
            Filimler kisi = new Filimler(cursor.getInt(cursor.getColumnIndex("sifre_id"))
                    ,cursor.getString(cursor.getColumnIndex("eposta"))
                    ,cursor.getString(cursor.getColumnIndex("sifre")));
            sifrelerArrayList.add(kisi);
        }
        return sifrelerArrayList;

    }






    public Sifrelerdao sifreSil(VeritabaniYardimcisi vt, int sifre_id){
        SQLiteDatabase dbx=vt.getWritableDatabase();
        dbx.delete("sifreler", "sifre_id=?",new String[] {String.valueOf(sifre_id)} );
        dbx.close();

        return null;
    }




    public void kisiGuncelle(VeritabaniYardimcisi vt,int kisi_no,String kisi_ad,String kisi_tel,int kisi_yas,Double kisi_boy){

        SQLiteDatabase dbx=vt.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put("kisi_ad",kisi_ad );
        values.put("kisi_tel",kisi_tel );
        values.put("kisi_yas",kisi_yas );
        values.put("kisi_boy",kisi_boy );

        dbx.update("kisiler", values,"kisi_no=?",new String[] {String.valueOf(kisi_no)});
        dbx.close();

    }




}

