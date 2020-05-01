package com.example.americanbandstand.ui.Songs;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class SongFragment extends Fragment {
    Button twist_btn, potato_btn, Cooke_btn;
    private SongViewModel songViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        songViewModel =
                ViewModelProviders.of(this).get(SongViewModel.class);
        View root = inflater.inflate(R.layout.fragment_song, container, false);
        final TextView TitleOne = root.findViewById(R.id.Title1);
        TitleOne.setText("The Twist (1960) by Chubby Checker");
        final TextView TwistText = root.findViewById(R.id.Text1);
        twist_btn = root.findViewById(R.id.twist_btn);
        final boolean[] i = {false};
        final MediaPlayer alarm_test = MediaPlayer.create(getActivity(), R.raw.thetwist);
        twist_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i[0] = !i[0];
                if (i[0]) {
                    alarm_test.start();
                    alarm_test.setLooping(true);
                } else {
                    alarm_test.pause();
                    //alarm_test.stop(); //to completely stop
                }
            }
        });
        InputStream inputStream = getResources().openRawResource(R.raw.twisttext);
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(inputStream, Charset.forName("UTF-8")));
        StringBuilder Image1 = new StringBuilder();
        Image1.append(appender(reader));

        TwistText.setText(Image1.toString());

        final TextView TitleTwo = root.findViewById(R.id.Title2);
        TitleTwo.setText("Mashed Potato Time (1962) by Dee Dee Sharp");
        final TextView PotatoText = root.findViewById(R.id.Text2);
        potato_btn = root.findViewById(R.id.potato_btn);
        final boolean[] o = {false};
        final MediaPlayer potato_test = MediaPlayer.create(getActivity(), R.raw.potato);
        potato_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                o[0] = !o[0];
                if (o[0]) {
                    potato_test.start();
                    potato_test.setLooping(true);
                } else {
                    potato_test.pause();
                    //alarm_test.stop(); //to completely stop
                }
            }
        });
        InputStream inputStream2 = getResources().openRawResource(R.raw.potatotext);
        BufferedReader reader2 = new BufferedReader(new
                InputStreamReader(inputStream2, Charset.forName("UTF-8")));
        StringBuilder Image2 = new StringBuilder();
        Image2.append(appender(reader2));

        PotatoText.setText(Image2.toString());

        final TextView TitleThree = root.findViewById(R.id.Title3);
        TitleThree.setText("(I Love You) For Sentimental Reasons (1957) by Sam Cooke");
        final TextView CookeText = root.findViewById(R.id.Text3);
        Cooke_btn = root.findViewById(R.id.Cooke_btn);
        final boolean[] u = {false};
        final MediaPlayer Cooke_test = MediaPlayer.create(getActivity(), R.raw.cooke);
        Cooke_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                u[0] = !u[0];
                if (u[0]) {
                    Cooke_test.start();
                    Cooke_test.setLooping(true);
                } else {
                    Cooke_test.pause();
                    //alarm_test.stop(); //to completely stop
                }
            }
        });
        InputStream inputStream3 = getResources().openRawResource(R.raw.cooketext);
        BufferedReader reader3 = new BufferedReader(new
                InputStreamReader(inputStream3, Charset.forName("UTF-8")));
        StringBuilder Image3 = new StringBuilder();
        Image3.append(appender(reader3));

        CookeText.setText(Image3.toString());


        TextView TitleFour = root.findViewById(R.id.Title4);
        TitleFour.setText("Music on American Bandstand");

        final TextView FinalText = root.findViewById(R.id.Text4);
        InputStream inputStream4 = getResources().openRawResource(R.raw.finaltext);
        BufferedReader reader4 = new BufferedReader(new
                InputStreamReader(inputStream4, Charset.forName("UTF-8")));
        StringBuilder Image4 = new StringBuilder();
        Image4.append(appender(reader4));

        FinalText.setText(Image4.toString());

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