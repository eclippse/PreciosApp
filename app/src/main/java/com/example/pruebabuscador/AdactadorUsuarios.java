package com.example.pruebabuscador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdactadorUsuarios extends RecyclerView.Adapter<AdactadorUsuarios.UsuariosViewHolder> {

    Context context;
    List<Usuario> listaUsuarios;

    public AdactadorUsuarios(Context context, List<Usuario> listaUsuarios) {
        this.context = context;
        this.listaUsuarios = listaUsuarios;
    }

    @NonNull
    @Override
    public UsuariosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_usuario, viewGroup, false);
        return new UsuariosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuariosViewHolder usuariosViewHolder, int i) {
        usuariosViewHolder.tvNombre.setText(listaUsuarios.get(i).getNombre());
        usuariosViewHolder.tvTelefono.setText(listaUsuarios.get(i).getTelefono());
        usuariosViewHolder.tvEmail.setText(listaUsuarios.get(i).getEmail());
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public class UsuariosViewHolder extends RecyclerView.ViewHolder {

        TextView tvNombre, tvTelefono, tvEmail;

        public UsuariosViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvTelefono = itemView.findViewById(R.id.tvTelefono);
            tvEmail = itemView.findViewById(R.id.tvEmail);
        }
    }

    public void filtrar(ArrayList<Usuario> filtroUsuarios){
        this.listaUsuarios = filtroUsuarios;
        notifyDataSetChanged();
    }
}
