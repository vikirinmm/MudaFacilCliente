package com.example.mudafacil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Tela_Principal_Adapter extends RecyclerView.Adapter<Tela_Principal_Adapter.Tela_PrincipalViewHolder> {
    private List<Tela_Principal_Model> tela_principal_modelList;

    public Tela_Principal_Adapter(List<Tela_Principal_Model> tela_principal_modelList) {
        this.tela_principal_modelList = tela_principal_modelList;
    }

    @NonNull
    @Override
    public Tela_PrincipalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tela_principal_item, parent, false);
        return new Tela_Principal_Adapter.Tela_PrincipalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Tela_PrincipalViewHolder holder, int position) {
        Tela_Principal_Model tela_principal_model = tela_principal_modelList.get(position);
        holder.lugar.setText(tela_principal_model.getLugar());
        holder.endereco.setText(tela_principal_model.getEndereco());
    }

    @Override
    public int getItemCount() {
        return tela_principal_modelList.size();
    }

    static class Tela_PrincipalViewHolder extends RecyclerView.ViewHolder {
        TextView lugar;
        TextView endereco;


        public Tela_PrincipalViewHolder(@NonNull View itemView) {
            super(itemView);
            lugar = itemView.findViewById(R.id.lugar);
            endereco = itemView.findViewById(R.id.endereco);
        }
    }
}
