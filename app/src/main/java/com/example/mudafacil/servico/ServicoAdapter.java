package com.example.mudafacil.servico;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mudafacil.R;

import java.util.List;

public class ServicoAdapter extends RecyclerView.Adapter<ServicoAdapter.ServicoViewHolder> {
    private List<Servicomodel> servicomodelList;

    public ServicoAdapter(List<Servicomodel> servicomodelList) {
        this.servicomodelList = servicomodelList;
    }

    @NonNull
    @Override
    public ServicoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.servico_item, parent, false);
        return new ServicoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServicoViewHolder holder, int position) {
        Servicomodel servicomodel = servicomodelList.get(position);

        holder.data.setText(servicomodel.getData());
        holder.endereco.setText(servicomodel.getEndreco());
        holder.valor.setText(servicomodel.getValor());
        holder.lugar.setText(servicomodel.getLugar());
    }

    @Override
    public int getItemCount() {
        return servicomodelList.size();
    }

    static class ServicoViewHolder extends RecyclerView.ViewHolder {
        TextView valor;
        TextView data;
        TextView lugar;
        TextView endereco;

        public ServicoViewHolder(@NonNull View itemView) {
            super(itemView);
            valor = itemView.findViewById(R.id.valor);
            data = itemView.findViewById(R.id.data);
            lugar = itemView.findViewById(R.id.lugar);
            endereco = itemView.findViewById(R.id.endereco);

        }
    }
}

