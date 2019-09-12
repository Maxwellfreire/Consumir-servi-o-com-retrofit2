package br.com.treinamento.listausuario.resource;


import java.util.List;

import br.com.treinamento.listausuario.model.Album;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AlbumResource {


    @GET("/albums")
    Call<List<Album>> get();


    @GET("/albums/{id}")
    Call<List<Album>> get(Integer id);
}