package com.example.americanbandstand.ui.gallery;

import android.os.Bundle;
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
        final TextView textView = root.findViewById(R.id.Image1Text);

        /*InputStream inputStream = getResources().openRawResource(R.raw.);
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(inputStream, Charset.forName("UTF-8")));
        StringBuilder HomeText = new StringBuilder();
        HomeText.append(appender(reader));

        homepage.setText(HomeText.toString());
*/
        return root;
    }
}