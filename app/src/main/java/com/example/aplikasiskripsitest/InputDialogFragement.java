package com.example.aplikasiskripsitest;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputDialogFragement extends DialogFragment {

    Button btnOk, btnCancel;
    EditText editInput;

    public InputDialogFragement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.input_user_dialog, null);

        btnOk = view.findViewById(R.id.btnOk);
        btnCancel = view.findViewById(R.id.btnCancel);

        editInput = view.findViewById(R.id.input_fasilitas);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = editInput.getText().toString();

                if(!input.equals("")) {

                    ((InputBobotActivity)getActivity()).textViewFasilitas.setText(input);

                } else {

                    Toast.makeText(getActivity(), "Please Enter Something", Toast.LENGTH_SHORT).show();

                }

                getDialog().dismiss();
            }
        });
        return  view;

    }
}
