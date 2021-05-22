package com.example.tp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



import java.util.ArrayList;
import java.util.List;


public class DataBaseHelp extends SQLiteOpenHelper {


    public DataBaseHelp(@Nullable Context context) {
        super(context, "Bunga.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table bonCommande(editId text primary key, nom text, prenom text, quantite text, tel text)");
        db.execSQL("create table bonAchat(editId text primary key, nom text, prenom text, quantite text, tel text, prix_u text, prix_t text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists bonCommande");
        db.execSQL("drop table if exists bonAchat");
    }

    public boolean insertbonCommande(List<String> lists){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("editId", lists.get(0));
        contentValues.put("nom", lists.get(1));
        contentValues.put("prenom", lists.get(2));
        contentValues.put("quantite", lists.get(3));
        contentValues.put("tel", lists.get(4));
        long ins = db.insert("bonCommande", null, contentValues);

        if (ins == -1)return false;
        else return true;
    }
    public boolean insertbonAchat(List<String> lists){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("editId", lists.get(0));
        contentValues.put("nom", lists.get(1));
        contentValues.put("prenom", lists.get(2));
        contentValues.put("quantite", lists.get(3));
        contentValues.put("tel", lists.get(4));
        contentValues.put("prix_u", lists.get(5));
        contentValues.put("prix_t", lists.get(6));
        long ins = db.insert("bonAchat", null, contentValues);

        if (ins == -1)return false;
        else return true;
    }
    public List<String> getbonAchat(){
        List<String> bonAchat = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from bonAchat", null);
        cursor.moveToFirst();
        while(cursor.isAfterLast() == false){
            bonAchat.add(cursor.getString(cursor.getColumnIndex("editId")));
            bonAchat.add(cursor.getString(cursor.getColumnIndex("nom")));
            bonAchat.add(cursor.getString(cursor.getColumnIndex("prenom")));
            bonAchat.add(cursor.getString(cursor.getColumnIndex("tel")));
            bonAchat.add(cursor.getString(cursor.getColumnIndex("quantite")));
            bonAchat.add(cursor.getString(cursor.getColumnIndex("prix_u")));
            bonAchat.add(cursor.getString(cursor.getColumnIndex("prix_t")));
            cursor.moveToNext();
        }
        return bonAchat;
    }
    public List<String> getbonCommande(){
        List<String> bonAchat = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from bonCommande", null);
        cursor.moveToFirst();
        while(cursor.isAfterLast() == false){
            bonAchat.add(cursor.getString(cursor.getColumnIndex("editId")));
            bonAchat.add(cursor.getString(cursor.getColumnIndex("nom")));
            bonAchat.add(cursor.getString(cursor.getColumnIndex("prenom")));
            bonAchat.add(cursor.getString(cursor.getColumnIndex("tel")));
            bonAchat.add(cursor.getString(cursor.getColumnIndex("quantite")));


            cursor.moveToNext();
        }
        return bonAchat;
    }

}
