package com.example.finalproject.view.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.finalproject.R;
import com.example.finalproject.view.LoginActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
    private TextView username;
    private Button btn_logout;

    SharedPreferences sharedPreferences;

    private static final String shared_pref_name = "mypref";
    private static final String key_uname = "username";

    @SuppressLint("WrongViewCast")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Tempat untuk ngoding. Fungsinya sama seperti method onCreate di Activity
        username = getView().findViewById(R.id.username);
        btn_logout = getView().findViewById(R.id.btn_logout);

        sharedPreferences = this.getActivity().getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        String name = sharedPreferences.getString(key_uname, null);
        if (name != null){
            username.setText(name);
        }

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}