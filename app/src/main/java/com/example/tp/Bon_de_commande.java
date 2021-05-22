package com.example.tp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Bon_de_commande extends AppCompatActivity {
    private EditText editId, nom, prenom, quantite, tel;
    private ImageView btn_conf, btn_imprimer;
    private List<String> lists;
    private Bon_de_commande activity;
    private  DataBaseHelp data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bon_de_commande);
        editId = (EditText)findViewById(R.id.idn);
        nom = (EditText)findViewById(R.id.nom);
        prenom = (EditText)findViewById(R.id.prenom);
        quantite = (EditText)findViewById(R.id.quantite);
        tel = (EditText)findViewById(R.id.tel);

        data = new DataBaseHelp(Bon_de_commande.this);

        btn_conf = (ImageView)findViewById(R.id.btn_conf);
        btn_imprimer = (ImageView)findViewById(R.id.btn_imprimer);

        lists = new ArrayList<>();
                this.activity = Bon_de_commande.this;
                btn_conf.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editId.getText().toString().equals("") || quantite.getText().toString().equals("")
                                ||  prenom.getText().toString().equals("") || prenom.getText().toString().equals("") || nom.getText().toString().equals("") || tel.getText().toString().equals("")){
                            Toast.makeText(Bon_de_commande.this, "Veuillez remplir les champs vides svp!", Toast.LENGTH_SHORT).show();
                        }else{
                            lists.add(editId.getText().toString());
                            lists.add(quantite.getText().toString());
                            lists.add(prenom.getText().toString());
                            lists.add(nom.getText().toString());
                            lists.add(tel.getText().toString());
                            data.insertbonCommande(lists);
                            Toast.makeText(Bon_de_commande.this, "Vos informations sont enregistrées avec succèes!", Toast.LENGTH_SHORT).show();
                            editId.setText("");
                            quantite.setText("");
                            editId.setText("");
                            prenom.setText("");
                            tel.setText("");
                            nom.setText("");
                        }

            }
        });

        btn_imprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!lists.isEmpty()){
                    AlertDialog.Builder myPopup = new AlertDialog.Builder(activity);
                    myPopup.setTitle("Impression");
                    myPopup.setMessage(data.getbonCommande().toString());
                    myPopup.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(Bon_de_commande.this, "Vos informations sont enregistrées avec succèes!", Toast.LENGTH_SHORT).show();

                        }
                    });


                    myPopup.show();
                }else  Toast.makeText(Bon_de_commande.this, "Veuillez d'abord confirmer avant d'imprimer svp!", Toast.LENGTH_SHORT).show();


            }
        });

    }
}