package com.example.appventas.modelos;

import com.example.appventas.MainActivity;
import com.example.appventas.entidades.ModeloUsuarios;
import com.example.appventas.servicos.APIinterface;
import com.example.appventas.servicos.RetrifitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModeloMainActivity {
    MainActivity mainActivity;

    public ModeloMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }
    public void getListaUsuarios(){
        APIinterface apiInterface = RetrifitInstance.getRetrofitInstance("http://192.168.100.9:4040/").create(APIinterface.class);
        Call<List<ModeloUsuarios>> call = apiInterface.getUsuarios();
        call.enqueue(new Callback<List<ModeloUsuarios>>() {
            //Aqui se obtiene la respuesta del servicio
            @Override
            public void onResponse(Call<List<ModeloUsuarios>> call, Response<List<ModeloUsuarios>> response) {
                ArrayList<ModeloUsuarios> usuarios = new ArrayList<>();
                usuarios = (ArrayList<ModeloUsuarios>) response.body();
                //se manda a llamar metodo para mostrar los resultados del servicio
                mainActivity.obtenerUsuarios(usuarios);
            }

            @Override
            public void onFailure(Call<List<ModeloUsuarios>> call, Throwable t) {
                System.out.println("no funciono");
            }
        });
    }

}
