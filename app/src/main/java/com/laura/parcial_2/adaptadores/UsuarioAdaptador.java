package com.laura.parcial_2.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.laura.parcial_2.Detalle;
import com.laura.parcial_2.MainActivity;
import com.laura.parcial_2.R;
import com.laura.parcial_2.clases.Usuario;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import com.laura.parcial_2.databinding.ActivityMainBinding;
import com.laura.parcial_2.fragment.ProfileFragment;
import com.squareup.picasso.Picasso;

public class UsuarioAdaptador extends RecyclerView.Adapter<UsuarioAdaptador.ViewHolder> {

    private List<Usuario> datos;
    public Fragment fragment;

    TextView txt_status;
    public UsuarioAdaptador(Fragment fragment, List<Usuario> datos) {
       this.datos = datos;
       this.fragment = fragment;
    }

    @NonNull
    @Override
    public UsuarioAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioAdaptador.ViewHolder holder, int position) {
        Usuario dato = datos.get(position);
        holder.bind(dato);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_name, txt_species, txt_status;
        CircleImageView img_pfp;
        Button btn_details;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_species = itemView.findViewById(R.id.txt_species);
            txt_status = itemView.findViewById(R.id.txt_status);
            img_pfp = itemView.findViewById(R.id.img_pfp);
            btn_details = itemView.findViewById(R.id.btn_details);
        }

        public void bind(Usuario dato) {
            txt_name.setText(dato.getName());
            txt_species.setText(dato.getSpecies());
            txt_status.setText(dato.getStatus());

            Picasso.get().load(dato.getImage()).into(img_pfp);

            if (dato.getStatus().equalsIgnoreCase("Alive")) {
                txt_status.setTextColor(Color.parseColor("#03CF16"));
            } else if (dato.getStatus().equalsIgnoreCase("Dead")) {
                txt_status.setTextColor(Color.parseColor("#F80000"));
            }

            btn_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), Detalle.class);
                    v.getContext().startActivity(i);
                }
            });
        }
    }
}
