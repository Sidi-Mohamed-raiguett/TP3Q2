package com.e.tp3q2;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FragmentLogin extends Fragment implements View.OnClickListener {

    private EditText editEmail1,editMotPasse1;
    private Button btnEnv;
    private View view;
    private Bundle bundle;
    private FragmentWelcome fragmentWelcome;
    private int nbBackstack = 0, nb;

    // test mot de passe use pattern
    String pattern2 = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@$%^&*()_+'])(?=\\S+$).{8,40}";

    // test email use pattern
    String emailPattern = "^(.+){2,}@(.+){3,}.com|net|org$";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);

        initView();

        int orientation = getActivity().getResources().getConfiguration().orientation;

        if(orientation == Configuration.ORIENTATION_PORTRAIT){

        }

        return view;
    }

    public void initView() {
        editEmail1 = view.findViewById(R.id.editEmail);
        editMotPasse1 = view.findViewById(R.id.editMotPasse);
        btnEnv = view.findViewById(R.id.btn);
        btnEnv.setOnClickListener(this);
    }

    public boolean isEditTextPAttern(EditText editText){
        if ((editText.getText().toString().matches(emailPattern) == true) || (editText.getText().toString().matches(pattern2) == true)) {
            return false;
        }
        editText.requestFocus();
        editText.setError(getString(R.string.invalide));
        return true;
    }

    private boolean isEditTextEmpty(EditText editText) {
        if (!editText.getText().toString().isEmpty()) {
            return false;
        }
        editText.requestFocus();
        editText.setError("Champ obligatoire!");
        return true;
    }

    private boolean isSidiMhamed(EditText editText) {
        if ((editEmail1.getText().toString().equals("sidimohaned23@gmail.com") == true) && (editMotPasse1.getText().toString().equals("sdSD23@@") == true)) {
            return false;
        }
        editText.requestFocus();
        editText.setError("incorrect");
        return true;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn){
            if (isEditTextEmpty(editEmail1) || isEditTextEmpty(editMotPasse1)){
                return;
            }
            else if(isEditTextPAttern(editEmail1) || isEditTextPAttern(editMotPasse1)) {
                return;
            }
            else{
                if(isSidiMhamed(editEmail1) && isSidiMhamed(editMotPasse1)){
                    return;
                }
                else {
                    remplaceFragment();
                }
            }

        }
    }

    public void remplaceFragment() {
        bundle = new Bundle();
        //bundle.putString("key",editEmail1.getText().toString());
        fragmentWelcome = new FragmentWelcome();
        fragmentWelcome.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.layout1, fragmentWelcome);
        nb = nbBackstack++;
        fragmentTransaction.addToBackStack("welcom");
        fragmentTransaction.commit();
        //getFragmentManager().beginTransaction().replace(R.id.layout1, fragmentWelcome).commit();
    }
}