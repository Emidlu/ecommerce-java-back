package org.example.servicios;

import org.example.entities.Dolar;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IDolarService {
    @GET("latest")
    Call<Dolar> getCotizacionDolar();


}
