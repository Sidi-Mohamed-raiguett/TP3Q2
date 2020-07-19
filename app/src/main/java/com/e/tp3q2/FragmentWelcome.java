package com.e.tp3q2;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class FragmentWelcome extends Fragment implements View.OnClickListener{

    private TextView textView;
    private View view;
    private Button btnBack;
    private Bundle bundle;
    private FragmentLogin fragmentLogin;
    private FrameLayout frameLayout;
    private LinearLayout linearLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_welcome, container, false);
        linearLayout = view.findViewById(R.id.layout_welcome);
        textView = view.findViewById(R.id.textBien);
        btnBack = view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
        Bundle bundle = this.getArguments();
        String data = bundle.getString("key");
        textView.setText("Bienvenue Sidi Mohamed");

        colorAletoir();
        return view;
    }

    public void colorAletoir() {
//        frameLayout = view.findViewById(R.id.layout_welcome);
        Random random = new Random();
        int color = Color.argb(255,random.nextInt(256), random.nextInt(256), random.nextInt(256));
        linearLayout.setBackgroundColor(color);
    }

    @Override
    public void onClick(View view) {
        bundle = new Bundle();

        fragmentLogin = new FragmentLogin();
        fragmentLogin.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.layout1, fragmentLogin).commit();
    }
}