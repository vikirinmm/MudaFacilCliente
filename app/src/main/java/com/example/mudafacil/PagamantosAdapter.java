package com.example.mudafacil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PagamantosAdapter extends RecyclerView.Adapter<PagamantosAdapter.PaymentViewHolder> {
    private List<PagamentosModel> pagamentosModelList;

    public PagamantosAdapter(List<PagamentosModel> pagamentosModelList) {
        this.pagamentosModelList = pagamentosModelList;
    }

    @NonNull
    @Override
    public PaymentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pagamentos_item, parent, false);
        return new PaymentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentViewHolder holder, int position) {
        PagamentosModel pagamentosModel = pagamentosModelList.get(position);
        holder.paymentAmountTextView.setText(pagamentosModel.getAmount());
        holder.paymentDateTextView.setText(pagamentosModel.getDate());
        holder.paymentDescriptionTextView.setText(pagamentosModel.getDescription());
    }

    @Override
    public int getItemCount() {
        return pagamentosModelList.size();
    }

    static class PaymentViewHolder extends RecyclerView.ViewHolder {
        TextView paymentAmountTextView;
        TextView paymentDateTextView;
        TextView paymentDescriptionTextView;

        public PaymentViewHolder(@NonNull View itemView) {
            super(itemView);
            paymentAmountTextView = itemView.findViewById(R.id.valor);
            paymentDateTextView = itemView.findViewById(R.id.data);
            paymentDescriptionTextView = itemView.findViewById(R.id.discricao);
        }
    }
}

