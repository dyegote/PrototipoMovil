package com.liveo.principal.clientes;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.liveo.R;


public class ClienteActivity extends ActionBarActivity
{
    View datosSolicitudView;
    View datosGeneralesView;
    LayoutInflater inflater;
    TextView nombreClientTextView;
    View tabDatosGenerales;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clientes_cliente_activity);

        this.ValidaNuevoCliente();

    }


    public void  OnClickBuscarCliente(View v)
    {
        //Implementar eventos en botones http://developer.android.com/guide/topics/ui/controls/button.html
        Toast.makeText(this, "Buscar Cliente", Toast.LENGTH_SHORT).show();
        DialogFragment dialogo = new ClienteListaDialogFragment();
        dialogo.show(getFragmentManager(),"ClienteListaDialogFragment");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_solicitud_maestro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();
        //if (id == R.id.action_settings) {
        //    return true;
        //}
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.menu_orden_pago:
                Toast.makeText(this, "Geneeración Orden de Pago Datacredito", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_data_credito:
                Toast.makeText(this, "Consulta Datacredito", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void ValidaNuevoCliente()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View layout = inflater.inflate(R.layout.clientes_valida_cliente, null);

        Spinner tipoIdentificacionSpinner = (Spinner)layout.findViewById(R.id.tipoIdentificacionSpinner);

        final String[] nombrestipoIdentificacion = new String[]
                {
                        "Ceduala",
                        "NIT"
                };

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nombrestipoIdentificacion);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        tipoIdentificacionSpinner.setAdapter(adaptador);


        builder.setView(layout);
        builder.setTitle("CLIENTE");
        //builder.setIcon(R.drawable.ic_login);
        builder.setCancelable(false);

        builder.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }

}
