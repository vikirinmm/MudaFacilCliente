package com.example.mudafacil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Opcao_VeiculosAdapter extends RecyclerView.Adapter<Opcao_VeiculosAdapter.Opcao_VeiculosViewHolder> {
    private List<Opcao_VeiculosModel> opcao_veiculosModelList;

    public Opcao_VeiculosAdapter(List<Opcao_VeiculosModel> opcao_veiculosModelList) {
        this.opcao_veiculosModelList = opcao_veiculosModelList;
    }

    @NonNull
    @Override
    public Opcao_VeiculosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.opcao_veiculos_item, parent, false);
        return new Opcao_VeiculosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Opcao_VeiculosViewHolder holder, int position) {
        Opcao_VeiculosModel model = opcao_veiculosModelList.get(position);
        holder.veiculo.setText(model.getVeiculo());
        holder.tempo.setText(model.getTempo());
        holder.valor.setText(model.getValor());
        holder.capacidade.setText(model.getCapacidade());
    }

    @Override
    public int getItemCount() {
        return opcao_veiculosModelList.size();
    }

    static class Opcao_VeiculosViewHolder extends RecyclerView.ViewHolder {
        TextView tempo, capacidade, valor, veiculo;

        public Opcao_VeiculosViewHolder(@NonNull View itemView) {
            super(itemView);
            tempo = itemView.findViewById(R.id.tempo);
            capacidade = itemView.findViewById(R.id.capacidade);
            valor = itemView.findViewById(R.id.valor);
            veiculo = itemView.findViewById(R.id.veiculo);
        }
    }
}
