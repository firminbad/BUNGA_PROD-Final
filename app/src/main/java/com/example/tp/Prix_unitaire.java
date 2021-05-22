package com.example.tp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Prix_unitaire extends AppCompatActivity {
    private ImageView btn_conf, btn_modif, btn_imp;
    private Prix_unitaire activity;
    private TextView textView;
    private EditText editText;
    private String str;
    private Button btn_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prix_unitaire);

        btn_modif = (ImageView)findViewById(R.id.btn_modifP);

        textView = (TextView)findViewById(R.id.textViewP);
        btn_return = (Button)findViewById(R.id.bnt_return1);

        activity = Prix_unitaire.this;
        btn_modif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myPopup = new AlertDialog.Builder(activity);
                myPopup.setTitle("Modifier le prix actuel");
                final EditText input = new EditText(Prix_unitaire.this);
                myPopup.setView(input);
                myPopup.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textView.setText("Prix  = " + input.getText().toString());

                    }
                });



                myPopup.show();

                // textView.setText(str);
            }
        });

        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Prix_unitaire.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}