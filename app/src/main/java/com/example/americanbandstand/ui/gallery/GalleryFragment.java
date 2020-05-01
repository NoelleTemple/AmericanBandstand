package com.example.americanbandstand.ui.gallery;

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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView imageone = root.findViewById(R.id.Image1Text);

        InputStream inputStream = getResources().openRawResource(R.raw.imageonetext);
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(inputStream, Charset.forName("UTF-8")));
        StringBuilder Image1 = new StringBuilder();
        Image1.append(appender(reader));

        imageone.setText(Image1.toString());

        final TextView imagetwo = root.findViewById(R.id.Image23Text);
        InputStream inputStream2 = getResources().openRawResource(R.raw.imagetwotext);
        BufferedReader reader2 = new BufferedReader(new
                InputStreamReader(inputStream2, Charset.forName("UTF-8")));
        StringBuilder Image2 = new StringBuilder();
        Image2.append(appender(reader2));

        imagetwo.setText(Image2.toString());

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