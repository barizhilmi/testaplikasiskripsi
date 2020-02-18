package com.example.aplikasiskripsitest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.ArrayList;

public class InputDialog extends AppCompatDialogFragment {

    private EditText inputRating, inputHarga, inputFasilitas, inputJarak, inputTransportasi;
    private InputDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.input_user_dialog,null);


        builder.setView(view)
                .setTitle("Input Data User")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String fasilitas = inputFasilitas.getText().toString();
                        String harga = inputHarga.getText().toString();
                        String jarak = inputJarak.getText().toString();
                        String rating = inputRating.getText().toString();
                        String transportasi = inputTransportasi.getText().toString();

                        listener.applyTexts(fasilitas, rating, jarak ,harga, transportasi );
                    }
                });


        inputFasilitas = view.findViewById(R.id.textView_fasilitas);
        inputHarga =  view.findViewById(R.id.input_harga);
        inputJarak = view.findViewById(R.id.input_jarak);
        inputRating = view.findViewById(R.id.input_rating);
        inputTransportasi = view.findViewById(R.id.input_transportasi);
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (InputDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement InputDialogListener");
        }
    }

    public interface InputDialogListener{
        void applyTexts(String fasilitas, String rating, String jarak, String harga, String transportasi);
    }
}

