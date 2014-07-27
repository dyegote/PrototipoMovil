package com.liveo.principal.clientes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import com.liveo.R;
import com.liveo.principal.credito.SolicitudMaestroDTO;
import com.liveo.principal.credito.SolicitudMaestroDtoAdapter;

import java.util.ArrayList;

/**
 * Created by MiPc on 15/07/2014.
 */
public class ClienteListaDialogFragment extends DialogFragment
{
    ListView listView;
    private boolean searchCheck;
    Fragment fragment;

    //TODO: pARA RETORNAR VALOR A LA ACTIVITY QUE CREO EL DIALOGO
    //http://developer.android.com/guide/topics/ui/dialogs.html#ShowingADialog
    //http://android-developers.blogspot.com/2012/05/using-dialogfragments.html
    public interface ClienteListaDialogListener {
        void onSeleccionCliente(ClienteDTO inputClienteDTO);
    }


    /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {



        View clienteListaView = inflater.inflate(R.layout.clientes_lista_fragment, container, false);
        getDialog().setTitle("Clientes");


        listView = (ListView)clienteListaView.findViewById(R.id.solicitudMaestroListView);


        //fragment = this;

        this.CargarListaClientes(inflater);

        return clienteListaView;
    }*/

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Build the dialog and set up the button click handlers



        LayoutInflater inflater = getActivity().getLayoutInflater();

        View clienteListaView = inflater.inflate(R.layout.clientes_lista_fragment, null);
        listView = (ListView)clienteListaView.findViewById(R.id.solicitudMaestroListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long id)
            {
                //retornar objeto seleccionado a la activity que creo el dialogo
                ClienteDTO clienteDTO = (ClienteDTO)parent.getItemAtPosition(position);
                ClienteListaDialogListener clientDialogListener = (ClienteListaDialogListener)getActivity();
                clientDialogListener.onSeleccionCliente(clienteDTO);
                getDialog().dismiss();
            }
        });

        //fragment = this;

        this.CargarListaClientes(inflater);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.drawable.ic_client);
        builder.setView(clienteListaView);
        builder.setTitle("CLIENTES");

        return builder.create();


    }





    private void CargarListaClientes(LayoutInflater inflater)
    {
        ArrayList<ClienteDTO> clienteArrayList = new ArrayList<ClienteDTO>();
        ClienteDTO clienteDTO;

        clienteDTO = new ClienteDTO("Diego Armando Tobar","10851234560","12345","Cedula");
        clienteArrayList.add(clienteDTO);
        clienteDTO = new ClienteDTO("Juan David Velasco","10851234560","12345","Cedula");
        clienteArrayList.add(clienteDTO);
        clienteDTO = new ClienteDTO("Gustavo Fernando Coral","10851234560","12345","Cedula");
        clienteArrayList.add(clienteDTO);
        clienteDTO = new ClienteDTO("Ivan Dario Sarchi","10851234560","12345","Cedula");
        clienteArrayList.add(clienteDTO);
        clienteDTO = new ClienteDTO("Carlos Alberto Soto","10851234560","12345","Cedula");
        clienteArrayList.add(clienteDTO);
        clienteDTO = new ClienteDTO("Jorge Ernesto Montenegro","10851234560","12345","Cedula");
        clienteArrayList.add(clienteDTO);
        clienteDTO = new ClienteDTO("Jose Fernando Rodriguez","10851234560","12345","Cedula");
        clienteArrayList.add(clienteDTO);
        clienteDTO = new ClienteDTO("Juan Carlos Ramirez","10851234560","12345","Cedula");
        clienteArrayList.add(clienteDTO);
        clienteDTO = new ClienteDTO("Marcelo Alejandro Ibarra","10851234560","12345","Cedula");
        clienteArrayList.add(clienteDTO);


        // Creo el adapter personalizado
        ClienteDtoAdapter adapter = new ClienteDtoAdapter(inflater, clienteArrayList);

        // Lo aplico
        listView.setAdapter(adapter);
    }
}
