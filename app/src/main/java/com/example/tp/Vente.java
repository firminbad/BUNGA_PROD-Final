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

public class Vente extends AppCompatActivity {
    private ImageView btn_conf, btn_modif, btn_imp;
    private Vente activity;
    private TextView textView;
    private EditText editText;
    private String str;
    private Button btn_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vente);

        btn_modif = (ImageView)findViewById(R.id.btn_modifV);

        textView = (TextView)findViewById(R.id.textViewV);
        btn_return = (Button)findViewById(R.id.bnt_return2);
        activity = Vente.this;

        btn_modif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myPopup = new AlertDialog.Builder(activity);
                myPopup.setTitle("Modifier la Quantité");
                final EditText input = new EditText(Vente.this);
                myPopup.setView(input);
                myPopup.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textView.setText("Sac vendus = " + input.getText().toString());

                    }
                });



                myPopup.show();

                // textView.setText(str);
            }
        });
        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Vente.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}