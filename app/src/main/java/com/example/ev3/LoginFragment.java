package com.example.ev3;

import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginFragment  extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.login_fragment, container,false);
        final TextInputLayout passwordTextInout = view.findViewById(R.id.password_text_input);
        final TextInputEditText passwordEditText = view.findViewById(R.id.password_edit_text);
        MaterialButton loginButton = view.findViewById(R.id.Login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPasswordValid(passwordEditText.getText())){
                    passwordTextInout.setError(getString(R.string.Login_error_message));
                }else {
                    passwordTextInout.setError(null);
                    ((NavigationHost)getActivity()).navigateTo(new HomeFragment(),false);
                }
            }
        });

        passwordEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (isPasswordValid(passwordEditText.getText())){
                    passwordTextInout.setError(null);
                }
                return false;
            }
        });

        return view;
    }

    private boolean isPasswordValid(@Nullable Editable text){ return text != null && text.length() >=6;}


}
