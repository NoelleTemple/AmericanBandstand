package com.example.americanbandstand.ui.quiz;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.americanbandstand.R;

import java.util.ArrayList;


public class Q5 extends Fragment { //extends AppCompatActivity {

    ArrayList<String> Results = new ArrayList<>();
    Button Q5A2, Q5A3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        Results = bundle.getStringArrayList("Results");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.q5, container, false);

        Q5A2 = root.findViewById(R.id.Q5A2);
        Q5A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Results.add("Q5A2");
                Go(Results);
            }
        });

        Q5A3 = root.findViewById(R.id.Q5A3);
        Q5A3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Results.add("Q5A3");
                Go(Results);
            }
        });

        return root;
    }

    public void Go(ArrayList<String> Results){
        R3 r3 = new R3();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("Results", Results);
        r3.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, r3);
        fragmentTransaction.commit();
    }
}