package com.example.americanbandstand.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.americanbandstand.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView homepage = root.findViewById(R.id.home_text);

        InputStream inputStream = getResources().openRawResource(R.raw.home);
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(inputStream, Charset.forName("UTF-8")));
        StringBuilder HomeText = new StringBuilder();
        HomeText.append(appender(reader));
        InputStream inputStream2 = getResources().openRawResource(R.raw.home2);
        BufferedReader reader2 = new BufferedReader(new
                InputStreamReader(inputStream2, Charset.forName("UTF-8")));
        HomeText.append(appender(reader2));
        InputStream inputStream3 = getResources().openRawResource(R.raw.home3);
        BufferedReader reader3 = new BufferedReader(new
                InputStreamReader(inputStream3, Charset.forName("UTF-8")));
        HomeText.append(appender(reader3));
        InputStream inputStream4 = getResources().openRawResource(R.raw.home4);
        BufferedReader reader4 = new BufferedReader(new
                InputStreamReader(inputStream4, Charset.forName("UTF-8")));
        HomeText.append(appender(reader4));

        homepage.setText(HomeText.toString());

        /*homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

    public String appender (BufferedReader buffread){
        StringBuilder HomeText = new StringBuilder();
        String line = "";
        HomeText.append("\t");
        try {
            while ((line = buffread.readLine()) != null) {
                HomeText.append(line);
            }
        } catch (IOException e) {
            Log.wtf("TestData: Error reading datafile on line " + line, e);
            e.printStackTrace();
        }
        HomeText.append("\n\n");
        return HomeText.toString();
    }
}