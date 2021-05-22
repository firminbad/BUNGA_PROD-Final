package com.example.tp;

import android.app.Dialog;
import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class Pop  extends Dialog {
    private EditText editText;
    private TextView textView;
    private String str;
    public Pop(@NonNull Context context) {
        super(context);

        editText = findViewById(R.id.editQ);
        textView = findViewById(R.id.textViewA);
        str = "";

    }

}
