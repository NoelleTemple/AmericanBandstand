package com.example.americanbandstand.ui.CRM;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.americanbandstand.R;
import com.example.americanbandstand.ui.gallery.GalleryViewModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class CRMFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.crm_layout, container, false);

        final TextView text = root.findViewById(R.id.crmtext);

        InputStream inputStream = getResources().openRawResource(R.raw.crm);
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(inputStream, Charset.forName("UTF-8")));
        StringBuilder building = new StringBuilder();
        building.append(appender(reader));

        text.setText(building.toString());

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
