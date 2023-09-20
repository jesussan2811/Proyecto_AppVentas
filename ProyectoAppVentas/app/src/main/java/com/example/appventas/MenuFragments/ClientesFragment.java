package com.example.appventas.MenuFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.appventas.AppVentasBD;
import com.example.appventas.Capturas.CapturaClientes;
import com.example.appventas.R;
import com.example.appventas.adaptadores.AdaptadorClientes;
import com.example.appventas.entidades.ModeloClientes;

import java.util.ArrayList;


public class ClientesFragment extends Fragment {

    RecyclerView rvClientes;
    ArrayList<ModeloClientes> listaClientes;
    AppVentasBD appVentasBD;
    Button btnNuevo;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ClientesFragment() {
        // Required empty public constructor
    }

    public static ClientesFragment newInstance(String param1, String param2) {
        ClientesFragment fragment = new ClientesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clientes, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listaClientes = new ArrayList<>();
        rvClientes = view.findViewById(R.id.recyclerViewClientes);
        btnNuevo = (Button) view.findViewById(R.id.nuevoCliente);

        /*Ajustar el recyclerview de manera vertical*/
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rvClientes.setLayoutManager(linearLayoutManager);

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CapturaClientes.class);
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();

    }
    public void mostrarClientes(ArrayList<ModeloClientes> clientes){

        listaClientes  = clientes;
        AdaptadorClientes adapter = new AdaptadorClientes(this,listaClientes);
        try {
            rvClientes.setAdapter(adapter);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}