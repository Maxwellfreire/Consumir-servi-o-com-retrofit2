package br.com.treinamento.listausuario.adapters;

import android.content.Context;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.treinamento.listausuario.R;
import br.com.treinamento.listausuario.model.Users;


public class APIAdapter extends BaseAdapter {


    Context context;
    List<Users> colecao;

    public APIAdapter(final Context applicationContext, final List<Users> colecao) {
        this.context = applicationContext;
        this.colecao = colecao;

    }

    @Override
    public int getCount() {
        return this.colecao != null ? this.colecao.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return this.colecao.get(i);
    }

    private Users parsetItem(int i) {
        return this.colecao.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        // inflate the layout for each list row
        //'Infla' o layout(pega a referencia) para ser trabalhada
        //no método
        if (view == null) {
            view = LayoutInflater.from(context).
                    inflate(R.layout.item_pessoa,
                            viewGroup, false);
        }

        // pega o objeto corrente da lista
        Users users = parsetItem(i);

        TextView campoID, campoNome, campoNomeUsuario, campoEmail, campoRua, campoSuite, campoCity,
                campoCEP,campogeoLAT,campogeolng, campoTelefone, campowwebsite,campoEmpresaNome, campoEmpresaCP,campoEmpresaBS;

        campoID = view.findViewById(R.id.txtItemID);
        campoNome = view.findViewById(R.id.txtItemNome);
        campoNomeUsuario = view.findViewById(R.id.txtItemNomeUsua);
        campoEmail = view.findViewById(R.id.txtItemEmail);
        campoRua = view.findViewById(R.id.txtItemRua);
        campoSuite = view.findViewById(R.id.txtItemSuite);
        campoCity = view.findViewById(R.id.txtItemCidade);
        campoCEP = view.findViewById(R.id.txtItemCep);
        campogeoLAT = view.findViewById(R.id.txtItemLat);
        campogeolng = view.findViewById(R.id.txtItemLng);
        campoTelefone = view.findViewById(R.id.txtItemPhone);
        campowwebsite = view.findViewById(R.id.txtItemAPI);
        campoEmpresaNome = view.findViewById(R.id.txtItemENOME);
        campoEmpresaCP = view.findViewById(R.id.txtItemEC);
        campoEmpresaBS = view.findViewById(R.id.txtItemBS);


        campoID.setText(Integer.toString(users.getId()));
        campoNome.setText(users.getName());
        campoNomeUsuario.setText(users.getUsername());
        campoEmail.setText(users.getEmail());
        campoRua.setText(users.getAddress().getStreet());
        campoSuite.setText(users.getAddress().getSuite());
        campoCity.setText(users.getAddress().getCity());
        campoCEP.setText(users.getAddress().getZipcode());
        campogeoLAT.setText(users.getAddress().getGeo().getLat());
        campogeolng.setText(users.getAddress().getGeo().getLng());
        campoTelefone.setText(users.getPhone());
        campowwebsite.setText(users.getWebsite());
        campoEmpresaNome.setText(users.getCompany().getName());
        campoEmpresaCP.setText(users.getCompany().getCatchphrase());
        campoEmpresaBS.setText(users.getCompany().getBs());

        return view;
    }
}
