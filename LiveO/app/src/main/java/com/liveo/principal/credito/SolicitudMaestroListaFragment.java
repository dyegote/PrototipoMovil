package com.liveo.principal.credito;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.liveo.R;
import com.liveo.principal.utilidades.Menus;


import java.util.ArrayList;

public class SolicitudMaestroListaFragment extends Fragment
{
    public static final String ESTADO_SOLICITUD = "";

    ListView listView;
    private boolean searchCheck;
    Fragment fragment;
    View solicitudMaestroListaView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        solicitudMaestroListaView = inflater.inflate(R.layout.credito_solicitud_maestro_lista_fragment, container, false);

        listView = (ListView)solicitudMaestroListaView.findViewById(R.id.solicitudMaestroListView);

        String estadoSolicitud = getArguments().getString(ESTADO_SOLICITUD);

        fragment = this;

        if(estadoSolicitud.compareTo("ingresada") == 0)
            CargarSolicitudesEstadoIngresada(inflater);
        if(estadoSolicitud.compareTo("pendiente") == 0)
            CargarSolicitudesEstadoPendiente(inflater);
        if(estadoSolicitud.compareTo("digitacion") == 0)
            CargarSolicitudesEstadoDigitacion(inflater);
        if(estadoSolicitud.compareTo("verificada") == 0)
            CargarSolicitudesEstadoVerificada(inflater);
        if(estadoSolicitud.compareTo("calificada") == 0)
            CargarSolicitudesEstadoCalificada(inflater);

        listView.setOnItemClickListener(new ListViewSlicitudMaestroItemClickListener());

        solicitudMaestroListaView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT ));
        return solicitudMaestroListaView;
    }

    private void CargarSolicitudesEstadoIngresada(LayoutInflater inflater)
    {
        ArrayList<SolicitudMaestroDTO> solicitudMaestroArrayList = new ArrayList<SolicitudMaestroDTO>();
        SolicitudMaestroDTO solicitudMaestroDTO;

        solicitudMaestroDTO = new SolicitudMaestroDTO("10001","10-Junio-2014","1085891123","Diego Armando Tobar Ibarrra","1.000.000","Pasto Centro");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("10002","11-Junio-2014","1085891124","Cristian Javier Hernandez","1.100.000","Pasto Centro");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("10003","12-Junio-2014","1085891125","Juan Jose Ramirez","1.200.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("10004","12-Junio-2014","1085891126","Juan Fernando Rodriguez","200.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("10005","12-Junio-2014","1085891127","Juan Fernando Ramirez","20.000.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("10006","12-Junio-2014","1085891128","Juan Carlos Gonzalez","20.000.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("10007","12-Junio-2014","1085891130","Pedro Daniel Mora","20.000.000","Ipiales");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("10008","12-Junio-2014","1085891127","Luis Alberto Erazo","20.000.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);

        // Creo el adapter personalizado
        SolicitudMaestroDtoAdapter adapter = new SolicitudMaestroDtoAdapter(inflater, solicitudMaestroArrayList);

        // Lo aplico
        listView.setAdapter(adapter);
    }

    private void CargarSolicitudesEstadoPendiente(LayoutInflater inflater)
    {
        ArrayList<SolicitudMaestroDTO> solicitudMaestroArrayList = new ArrayList<SolicitudMaestroDTO>();
        SolicitudMaestroDTO solicitudMaestroDTO;

        solicitudMaestroDTO = new SolicitudMaestroDTO("20001","10-Junio-2014","1085891123","Diego Armando Tobar Ibarrra","1.000.000","Pasto Centro");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("20002","11-Junio-2014","1085891124","Cristian Javier Hernandez","1.100.000","Pasto Centro");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("20003","12-Junio-2014","1085891125","Juan Jose Ramirez","1.200.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("20004","12-Junio-2014","1085891126","Juan Fernando Rodriguez","200.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("20005","12-Junio-2014","1085891127","Juan Fernando Ramirez","20.000.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("20006","12-Junio-2014","1085891128","Juan Carlos Gonzalez","20.000.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("20007","12-Junio-2014","1085891130","Pedro Daniel Mora","20.000.000","Ipiales");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("20008","12-Junio-2014","1085891127","Luis Alberto Erazo","20.000.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);

        // Creo el adapter personalizado
        SolicitudMaestroDtoAdapter adapter = new SolicitudMaestroDtoAdapter(inflater, solicitudMaestroArrayList);

        // Lo aplico
        listView.setAdapter(adapter);
    }

    private void CargarSolicitudesEstadoDigitacion(LayoutInflater inflater)
    {
        ArrayList<SolicitudMaestroDTO> solicitudMaestroArrayList = new ArrayList<SolicitudMaestroDTO>();
        SolicitudMaestroDTO solicitudMaestroDTO;

        solicitudMaestroDTO = new SolicitudMaestroDTO("30001","10-Junio-2014","1085891123","Diego Armando Tobar Ibarrra","1.000.000","Pasto Centro");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("30002","11-Junio-2014","1085891124","Cristian Javier Hernandez","1.100.000","Pasto Centro");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("30003","12-Junio-2014","1085891125","Juan Jose Ramirez","1.200.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("30004","12-Junio-2014","1085891126","Juan Fernando Rodriguez","200.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("30005","12-Junio-2014","1085891127","Juan Fernando Ramirez","20.000.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("30006","12-Junio-2014","1085891128","Juan Carlos Gonzalez","20.000.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("30007","12-Junio-2014","1085891130","Pedro Daniel Mora","20.000.000","Ipiales");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("30008","12-Junio-2014","1085891127","Luis Alberto Erazo","20.000.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);

        // Creo el adapter personalizado
        SolicitudMaestroDtoAdapter adapter = new SolicitudMaestroDtoAdapter(inflater, solicitudMaestroArrayList);

        // Lo aplico
        listView.setAdapter(adapter);
    }

    private void CargarSolicitudesEstadoVerificada(LayoutInflater inflater)
    {
        ArrayList<SolicitudMaestroDTO> solicitudMaestroArrayList = new ArrayList<SolicitudMaestroDTO>();
        SolicitudMaestroDTO solicitudMaestroDTO;

        solicitudMaestroDTO = new SolicitudMaestroDTO("40001","10-Junio-2014","1085891123","Diego Armando Tobar Ibarrra","1.000.000","Pasto Centro");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("40002","11-Junio-2014","1085891124","Cristian Javier Hernandez","1.100.000","Pasto Centro");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("40003","12-Junio-2014","1085891125","Juan Jose Ramirez","1.200.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("40004","12-Junio-2014","1085891126","Juan Fernando Rodriguez","200.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("40005","12-Junio-2014","1085891127","Juan Fernando Ramirez","20.000.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("40006","12-Junio-2014","1085891128","Juan Carlos Gonzalez","20.000.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("40007","12-Junio-2014","1085891130","Pedro Daniel Mora","20.000.000","Ipiales");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("40008","12-Junio-2014","1085891127","Luis Alberto Erazo","20.000.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);

        // Creo el adapter personalizado
        SolicitudMaestroDtoAdapter adapter = new SolicitudMaestroDtoAdapter(inflater, solicitudMaestroArrayList);

        // Lo aplico
        listView.setAdapter(adapter);
    }

    private void CargarSolicitudesEstadoCalificada(LayoutInflater inflater)
    {
        ArrayList<SolicitudMaestroDTO> solicitudMaestroArrayList = new ArrayList<SolicitudMaestroDTO>();
        SolicitudMaestroDTO solicitudMaestroDTO;

        solicitudMaestroDTO = new SolicitudMaestroDTO("50001","10-Junio-2014","1085891123","Diego Armando Tobar Ibarrra","1.000.000","Pasto Centro");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("50002","11-Junio-2014","1085891124","Cristian Javier Hernandez","1.100.000","Pasto Centro");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("50003","12-Junio-2014","1085891125","Juan Jose Ramirez","1.200.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("50004","12-Junio-2014","1085891126","Juan Fernando Rodriguez","200.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("50005","12-Junio-2014","1085891127","Juan Fernando Ramirez","20.000.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("50006","12-Junio-2014","1085891128","Juan Carlos Gonzalez","20.000.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("50007","12-Junio-2014","1085891130","Pedro Daniel Mora","20.000.000","Ipiales");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);
        solicitudMaestroDTO = new SolicitudMaestroDTO("50008","12-Junio-2014","1085891127","Luis Alberto Erazo","20.000.000","Fatima");
        solicitudMaestroArrayList.add(solicitudMaestroDTO);

        // Creo el adapter personalizado
        SolicitudMaestroDtoAdapter adapter = new SolicitudMaestroDtoAdapter(inflater, solicitudMaestroArrayList);

        // Lo aplico
        listView.setAdapter(adapter);


    }

    private class ListViewSlicitudMaestroItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int posicion, long id) {

            SolicitudMaestroDTO solicitudMaestroDTO = (SolicitudMaestroDTO)parent.getItemAtPosition(posicion);

            Toast.makeText(view.getContext(), solicitudMaestroDTO.getNumeroSolicitud(), Toast.LENGTH_SHORT).show();

            //TODO: VER http://developer.android.com/training/basics/firstapp/starting-activity.html

            Intent intent = new Intent(fragment.getActivity().getApplicationContext(),SolicitudMaestroActivity.class);

            getActivity().startActivity(intent);

            getActivity().overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(Menus.SEARCH));
        searchView.setQueryHint(this.getString(R.string.search));

        ((EditText)searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text))
                .setHintTextColor(getResources().getColor(R.color.white));
        searchView.setOnQueryTextListener(OnQuerySearchView);

        menu.findItem(Menus.ADD).setVisible(true);
        menu.findItem(Menus.UPDATE).setVisible(true);
        menu.findItem(Menus.SEARCH).setVisible(true);

        searchCheck = false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub

        switch (item.getItemId()) {

            case Menus.ADD:
                break;

            case Menus.UPDATE:
                break;

            case Menus.SEARCH:
                searchCheck = true;
                break;
        }
        return true;
    }

    private SearchView.OnQueryTextListener OnQuerySearchView = new SearchView.OnQueryTextListener() {

        @Override
        public boolean onQueryTextSubmit(String arg0) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean onQueryTextChange(String arg0) {
            // TODO Auto-generated method stub
            if (searchCheck){
                // implement your search here
            }
            return false;
        }
    };
}
