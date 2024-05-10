package com.example.mudafacil;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.app.AlertDialog;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Opcao_VeiculosAdapter extends RecyclerView.Adapter<Opcao_VeiculosAdapter.Opcao_VeiculosViewHolder> {
    private List<Opcao_VeiculosModel> opcao_veiculosModelList;
    private Context context;

    // Constructor que recebe a lista de veículos e o contexto
    public Opcao_VeiculosAdapter(List<Opcao_VeiculosModel> opcao_veiculosModelList, Context context) {
        this.opcao_veiculosModelList = opcao_veiculosModelList;
        this.context = context;
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

        // Configurando o listener para clique no item
        holder.itemView.setOnClickListener(v -> showCustomDialog(model));
    }

    @Override
    public int getItemCount() {
        return opcao_veiculosModelList.size();
    }

    // Método para mostrar o AlertDialog personalizado
    private void showCustomDialog(Opcao_VeiculosModel model) {
        // Inflar o layout personalizado
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.confirmarveiculo, null);

        // Criar o AlertDialog e definir o layout com o estilo transparente
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.TransparentDialog);
        builder.setView(dialogView);

        TextView message = dialogView.findViewById(R.id.dialog_message);
        message.setText("Tem certeza que deseja este veículo: " + model.getVeiculo() + "?");

        // Configurando botões
        Button btnYes = dialogView.findViewById(R.id.dialog_btn_yes);
        btnYes.setOnClickListener(v -> {
            // Ação para "Sim"
            // Por exemplo, fazer algo com o modelo ou fechar o diálogo
        });

        Button btnNo = dialogView.findViewById(R.id.dialog_btn_no);
        btnNo.setOnClickListener(v -> {
            // Ação para "Não"
        });

        AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT)); // Assegura a transparência
        dialog.show();
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
