package com.example.salvador.gamenews.Api;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;
import rx.Single;

public interface GameNewsAPI {

    @POST("/login")
    @FormUrlEncoded  //Para enviar varias partes
    Observable<Usuario> iniciarSesion(@Field("user") String user, @Field("password") String pass);
}
