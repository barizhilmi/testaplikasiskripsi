package com.example.aplikasiskripsitest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class InputBobotActivity extends AppCompatActivity  {

    TextView textViewHarga, textViewFasilitas, textViewRating, textViewJarak, textViewTransportasi;
    private Button showDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_bobot);

        textViewFasilitas = (TextView)findViewById(R.id.textView_fasilitas);
        textViewHarga = (TextView)findViewById(R.id.textView_harga);
        textViewJarak = (TextView)findViewById(R.id.textView_jarak);
        textViewRating = (TextView)findViewById(R.id.textView_rating);
        textViewTransportasi = (TextView)findViewById(R.id.textView_transportasi);

        showDialog = (Button)findViewById(R.id.btnTambahUser);
        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });


    }

    private void showDialog() {
        InputDialogFragement inputDialogFragement = new InputDialogFragement();
        inputDialogFragement.show(getSupportFragmentManager(),"Input Dialog");

    }


}
