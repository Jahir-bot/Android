package com.example.apptiendavirtual.Adaptadores;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptiendavirtual.ActividadCliente;
import com.example.apptiendavirtual.ActividadTodosLosPedidos;
import com.example.apptiendavirtual.BaseDeDatos.BaseDatos_pmdm;
import com.example.apptiendavirtual.R;

import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class RecyclerViewAdapterTodosLosPedidos extends RecyclerView.Adapter<RecyclerViewAdapterTodosLosPedidos.DatosTodosPedidosViewHolder> {
    private List<DatosVerPedidos> items;
    private BaseDatos_pmdm baseDatos;
    private SQLiteDatabase operacionesBD;


    public static class DatosTodosPedidosViewHolder extends RecyclerView.ViewHolder {
        TextView pedido;
        TextView direccion;
        TextView nPedido;
        Button confirmar;
        Button rechazar;
        String categoria;
        String producto;
        int cantidad;
        String idCliente;
        String direccion2;
        String ciudad;
        String cp;
        public DatosTodosPedidosViewHolder(View v) {
            super(v);
            pedido = (TextView) v.findViewById(R.id.pedido);
            direccion = (TextView) v.findViewById(R.id.direccion);
            nPedido = (TextView) v.findViewById(R.id.textView21);
            confirmar = (Button) v.findViewById(R.id.button13);
            rechazar = (Button) v.findViewById(R.id.button14);

            confirmar.setOnClickListener(new View.OnClickListener() {
                private BaseDatos_pmdm baseDatos;
                private SQLiteDatabase operacionesBD;
                @Override
                public void onClick(View v) {
                    if (baseDatos==null){
                        baseDatos = new BaseDatos_pmdm(v.getContext());
                        operacionesBD = baseDatos.getWritableDatabase();
                        baseDatos.asigarSQLiteDatabase(operacionesBD);
                    }

                    String indice = nPedido.getText().toString();
                    ContentValues nuevoRegistro = new ContentValues();
                    nuevoRegistro.put("indicePedido", indice);
                    String condicionwhere = "_id=?";
                    String[] parametros = new String[]{String.valueOf(0)};
                    operacionesBD.update("NPedido",nuevoRegistro,condicionwhere,parametros);
                    Cursor cursor = operacionesBD.rawQuery("select d.direccion, d.ciudad, d.cp," +
                            " p.categoria, p.producto, p.cantidad, d.idCliente, d._id, p._id, n.indicePedido " +
                            "from Direcciones d, Pedidos p, NPedido n " +
                            " where d._id=p._id and d._id = n.indicePedido and p._id = n.indicePedido", null);
                    if (cursor.moveToFirst()) {
                        while (!cursor.isAfterLast()) {
                            direccion2 =cursor.getString(0);
                            ciudad =cursor.getString(1);
                            cp =cursor.getString(2);
                            categoria =cursor.getString(3);
                            producto =cursor.getString(4);
                            cantidad =cursor.getInt(5);
                            idCliente = cursor.getString(6);
                            cursor.moveToNext();
                        }
                    }
                    ContentValues nuevoRegistro2 = new ContentValues();
                    nuevoRegistro2.put("_id", indice);
                    nuevoRegistro2.put("categoria", categoria);
                    nuevoRegistro2.put("producto", producto);
                    nuevoRegistro2.put("cantidad", cantidad);
                    nuevoRegistro2.put("direccion", direccion2);
                    nuevoRegistro2.put("ciudad", ciudad);
                    nuevoRegistro2.put("cp", cp);
                    nuevoRegistro2.put("idCliente", idCliente);
                    operacionesBD.insert("Confirmados", null, nuevoRegistro2);
                    String condicionwhere2 = "_id=?";
                    String[] parametros2 = new String[]{String.valueOf(indice)};
                    operacionesBD.delete("Pedidos",condicionwhere2,parametros2);
                    operacionesBD.delete("Direcciones",condicionwhere2,parametros2);
                    Toast.makeText(v.getContext(),"El pedido nº " + indice + " ha sido confirmado.",Toast.LENGTH_SHORT).show();
                }
            });
            rechazar.setOnClickListener(new View.OnClickListener() {
                private BaseDatos_pmdm baseDatos;
                private SQLiteDatabase operacionesBD;
                @Override
                public void onClick(View v) {
                    if (baseDatos==null){
                        baseDatos = new BaseDatos_pmdm(v.getContext());
                        operacionesBD = baseDatos.getWritableDatabase();
                        baseDatos.asigarSQLiteDatabase(operacionesBD);
                    }
                    String indice = nPedido.getText().toString();
                    ContentValues nuevoRegistro = new ContentValues();
                    nuevoRegistro.put("indicePedido", indice);
                    String condicionwhere = "_id=?";
                    String[] parametros = new String[]{String.valueOf(0)};
                    operacionesBD.update("NPedido",nuevoRegistro,condicionwhere,parametros);
                    Cursor cursor = operacionesBD.rawQuery("select d.direccion, d.ciudad, d.cp," +
                            " p.categoria, p.producto, p.cantidad, d.idCliente, d._id, p._id, n.indicePedido " +
                            "from Direcciones d, Pedidos p, NPedido n " +
                            " where d._id=p._id and d._id = n.indicePedido and p._id = n.indicePedido", null);
                    if (cursor.moveToFirst()) {
                        while (!cursor.isAfterLast()) {
                            direccion2 =cursor.getString(0);
                            ciudad =cursor.getString(1);
                            cp =cursor.getString(2);
                            categoria =cursor.getString(3);
                            producto =cursor.getString(4);
                            cantidad =cursor.getInt(5);
                            idCliente = cursor.getString(6);
                            cursor.moveToNext();
                        }
                    }
                    ContentValues nuevoRegistro2 = new ContentValues();
                    nuevoRegistro2.put("_id", indice);
                    nuevoRegistro2.put("categoria", categoria);
                    nuevoRegistro2.put("producto", producto);
                    nuevoRegistro2.put("cantidad", cantidad);
                    nuevoRegistro2.put("direccion", direccion2);
                    nuevoRegistro2.put("ciudad", ciudad);
                    nuevoRegistro2.put("cp", cp);
                    nuevoRegistro2.put("idCliente", idCliente);
                    operacionesBD.insert("Rechazados", null, nuevoRegistro2);
                    String condicionwhere2 = "_id=?";
                    String[] parametros2 = new String[]{String.valueOf(indice)};
                    operacionesBD.delete("Pedidos",condicionwhere2,parametros2);
                    operacionesBD.delete("Direcciones",condicionwhere2,parametros2);
                    Toast.makeText(v.getContext(),"El pedido nº " + indice + " ha sido rechazado.",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public RecyclerViewAdapterTodosLosPedidos(List<DatosVerPedidos> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @NonNull
    @Override
    public DatosTodosPedidosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout_ver_todos_los_pedidos, viewGroup, false);
        return new DatosTodosPedidosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DatosTodosPedidosViewHolder viewHolder, int i) {
        viewHolder.pedido.setText("Pedido: "+String.valueOf(items.get(i).getPedido()));
        viewHolder.direccion.setText("Dirección: "+String.valueOf(items.get(i).getDireccion()));
        viewHolder.nPedido.setText(String.valueOf(items.get(i).getNPedido()));
    }
}
