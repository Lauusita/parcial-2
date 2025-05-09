package com.laura.parcial_2.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.laura.parcial_2.Login;
import com.laura.parcial_2.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    private static final String dataUserCache = "user";
    private static final int privateMode = Context.MODE_PRIVATE;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    TextView txt_username;
    Button btn_close;
    public ProfileFragment() {
        // Required empty public constructor
    }


    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);

        txt_username = view.findViewById(R.id.txt_username);
        btn_close = view.findViewById(R.id.btn_close);

        String usuario = view.getContext().getSharedPreferences(dataUserCache, privateMode).getString("user", "0");

        txt_username.setText(usuario);

        sharedPreferences = view.getContext().getSharedPreferences(dataUserCache, privateMode);
        editor = sharedPreferences.edit();

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.commit();
                Intent i = new Intent(v.getContext(), Login.class);
                startActivity(i);
            }
        });
        return view;
    }
}