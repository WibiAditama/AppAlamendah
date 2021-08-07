package com.example.alamendahapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DesaAlamendahApi {

    @Headers({
            "TOKEN_APP: eHNzYWR3ZWQxMjMxMzF3ZGE=",
            "ID_APP: d2FkYXdkd2Rhd2Rhb3B3bmpvaWF3ZmF3b3VpaGZkYXdvaW5kYXdvaWRobmF3b2lk"
    })
    @GET("api/wisata/wisata-one/{id}")
    Call<DataWisata> getWisata(@Path("id") int wisataId);

    @Headers({
            "TOKEN_APP: eHNzYWR3ZWQxMjMxMzF3ZGE=",
            "ID_APP: d2FkYXdkd2Rhd2Rhb3B3bmpvaWF3ZmF3b3VpaGZkYXdvaW5kYXdvaWRobmF3b2lk"
    })
    @POST("api/transaksi/pembayaran-wisata")
    Call<ObjectPembayaran> getResponse(@Body ObjectPembayaran objectPembayaran);
}
