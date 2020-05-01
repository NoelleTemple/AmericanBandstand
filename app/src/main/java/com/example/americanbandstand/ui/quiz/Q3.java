package com.example.americanbandstand.ui.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.americanbandstand.R;

import java.util.ArrayList;

public class Q3 extends Fragment { //extends AppCompatActivity {

    ArrayList<String> Results = new ArrayList<>();
    Button Q3A1, Q3A2, Q3A3, Q3A4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        Results = bundle.getStringArrayList("Results");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.q3, container, false);
        String[] values = new String[1];
        Q3A1 = root.findViewById(R.id.name1);
        Q3A1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Results.add("Q3A1");
                //got approved!
                Random rand = new Random();
                int randint = rand.nextInt(2);
                if (randint == 1) {
                    Results.add("One");
                    goR5(Results);
                }
                else {
                    Results.add("Two");
                    goR1(Results);
                }
            }
        });
        Q3A2 = root.findViewById(R.id.name2);
        Q3A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Results.add("Q3A2");
                //got approved!
                Random rand = new Random();
                int randint = rand.nextInt(2);
                if (randint == 1) {
                    Results.add("One");
                    goR5(Results);
                }
                else {
                    Results.add("Two");
                    goR1(Results);
                }
            }
        });
        Q3A3 = root.findViewById(R.id.name3);
        Q3A3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Results.add("Q3A3");
                goR1(Results);
            }
        });
        Q3A4 = root.findViewById(R.id.name4);
        Q3A4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Results.add("Q3A4");
                goR1(Results);
            }
        });

        return root;
    }

    public void goR1(ArrayList<String> Results){
        R1 r1 = new R1();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("Results", Results);
        r1.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, r1);
        fragmentTransaction.commit();
    }

    public void goR5(ArrayList<String> Results){
        R3 r3 = new R3();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("Results", Results);
        r3.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, r3);
        fragmentTransaction.commit();
    }

}

