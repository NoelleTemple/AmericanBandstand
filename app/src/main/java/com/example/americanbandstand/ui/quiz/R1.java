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


public class R1 extends Fragment{ //extends AppCompatActivity {

    ArrayList<String> Results = new ArrayList<>();
    Button yes, no;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        Results = bundle.getStringArrayList("Results");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.r1, container, false);

        final TextView Reason = root.findViewById(R.id.ReasonTag);
        final TextView Question = root.findViewById(R.id.ArgueTag);
        if (Results.get(0) == "Q1A2" || Results.get(3) == "Two") {
            Argue(Results, root, Reason, Question);
        }
        else if (Results.get(1) == "Q2A3" || Results.get(2) == "Q3A3" || Results.get(2) == "Q3A4") {
            if (Results.get(1) == "Q2A3") {
                Reason.setText("You never hear back from the studio because of your neighborhood.");
                Question.setText("Do you show up same day anyway?");
            }
            else{
                Reason.setText("You never hear back from the studio because of your last name.");
                Question.setText("Do you show up same day anyway?");
            }
            yes = root.findViewById(R.id.yesbutton);
            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Results.add("Yes");
                    Argue(Results, root, Reason, Question);
                }
            });
            no = root.findViewById(R.id.nobutton);
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Results.add("No");
                    goHome(Results);
                }
            });
        }
        else {
            Question.setText("You're missing something: ");
            Reason.setText((CharSequence) Results);
        }

        return root;
    }
    public void Argue(ArrayList<String> Results, View root, TextView Reason, TextView Question){
        if (Results.size() > 1) {
            if (Results.get(3) == "Two") {
                Reason.setText("They say they're at capacity and that you can't go in, despite the membership card.");
            } else {
                Reason.setText("Sorry! No early approval means you don't get in!");
            }
        }
        else {
            Reason.setText("Sorry! No early approval means you don't get in!");
        }

        Question.setText("Do you Argue?");
        final ArrayList<String> temp = Results;

        yes = root.findViewById(R.id.yesbutton);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp.add("Yes");
                goArgYes(temp);
            }
        });

        no = root.findViewById(R.id.nobutton);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp.add("No");
                goHome(temp);
            }
        });
    }
    public void goHome(ArrayList<String> Results){
        R3 r3 = new R3();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("Results", Results);
        r3.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, r3);
        fragmentTransaction.commit();

    }
    public void goArgYes(ArrayList<String> Results){
        Q5 q5 = new Q5();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("Results", Results);
        q5.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, q5);
        fragmentTransaction.commit();
    }

}
