package com.example.americanbandstand.ui.sources;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.americanbandstand.R;
import com.example.americanbandstand.ui.Songs.SongViewModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Source;

public class SourcesFragment extends Fragment {

    ArrayList<String> list = new ArrayList();
    ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_source, container, false);

        InputStream inputStream = getResources().openRawResource(R.raw.sources);
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(inputStream, Charset.forName("UTF-8")));
        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                String result = line;
                list.add(result);
            }
        } catch (IOException e) {
            Log.wtf("TestData: Error reading datafile on line " + line, e);
            e.printStackTrace();
        }

        TextView textView1 = root.findViewById(R.id.sourcetext);

        StringBuilder SourceBuilder = new StringBuilder();

        for (int i =0; i < 17; i++) {
            SourceBuilder.append(list.get(i) + "\n\n");
        }

        textView1.setText(SourceBuilder.toString());


        return root;
    }
}
