package com.casbek.passwordcreator;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class VeritabaniYardimcisi extends SQLiteOpenHelper{



    private static String veritabaniAdi = "sifreler";

    public VeritabaniYardimcisi(Context context) {

        super(context, "sifreler", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE sifreler (sifre_id INTEGER PRIMARY KEY AUTOINCREMENT,eposta TEXT,sifre TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS sifreler");

        onCreate(db);

    }

}