package com.example.splash;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class IntroductionFragment extends Fragment {

    TextView result;

    Button add, subtract;

    int count = 0;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_intro, null);
       result = v.findViewById(R.id.text);
       add = v.findViewById(R.id.btnadd);
       subtract = v.findViewById(R.id.btnsub);
       add.setOnClickListener(new View.OnClickListener(){

           @Override
           public void onClick(View view) {
               count++;
               result.setText("" + count);
           };


       });
       subtract.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view) {
               count--;
               result.setText(""+count);
           }
       });
        return v;
    }
}

