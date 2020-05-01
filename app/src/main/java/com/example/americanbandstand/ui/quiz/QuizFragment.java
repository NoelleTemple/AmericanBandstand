package com.example.americanbandstand.ui.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.americanbandstand.R;

import java.util.ArrayList;


public class QuizFragment extends Fragment {
    Button Q1A1, Q1A2;
    private QuizViewModel quizViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        quizViewModel =
                ViewModelProviders.of(this).get(QuizViewModel.class);
        View root = inflater.inflate(R.layout.fragment_quiz, container, false);

        final ArrayList<String> Results = new ArrayList<>();
        Results.clear();

        Q1A1 = root.findViewById(R.id.Q1A1);
        Q1A1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Results.add("Q1A1");
                goQ2(Results);
            }
        });

        Q1A2 = root.findViewById(R.id.Q1A2);
        Q1A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Results.add("Q1A2");
                goR1(Results);
            }
        });

        return root;
    }

    private void goQ2(ArrayList<String> Results) {
        Q2 q2 = new Q2();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("Results", Results);
        q2.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, q2);
        fragmentTransaction.commit();
    }

    private void goR1(ArrayList<String> Results) {
        R1 r1 = new R1();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("Results", Results);
        r1.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, r1);
        fragmentTransaction.commit();
    }
}
