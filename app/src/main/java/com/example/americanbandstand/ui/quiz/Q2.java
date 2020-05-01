package com.example.americanbandstand.ui.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.americanbandstand.R;

import java.util.ArrayList;

public class Q2 extends Fragment{ //extends AppCompatActivity {

    ArrayList<String> Results = new ArrayList<>();
    Button Q2A1, Q2A2, Q2A3, Q2A4;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        Results = bundle.getStringArrayList("Results");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_q2, container, false);

        Q2A1 = root.findViewById(R.id.q2A1);
        Q2A1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Results.add("Q2A1");
                goQ3(Results);
            }
        });
        Q2A2 = root.findViewById(R.id.q2A2);
        Q2A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Results.add("Q2A2");
                goQ3(Results);
            }
        });
        Q2A3 = root.findViewById(R.id.q2A3);
        Q2A3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Results.add("Q2A3");
                goR2Q(Results);
            }
        });
        Q2A4 = root.findViewById(R.id.q2A4);
        Q2A4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Results.add("Q2A4");
                goQ3(Results);
            }
        });

        return root;
    }
    private void goR2Q(ArrayList<String> Results) {
        R1 r2q = new R1();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("Results", Results);
        r2q.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, r2q);
        fragmentTransaction.commit();
    }
    private void goQ3(ArrayList<String> Results) {
        Q3 q3 = new Q3();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("Results", Results);
        q3.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, q3);
        fragmentTransaction.commit();
    }
}
