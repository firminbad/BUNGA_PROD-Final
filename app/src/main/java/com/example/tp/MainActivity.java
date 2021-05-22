package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView bon_achat;
    private ImageView bon_com;
    private ImageView production;
    private ImageView vente;
    private ImageView prix_u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bon_com = (ImageView) findViewById(R.id.bon_com);
        bon_achat = (ImageView) findViewById(R.id.bon_achat);
        production = (ImageView) findViewById(R.id.production);
        vente = (ImageView) findViewById(R.id.vente);
        prix_u = (ImageView) findViewById(R.id.prix_unitaire);


        bon_com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bon_de_commande.class);
                startActivity(intent);
            }

        });
        bon_achat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BonAchat.class);
                startActivity(intent);
            }

        });

        production.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Production.class);
                startActivity(intent);
            }

        });

        vente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Vente.class);
                startActivity(intent);
            }

        });

        prix_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Prix_unitaire.class);
                startActivity(intent);
            }

        });
    }
}