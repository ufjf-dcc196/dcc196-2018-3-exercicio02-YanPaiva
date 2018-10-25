package com.example.yan.exercicio02_yan;


import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import Model.Seriado;

class SeriadoAdapter extends RecyclerView.Adapter<SeriadoAdapter.ViewHolder>{
    private Cursor cursor;

    public SeriadoAdapter(Cursor cursor) {
        this.cursor = cursor;
    }

    public void setCursor(Cursor c){
        cursor = c;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View seriadoView = inflater.inflate(R.layout.seriado_layout, parent, false);
        ViewHolder holder = new ViewHolder(seriadoView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Seriado serie = new Seriado();
        int idxNomeSeriado = cursor.getColumnIndexOrThrow(SeriadoContract.SeriadoBD.COLUMN_NAME_NOME);
        int idxIdSeriado = cursor.getColumnIndexOrThrow(SeriadoContract.SeriadoBD._ID);
        cursor.moveToPosition(position);
        holder.txtNome.setText(cursor.getString(idxNomeSeriado));
        holder.txtId.setText(cursor.getString(idxIdSeriado));

    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txtNome;
        public TextView txtId;

        public ViewHolder(View itemView) {
            super(itemView);
            txtId = itemView.findViewById(R.id.txtIdSeriado);
            txtNome = itemView.findViewById(R.id.txtSeriado);
        }
    }
}
