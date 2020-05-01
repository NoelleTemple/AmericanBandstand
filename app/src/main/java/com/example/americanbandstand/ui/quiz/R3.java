package com.example.americanbandstand.ui.quiz;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.americanbandstand.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.security.cert.CertPathValidatorException;
import java.util.ArrayList;


public class R3 extends Fragment{ //extends AppCompatActivity {

    ArrayList<String> Results = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        Results = bundle.getStringArrayList("Results");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.r3, container, false);

        TextView FinalReason = root.findViewById(R.id.FinalReasonTag);

        String R3 = "Sorry, but you just watch from home.";
        String R4 = "A fight breaks out between you and a white teenager trying to pass in front of you.";
        String R5 = "They let you in!  But as the show goes on, you notice the camera avoids you at all costs.";

        if (Results.get(0) == "Q1A2"){
            if (Results.get(1) == "No"){
                FinalReason.setText(R3);
            }
            else if (Results.get(1) == "Yes"){
                if (Results.get(2) == "Q5A2"){
                    FinalReason.setText(R4);
                }
                else if (Results.get(2) == "Q5A3"){
                    FinalReason.setText(R5);
                }
                else {
                    FinalReason.setText("You missed something: " + Results);
                }
            }
            else {
                FinalReason.setText("You missed something: " + Results);
            }
        }
        else if (Results.get(0) == "Q1A1"){
            if (Results.get(1) == "Q2A3") {
                if (Results.get(2) == "No") {
                    FinalReason.setText(R3);
                } else if (Results.get(2) == "Yes") {
                    if (Results.get(3) == "No") {
                        FinalReason.setText(R3);
                    } else if (Results.get(3) == "Yes") {
                        if (Results.get(4) == "Q5A2") {
                            FinalReason.setText(R4);
                        } else if (Results.get(4) == "Q5A3") {
                            FinalReason.setText(R5);
                        } else {
                            FinalReason.setText("You missed something: " + Results);
                        }
                    } else {
                        FinalReason.setText("You missed something: " + Results);
                    }
                } else {
                    FinalReason.setText("You missed something: " + Results);
                }
            }
            else if (Results.get(1) == "Q2A1" || Results.get(1) == "Q2A2" || Results.get(1) == "Q2A4"){
                if (Results.get(2) == "Q3A1" || Results.get(2) == "Q3A2"){
                    if (Results.get(3) == "One"){
                        FinalReason.setText(R5);
                    }
                    else if (Results.get(3) == "Two"){
                        if (Results.get(4) == "No"){
                            FinalReason.setText(R3);
                        }
                        else if (Results.get(4) == "Yes"){
                            if (Results.get(5) == "Q5A2"){
                                FinalReason.setText(R4);
                            }
                            else if (Results.get(5) == "Q5A3"){
                                FinalReason.setText(R5);
                            }
                            else {
                                FinalReason.setText("You missed something: " + Results);
                            }
                        }
                        else{
                            FinalReason.setText("You missed something: " + Results);
                        }
                    }
                    else {
                        FinalReason.setText("You missed something: HERE!" + Results);
                    }
                }
                else if (Results.get(2) == "Q3A3" || Results.get(2) == "Q3A4") {
                    if (Results.get(3) == "No") {
                        FinalReason.setText(R3);
                    } else if (Results.get(3) == "Yes") {
                        if (Results.get(4) == "No") {
                            FinalReason.setText(R3);
                        } else if (Results.get(4) == "Yes") {
                            if (Results.get(5) == "Q5A2") {
                                FinalReason.setText(R4);
                            } else if (Results.get(5) == "Q5A3") {
                                FinalReason.setText(R5);
                            } else {
                                FinalReason.setText("You missed something: " + Results);
                            }
                        } else {
                            FinalReason.setText("You missed something: " + Results);
                        }
                    }
                    else {
                        FinalReason.setText("You missed something: " + Results);
                    }
                }
                else {
                    FinalReason.setText("You missed something: " + Results);
                }

            }
            else {
                FinalReason.setText("You missed something: " + Results);
            }
        }
        else {
            FinalReason.setText("You missed something: " + Results);
        }


        TextView FinalText = root.findViewById(R.id.FinalText);

        InputStream inputStream = getResources().openRawResource(R.raw.quizfinal);
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(inputStream, Charset.forName("UTF-8")));
        StringBuilder One = new StringBuilder();
        One.append(appender(reader));

        FinalText.setText(One.toString());


        return root;
    }
    public String appender (BufferedReader buffread){
        StringBuilder Text = new StringBuilder();
        String line = "";
        Text.append("\t\t\t\t");
        try {
            while ((line = buffread.readLine()) != null) {
                Text.append(line);
            }
        } catch (IOException e) {
            Log.wtf("TestData: Error reading datafile on line " + line, e);
            e.printStackTrace();
        }
        Text.append("\n\n");
        return Text.toString();
    }
}