package com.liveo.principal.credito;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.liveo.R;
import java.util.ArrayList;

public class SolicitudMaestroDtoAdapter extends BaseAdapter
{
    protected Activity activity;
    LayoutInflater layoutInflater;
    protected ArrayList<SolicitudMaestroDTO> items;

    public SolicitudMaestroDtoAdapter(Activity activity, ArrayList<SolicitudMaestroDTO> items) {
        this.activity = activity;
        this.items = items;
    }

    public SolicitudMaestroDtoAdapter(LayoutInflater layoutInflater, ArrayList<SolicitudMaestroDTO> items) {
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

        v = layoutInflater.inflate(R.layout.credito_solicitud_maestro_lista_item, null);

        // Creamos un objeto directivo
        SolicitudMaestroDTO solicitudMaestroDTO = items.get(position);

        TextView numeroSolicitudTextView = (TextView) v.findViewById(R.id.numeroSolicitudTextView);
        numeroSolicitudTextView.setText(solicitudMaestroDTO.getNumeroSolicitud());

        TextView fechaTextView = (TextView) v.findViewById(R.id.fechaTextView);
        fechaTextView.setText(solicitudMaestroDTO.getFechaIngreso());

        TextView identificacionTextView = (TextView) v.findViewById(R.id.datosBasicosTextView);
        identificacionTextView.setText(solicitudMaestroDTO.getIdentificacionCliente());

        TextView nombreTextView = (TextView) v.findViewById(R.id.nombreClienteTextView);
        nombreTextView.setText(solicitudMaestroDTO.getNombreCliente());

        TextView montoTextView = (TextView) v.findViewById(R.id.montoTextView);
        montoTextView.setText(solicitudMaestroDTO.getMonto());

        TextView oficinaTextView = (TextView) v.findViewById(R.id.oficinaTextView);
        oficinaTextView.setText(solicitudMaestroDTO.getOficina());

        // Retornamos la vista
        return v;
    }
}
