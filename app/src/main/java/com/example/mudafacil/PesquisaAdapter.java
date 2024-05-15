package com.example.mudafacil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PesquisaAdapter extends RecyclerView.Adapter<PesquisaAdapter.ViewHolder> {

    private List<PesquisaItem> pesquisaItems;

    public PesquisaAdapter(List<PesquisaItem> pesquisaItems) {
        this.pesquisaItems = pesquisaItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pesquisa, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PesquisaItem item = pesquisaItems.get(position);
        holder.titulo.setText(item.getTitulo());
    }

    @Override
    public int getItemCount() {
        return pesquisaItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titulo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.titulo_pesquisa);
        }
    }
}
