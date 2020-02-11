    package com.example.pruebabuscador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

    public class MainActivity extends AppCompatActivity {

    EditText etBuscador;
    RecyclerView rvLista;
    AdactadorUsuarios adactador;
    List<Usuario> listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        etBuscador = findViewById(R.id.etBuscador);
        etBuscador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filtrar(s.toString());
            }


        });

        rvLista = findViewById(R.id.rvLista);
        rvLista.setLayoutManager(new GridLayoutManager(this, 1));
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("DeTodito", "2.000", ""));
        listaUsuarios.add(new Usuario("Elite", "1.500", "Papel Higienico"));
        listaUsuarios.add(new Usuario("Cuaderno", "1.800", "100 hojas"));

        adactador = new AdactadorUsuarios(MainActivity.this, listaUsuarios);
        rvLista.setAdapter(adactador);

    }


    public void filtrar(String texto) {
        ArrayList<Usuario> filtrarLista = new ArrayList<>();
        for (Usuario usuario: listaUsuarios){

            if(usuario.getNombre().toLowerCase().contains(texto.toLowerCase())){
                filtrarLista.add(usuario);
            }
        }

        adactador.filtrar(filtrarLista);
    }
}
