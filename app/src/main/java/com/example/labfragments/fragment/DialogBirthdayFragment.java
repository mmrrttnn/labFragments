package com.example.labfragments.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.labfragments.R;
import com.example.labfragments.model.BirthdayCard;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DialogBirthdayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DialogBirthdayFragment extends DialogFragment {

    private EditText name, age, wish;
    private Button btnSave, btnCancel;
    private AddCardListener listener;

    public DialogBirthdayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     /* @param param1 Parameter 1.
     /* @param param2 Parameter 2.
     * @return A new instance of fragment DialogBirthdayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DialogBirthdayFragment newInstance() {
        return new DialogBirthdayFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog_birthday, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (AddCardListener) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.df_name);
        age = view.findViewById(R.id.df_age);
        wish = view.findViewById(R.id.df_wish);

        btnSave = view.findViewById(R.id.df_btnSave);
        btnSave = view.findViewById(R.id.df_btnCancel);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BirthdayCard card = new BirthdayCard(name.getText().toString(), Integer.parseInt(age.getText().toString()), wish.getText().toString());
                listener.onFinishAddCard(card);
                dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        name.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MODE_CHANGED);
    }
}