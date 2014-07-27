package com.liveo.principal.credito;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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
import com.liveo.principal.clientes.ClienteActivity;
import com.liveo.principal.clientes.ClienteDTO;
import com.liveo.principal.clientes.ClienteListaDialogFragment;


public class SolicitudMaestroActivity extends ActionBarActivity implements ClienteListaDialogFragment.ClienteListaDialogListener
{
    View datosSolicitudView;
    View datosGeneralesView;
    LayoutInflater inflater;
    TextView nombreClientTextView;
    View tabDatosGenerales;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credito_solicitud_maestro_activity);

        inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        datosSolicitudView = inflater.inflate(R.layout.credito_solicitud_maestro_datos_solicitud_tab, null);
        datosGeneralesView = inflater.inflate(R.layout.credito_solicitud_maestro_datos_generales_tab,null);


        InicializarPestanias();
        CargarListaAsesores();
        CargarListaTipoProducto();
        CargarListaDestinoCredito();
        CargarListaNombreComercial();
        CargarListaTipoTablaPago();
        CargarListaFrecuenciaPago();

        tabDatosGenerales = findViewById(R.id.tabDatosGenerales);
        nombreClientTextView = (TextView)tabDatosGenerales.findViewById(R.id.nombreDelClienteTextView);
        nombreClientTextView.setText("");



      //  nombreClientTextView = (EditText)datosGeneralesView.findViewById(R.id.nombreDelClienteTextView);
       // nombreClientTextView.setText("ffffffff");
    }

    private void InicializarPestanias()
    {
        Resources res = getResources();



        TabHost tabs=(TabHost)findViewById(R.id.tabHost3);
        tabs.setup();

        TabHost.TabSpec spec = null;

        spec=tabs.newTabSpec("soicitud");
        spec.setContent(R.id.tabDatosSoliciud);
        spec.setIndicator("DATOS SOICITUD");
        tabs.addTab(spec);

        spec=tabs.newTabSpec("TAB2");
        spec.setContent(R.id.tabDatosGenerales);
        spec.setIndicator("DATOS GENERALES");
        tabs.addTab(spec);


        tabs.setCurrentTab(0);

    }

    private void CargarListaAsesores()
    {
        //Spinner asesoresSpinner = (Spinner)datosSolicitudView.findViewById(R.id.spinnerAsesores);
        Spinner asesoresSpinner = (Spinner)findViewById(R.id.spinnerAsesores);

        final String[] nombresAsesores = new String[]
                {
                        "AGUIRRE BASTIDAS EFRAIN",
                        "ALPALA PATIÑO LUISA FERNANDA",
                        "ANAYA TRUJILLO EDWIN",
                        "ARROYO LOPEZ ANA  LUISA",
                        "ASTUDILLO ROJAS ANYERSON",
                        "ATAHUALPA LASSO CAROLINA",
                        "BASTIDAS DELGADO ANGELA ANDREA",
                        "BENAVIDES SANCHEZ ANA CRISTINA"
                };

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nombresAsesores);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        asesoresSpinner.setAdapter(adaptador);
    }

    private void CargarListaTipoProducto()
    {
        //Spinner asesoresSpinner = (Spinner)datosSolicitudView.findViewById(R.id.spinnerAsesores);
        Spinner tipoProductoSpinner = (Spinner)findViewById(R.id.spinnerTipoProducto);

        final String[] nombresAsesores = new String[]
                {
                        "MICROCREDITO (INDIVIDUAL)",
                        "CREDITO COMERCIAL",
                        "CREDTO ADICIONAL",
                        "LIBRANZA",
                        "MICROCREDITO (GRUPAL)",
                        "MICRCREDITO (PADEMER"
                };

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nombresAsesores);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        tipoProductoSpinner.setAdapter(adaptador);
    }

    private void CargarListaDestinoCredito()
    {
        //Spinner asesoresSpinner = (Spinner)datosSolicitudView.findViewById(R.id.spinnerAsesores);
        Spinner destinoCreditoSpinner = (Spinner)findViewById(R.id.spinnerDestinoCredito);

        final String[] nombresDestinoCredito = new String[]
                {
                        "MICROCREDITO - CAPITAL DE TRABAJO",
                        "MICROCREDITO - CAPITAL DE TRABAJO",
                        "MICROCREDITO - ACTIVO FIJO",
                        "MICROCREDITO - MEJORA DE VIVIENDA",
                        "MICROCREDITO - CRÉDITO DE CONSUMO",
                        "MICROCREDITO - CRÉDITO DE EDUCATIVO"
                };

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nombresDestinoCredito);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        destinoCreditoSpinner.setAdapter(adaptador);
    }

    private void CargarListaNombreComercial()
    {
        //Spinner asesoresSpinner = (Spinner)datosSolicitudView.findViewById(R.id.spinnerAsesores);
        Spinner nombreComercialSpinner = (Spinner)findViewById(R.id.spinnerNombreComercial);

        final String[] nombresComerciales = new String[]
                {
                        "CONSUNEGOCIO",
                        "CONSUCAMPO",
                        "CONSUTRANSPORTE",
                        "CONSUEDUCACION",
                        "CONSUBIENESTAR"
                };

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nombresComerciales);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        nombreComercialSpinner.setAdapter(adaptador);
    }

    private void CargarListaTipoTablaPago()
    {
        //Spinner asesoresSpinner = (Spinner)datosSolicitudView.findViewById(R.id.spinnerAsesores);
        Spinner tipoTablaPagoSpinner = (Spinner)findViewById(R.id.spinnerTipoTablaPagos);

        final String[] nombresTipoTablaPago = new String[]
                {
                        "C.Fija - DiaFijo - Con Alicuota"
                };

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nombresTipoTablaPago);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        tipoTablaPagoSpinner.setAdapter(adaptador);
    }

    private void CargarListaFrecuenciaPago()
    {
        //Spinner asesoresSpinner = (Spinner)datosSolicitudView.findViewById(R.id.spinnerAsesores);
        Spinner frecuenciaPagoSpinner = (Spinner)findViewById(R.id.spinnerFrecuenciaPago);

        final String[] nombresTipoTablaPago = new String[]
                {
                        "Mensual",
                        "Bimensual",
                        "Trimestral",
                        "Semestral"
                };

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nombresTipoTablaPago);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        frecuenciaPagoSpinner.setAdapter(adaptador);
    }


    private void AbrirDatacredito()
    {
        String pathArchivo =  Environment.getExternalStorageDirectory().getAbsolutePath() + "/contactar/";

        Uri file= Uri.parse(pathArchivo + "datacredito.pdf");

        String mimeType =  MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(file.toString()));

        try{

            Intent i;
            i = new Intent(Intent.ACTION_VIEW);
            i.setDataAndType(file,mimeType);
            startActivity(i);

        }catch (ActivityNotFoundException e) {
            Toast.makeText(this,
                    "No se encontro ninguna apicacion disponible para abrir archivo pdf",
                    Toast.LENGTH_SHORT).show();
        }
    }


    public void  OnClickBuscarCliente(View v)
    {
        //Implementar eventos en botones http://developer.android.com/guide/topics/ui/controls/button.html
        Toast.makeText(this, "Buscar Cliente", Toast.LENGTH_SHORT).show();
        DialogFragment dialogo = new ClienteListaDialogFragment();
        dialogo.show(getFragmentManager(),"ClienteListaDialogFragment");
    }

    public void  OnClickNuevoCliente(View v)
    {
        //Implementar eventos en botones http://developer.android.com/guide/topics/ui/controls/button.html
        Toast.makeText(this, "Nuevo cliente", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(),ClienteActivity.class);
        this.startActivity(intent);

        //this.ValidaNuevoCliente();
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
                this.AbrirDatacredito();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    //Metodos del dialogo ClienteLstaDialogFragment para capturar el objeto seleccionado de la lista
    @Override
    public void  onSeleccionCliente(ClienteDTO inputClienteDTO)
    {

        nombreClientTextView.setText(inputClienteDTO.getNombreCliente());
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
