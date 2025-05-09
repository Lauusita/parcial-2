package com.laura.parcial_2.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laura.parcial_2.R;
import com.laura.parcial_2.adaptadores.UsuarioAdaptador;
import com.laura.parcial_2.clases.Usuario;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    RecyclerView rcv_users;
    List<Usuario> datos;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rcv_users = view.findViewById(R.id.rcv_list);

        Usuario usuario1 = new Usuario(
                "Rick",
                "Male",
                "Alive",
                "Human",
                "Human",
                "Citadel of Ricks",
                "https://rickandmortyapi.com/api/character/avatar/3.jpeg"
        );

        Usuario usuario2 = new Usuario(
                "Rick",
                "Male",
                "Alive",
                "Human",
                "Human",
                "Citadel of Ricks",
                "https://rickandmortyapi.com/api/character/avatar/2.jpeg"
        );

        Usuario usuario3 = new Usuario(
                "Rick",
                "Male",
                "Dead",
                "Human",
                "Human",
                "Citadel of Ricks",
                "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
        );

        datos = List.of(usuario1, usuario2, usuario3);

        rcv_users.setLayoutManager(new LinearLayoutManager(getContext()));

        UsuarioAdaptador usuarioAdaptador = new UsuarioAdaptador(this, datos);

        rcv_users.setAdapter(usuarioAdaptador);
        return view;
    }
}