package com.liveo.principal.clientes;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.liveo.R;

import java.util.ArrayList;

/**
 * Created by MiPc on 15/07/2014.
 */
public class ClienteDtoAdapter extends BaseAdapter
{
    protected Activity activity;
    LayoutInflater layoutInflater;
    protected ArrayList<ClienteDTO> items;

    public ClienteDtoAdapter(Activity activity, ArrayList<ClienteDTO> items) {
        this.activity = activity;
        this.items = items;
    }

    public ClienteDtoAdapter(LayoutInflater layoutInflater, ArrayList<ClienteDTO> items) {
        this.layoutInflater = layoutInflater;
        this.items = items;
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int position)
    {
        //return items.get(position).getId();
        return  1;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Generamos una convertView por motivos de eficiencia
        View v = convertView;

        v = layoutInflater.inflate(R.layout.clientes_lista_item, null);

        // Creamos un objeto directivo
        ClienteDTO clienteDTO = items.get(position);

        TextView nombreClienteTextView = (TextView) v.findViewById(R.id.nombreClienteTextView);
        nombreClienteTextView.setText(clienteDTO.getNombreCliente());

        TextView numeroClienteTextView = (TextView) v.findViewById(R.id.numeroClienteTextView);
        numeroClienteTextView.setText(clienteDTO.getNumeroCliente());

        TextView identificacionClienteTextView = (TextView) v.findViewById(R.id.datosBasicosTextView);
        identificacionClienteTextView.setText(clienteDTO.getIdentificacion());

        TextView tipoIdentificacionTextView = (TextView) v.findViewById(R.id.tipoIdentificacionTextView);
        tipoIdentificacionTextView.setText(clienteDTO.getTipoIdentificacion());

                // Retornamos la vista
        return v;
    }
}
