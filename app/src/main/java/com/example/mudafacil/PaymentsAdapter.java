package com.example.mudafacil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PaymentsAdapter extends RecyclerView.Adapter<PaymentsAdapter.PaymentViewHolder> {
    private List<Payment> paymentList;

    public PaymentsAdapter(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @NonNull
    @Override
    public PaymentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_item, parent, false);
        return new PaymentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentViewHolder holder, int position) {
        Payment payment = paymentList.get(position);
        holder.paymentAmountTextView.setText(payment.getAmount());
        holder.paymentDateTextView.setText(payment.getDate());
        holder.paymentDescriptionTextView.setText(payment.getDescription());
    }

    @Override
    public int getItemCount() {
        return paymentList.size();
    }

    static class PaymentViewHolder extends RecyclerView.ViewHolder {
        TextView paymentAmountTextView;
        TextView paymentDateTextView;
        TextView paymentDescriptionTextView;

        public PaymentViewHolder(@NonNull View itemView) {
            super(itemView);
            paymentAmountTextView = itemView.findViewById(R.id.text_view_payment_amount);
            paymentDateTextView = itemView.findViewById(R.id.text_view_payment_date);
            paymentDescriptionTextView = itemView.findViewById(R.id.text_view_payment_description);
        }
    }
}

