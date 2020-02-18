package com.example.aplikasiskripsitest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class HalamanListActivity extends AppCompatActivity {
    private String[] dataPantai = {"Pantai Mondangan","Pantai Jonggring Saloko","Pantai Ngliyep-Pasir Panjang"
            ,"Pantai Bantol","Pantai Kondang Iwak","Pantai Kondang Merak", "Pantai Balekambangan", "Pantai Wonogoro",
            "Pantai Ngantep", "Pantai Bajulmati", "Pantai Goa Cina", "Pantai Sendang Biru", "Pantai Tamban Indah",
            "Pantai Lenggoksono", "Pantai Wediawu", "Pantai Sepilot", "Pantai Licin"};
    private Button btnCari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_list);
        btnCari = findViewById(R.id.btnCari);
        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHalamanInputBobot();
            }
        });

        ListView listView = findViewById(R.id.list_pantai_malang);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, dataPantai);
        listView.setAdapter(adapter);
    }


    public void launchHalamanInputBobot(){
        Intent intent = new Intent(HalamanListActivity.this, InputBobotActivity.class);
        startActivity(intent);
    }
}
