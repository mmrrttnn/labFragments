package com.example.labfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.labfragments.fragment.AddCardListener;
import com.example.labfragments.fragment.BirthdayCardFragment;
import com.example.labfragments.fragment.DialogBirthdayFragment;
import com.example.labfragments.model.BirthdayCard;

public class MainActivity extends AppCompatActivity implements AddCardListener {

    private static final String FRAGMENT = "fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addCard = findViewById(R.id.a1_btnAdd);
        addCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                DialogBirthdayFragment dialogBirthdayFragment = DialogBirthdayFragment.newInstance();
                dialogBirthdayFragment.show(fragmentManager,"dialog_fragment");
            }
        });

        Button removeCard = findViewById(R.id.a1_btnRemove);
        removeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                BirthdayCardFragment birthdayCardFragment = (BirthdayCardFragment)getSupportFragmentManager().findFragmentByTag(FRAGMENT);

                if(birthdayCardFragment != null){
                    fragmentTransaction.remove(birthdayCardFragment);
                    fragmentTransaction.commit();
                }
            }
        });
    }

    @Override
    public void onFinishAddCard(BirthdayCard card) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragmentCard, BirthdayCardFragment.newInstance(card), FRAGMENT);
        ft.commit();
    }
}