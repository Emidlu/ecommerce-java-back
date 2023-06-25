package org.example.servicios;

import org.example.entities.Dolar;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ServicioDolar {
    private static final String apiUrl = "https://api.bluelytics.com.ar/v2/";
    private Retrofit retrofit;

    public ServicioDolar(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Dolar dolar() throws IOException {
        IDolarService dolarService = this.retrofit.create(IDolarService.class);

        Call<Dolar> requestDolar = dolarService.getCotizacionDolar();

        Response<Dolar> dolarResponse = requestDolar.execute();
        return dolarResponse.body();

    }

}
