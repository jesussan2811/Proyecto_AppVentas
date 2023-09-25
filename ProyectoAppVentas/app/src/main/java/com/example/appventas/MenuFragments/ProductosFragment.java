package com.example.appventas.MenuFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.appventas.AppVentasBD;
import com.example.appventas.Capturas.CapturaProductos;
import com.example.appventas.R;
import com.example.appventas.adaptadores.AdaptadorProductos;
import com.example.appventas.entidades.ModeloProductos;

import java.util.ArrayList;


public class ProductosFragment extends Fragment {

    RecyclerView rvProductos;
    ArrayList<ModeloProductos> listaProductos;
    AppVentasBD appVentasBD;
    Button btnNuevo;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ProductosFragment() {
        // Required empty public constructor
    }


    public static ProductosFragment newInstance(String param1, String param2) {
        ProductosFragment fragment = new ProductosFragment();
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
        View view = inflater.inflate(R.layout.fragment_productos, container, false);

        listaProductos = new ArrayList<>();
        rvProductos = view.findViewById(R.id.recyclerViewProductos);
        btnNuevo = (Button) view.findViewById(R.id.btnNuevoProducto);
        appVentasBD = new AppVentasBD(getContext());
        mostrarProductos(appVentasBD.mostrarProductos());


        /*Ajustar el recyclerview de manera vertical*/

        System.out.println(listaProductos.get(0).getProdNombre());
        rvProductos.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CapturaProductos.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        appVentasBD = new AppVentasBD(getContext());
        mostrarProductos(appVentasBD.mostrarProductos());
    }
    public void mostrarProductos(ArrayList<ModeloProductos> productos){

        listaProductos = productos;
        AdaptadorProductos adapter = new AdaptadorProductos(getActivity(),listaProductos);
        try {
            rvProductos.setAdapter(adapter);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}