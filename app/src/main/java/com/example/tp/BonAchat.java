package com.example.tp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BonAchat extends AppCompatActivity {
    private EditText editId, nom, prenom, quantite, tel, prix_u;
    private ImageView btn_conf, btn_imprimer;
    private TextView prix_t;
    private List<String> lists;
    private BonAchat activity;
    private  DataBaseHelp data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bon_achat);
        editId = (EditText)findViewById(R.id.idn2);
        nom = (EditText)findViewById(R.id.nom2);
        prenom = (EditText)findViewById(R.id.prenom2);
        quantite = (EditText)findViewById(R.id.qte);
        tel = (EditText)findViewById(R.id.tel2);
        prix_u = (EditText)findViewById(R.id.prix_u);
        prix_t = (TextView)findViewById(R.id.prix_total);




        btn_conf = (ImageView)findViewById(R.id.btn_valider);
        btn_imprimer = (ImageView)findViewById(R.id.btn_impr);
        data = new DataBaseHelp(BonAchat.this);
        prix_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int k = 0;
        if (!quantite.getText().toString().equals("") || !prix_u.getText().toString().equals(""))
        {
            k = Integer.parseInt(quantite.getText().toString()) * Integer.parseInt(prix_u.getText().toString());
            prix_t.setText(String.valueOf(k));
        }

            }
        });

        lists = new ArrayList<>();
        this.activity = BonAchat.this;
        btn_conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editId.getText().toString().equals("") || quantite.getText().toString().equals("") || prix_u.getText().toString().equals("") || prix_t.getText().toString().equals("")
                        ||  prenom.getText().toString().equals("") || prenom.getText().toString().equals("") || nom.getText().toString().equals("") || tel.getText().toString().equals("")){
                    Toast.makeText(BonAchat.this, "Veuillez remplir les champs vides ! ! !", Toast.LENGTH_SHORT).show();
                }else{
                    lists.add(editId.getText().toString());
                    lists.add(quantite.getText().toString());
                    lists.add(prix_u.getText().toString());
                    lists.add(prix_t.getText().toString());
                    lists.add(prenom.getText().toString());
                    lists.add(nom.getText().toString());
                    lists.add(tel.getText().toString());
                    data.insertbonAchat(lists);
                    Toast.makeText(BonAchat.this, "les informations sont enregistrées avec succèes", Toast.LENGTH_SHORT).show();
                    editId.setText("");
                    quantite.setText("");
                    editId.setText("");
                    prenom.setText("");
                    tel.setText("");
                    nom.setText("");
                    prix_t.setText("");
                    prix_u.setText("");

                }


            }
        });

        btn_imprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!lists.isEmpty()){
                    AlertDialog.Builder myPopup = new AlertDialog.Builder(activity);
                    myPopup.setTitle("Facture");
                    myPopup.setMessage(data.getbonAchat().toString());
                    myPopup.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(BonAchat.this, "les informations sont enregistrées avec succèes", Toast.LENGTH_SHORT).show();

                        }
                    });


                    myPopup.show();
                }else Toast.makeText(BonAchat.this, "Veuiller d'abord confirmer avant d'imprimer svp !!!", Toast.LENGTH_LONG).show();
            }
        });

    }
}