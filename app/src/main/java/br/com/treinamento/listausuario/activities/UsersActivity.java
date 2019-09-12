package br.com.treinamento.listausuario.activities;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.treinamento.listausuario.R;
import br.com.treinamento.listausuario.adapters.APIAdapter;
import br.com.treinamento.listausuario.boostrap.APIClient;
import br.com.treinamento.listausuario.model.Users;
import br.com.treinamento.listausuario.resource.UsersResource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UsersActivity extends AppCompatActivity {
    public ListView minhaLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        /*Pega a referencia do ENDPOINT e do converter(gson)
         * */
        Retrofit retrofit = APIClient.getClient();

        //Faz o 'bind' da instância do retrofit com interface
        //que contém as operações (GET,POST,PUT,DELETE)
        UsersResource usersResource = retrofit.create(UsersResource.class);

        //Faz a chamada do serviço
        //Call<List<Post>> get = postResource.get();
        Call<List<Users>> get = usersResource.get();

        get.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                //Se deu certo executa este método
                minhaLista = findViewById(R.id.minhaLista);
                List<Users> users = response.body();
                APIAdapter apiAdapter = new APIAdapter(getApplicationContext(), users);
                minhaLista.setAdapter(apiAdapter);
                //albums.forEach(p-> Log.i  ("senai",p.toString()));
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {

            }
        });

//        get.enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//                //Se deu certo executa este método
//                List<Post> posts = response.body();
//                posts.forEach(p-> Log.i  ("fasam",p.toString()));
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//                //Houve erro é executado este método.
//            }
//        });

    }
}
