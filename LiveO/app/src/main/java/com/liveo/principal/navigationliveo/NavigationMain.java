
package com.liveo.principal.navigationliveo;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.liveo.R;
import com.liveo.principal.adapter.NavigationAdapter;
import com.liveo.principal.credito.SolicitudMaestroListaFragment;
import com.liveo.principal.fragments.InicioFragment;
import com.liveo.principal.utilidades.Constantes;
import com.liveo.principal.utilidades.Menus;
import com.liveo.principal.utilidades.Utilidades;

public class NavigationMain extends ActionBarActivity{
			
    private int lastPosition = -1;
	private ListView listDrawer;    
		
	private int counterItemDownloads;
	
	private DrawerLayout layoutDrawer;		
	private LinearLayout linearDrawer;
	private RelativeLayout userDrawer;

	private NavigationAdapter navigationAdapter;
	private ActionBarDrawerToggleCompat drawerToggle;

    private boolean estaAutenticado = false;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		getSupportActionBar().setIcon(R.drawable.ic_launcher);
		
		setContentView(R.layout.navigation_main);		
		
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);		
        
        listDrawer = (ListView) findViewById(R.id.listDrawer);        
		linearDrawer = (LinearLayout) findViewById(R.id.linearDrawer);		
		layoutDrawer = (DrawerLayout) findViewById(R.id.layoutDrawer);	
		
		userDrawer = (RelativeLayout) findViewById(R.id.userDrawer);
		userDrawer.setOnClickListener(userOnClick);
		
		if (listDrawer != null) {
			navigationAdapter = NavigationList.getNavigationAdapter(this);
		}
		
		listDrawer.setAdapter(navigationAdapter);
		listDrawer.setOnItemClickListener(new DrawerItemClickListener());

		drawerToggle = new ActionBarDrawerToggleCompat(this, layoutDrawer);		
		layoutDrawer.setDrawerListener(drawerToggle);
       		
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		if (savedInstanceState != null) { 			
			setLastPosition(savedInstanceState.getInt(Constantes.LAST_POSITION));
			
			navigationAdapter.resetarCheck();
			setTitleFragments(lastPosition);		
			navigationAdapter.setChecked(lastPosition, true);


            estaAutenticado = savedInstanceState.getBoolean(Constantes.ESTA_AUNTENTICADO);

            if (!estaAutenticado)
                this.MostrarLogin();
	    }
        else
        {
            this.MostrarLogin();
	    	setLastPosition(lastPosition);
	    	setFragmentList(lastPosition);
	    }


	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub		
		super.onSaveInstanceState(outState);		
		outState.putInt(Constantes.LAST_POSITION, lastPosition);
        outState.putBoolean(Constantes.ESTA_AUNTENTICADO, estaAutenticado);
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {  

        if (drawerToggle.onOptionsItemSelected(item)) {
              return true;
        }		
        
		switch (item.getItemId()) {		
		case Menus.HOME:
			if (layoutDrawer.isDrawerOpen(linearDrawer)) {
				layoutDrawer.closeDrawer(linearDrawer);
			} else {
				layoutDrawer.openDrawer(linearDrawer);
			}
			return true;			
		default:
			return super.onOptionsItemSelected(item);			
		}		             
    }
		
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
    	hideMenus(menu, lastPosition);
        return super.onPrepareOptionsMenu(menu);  
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);        		
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);	     
	    drawerToggle.syncState();	
	 }	
	
	public void setTitleActionBar(CharSequence informacao) {    	
    	getSupportActionBar().setTitle(informacao);
    }	
	
	public void setSubtitleActionBar(CharSequence informacao) {    	
    	getSupportActionBar().setSubtitle(informacao);
    }	

	public void setIconActionBar(int icon) {    	
    	getSupportActionBar().setIcon(icon);
    }	
	
	public void setLastPosition(int posicao){		
		this.lastPosition = posicao;
	}	
		
	private class ActionBarDrawerToggleCompat extends ActionBarDrawerToggle {

		public ActionBarDrawerToggleCompat(Activity mActivity, DrawerLayout mDrawerLayout){
			super(
			    mActivity,
			    mDrawerLayout, 
  			    R.drawable.ic_action_navigation_drawer, 
				R.string.drawer_open,
				R.string.drawer_close);
		}
		
		@Override
		public void onDrawerClosed(View view) {			
			supportInvalidateOptionsMenu();				
		}

		@Override
		public void onDrawerOpened(View drawerView) {	
			navigationAdapter.notifyDataSetChanged();			
			supportInvalidateOptionsMenu();			
		}		
	}
		  
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		drawerToggle.onConfigurationChanged(newConfig);		
	}
	
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int posicao, long id) {  
        	        	
	    	setLastPosition(posicao);        	
	    	setFragmentList(lastPosition);	    	
	    	layoutDrawer.closeDrawer(linearDrawer);	    	
        }
    }	
    
	private OnClickListener userOnClick = new OnClickListener() {		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			layoutDrawer.closeDrawer(linearDrawer);
		}
	};	
	
	private void setFragmentList(int posicion){
		
		FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment;
        Bundle args;

		switch (posicion)
        {
            case -1:
                fragment = new InicioFragment();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                break;
            case 1:
                fragment = new SolicitudMaestroListaFragment();
                args = new Bundle();
                args.putString(SolicitudMaestroListaFragment.ESTADO_SOLICITUD, "ingresada");
                fragment.setArguments(args);
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                break;
            case 2:
                fragment = new SolicitudMaestroListaFragment();
                args = new Bundle();
                args.putString(SolicitudMaestroListaFragment.ESTADO_SOLICITUD, "pendiente");
                fragment.setArguments(args);
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                break;

                //implement other fragments here
		}
			
		navigationAdapter.resetarCheck();	
		setTitleFragments(lastPosition);

        if(posicion != -1)
		    navigationAdapter.setChecked(posicion, true);
	}

    private void hideMenus(Menu menu, int posicion) {
    	    	
        boolean drawerOpen = layoutDrawer.isDrawerOpen(linearDrawer);    	
    	
        switch (posicion) {
		case 1:        
	        menu.findItem(Menus.ADD).setVisible(!drawerOpen);
	        menu.findItem(Menus.UPDATE).setVisible(!drawerOpen);	        	        	       
	        menu.findItem(Menus.SEARCH).setVisible(!drawerOpen);        
			break;
			
		case 2:
	        menu.findItem(Menus.ADD).setVisible(!drawerOpen);	        	        	       
	        menu.findItem(Menus.SEARCH).setVisible(!drawerOpen);        			
			break;	
			
			//implement other fragments here			
		}  
        
    }	

	private void setTitleFragments(int posicion){

        //setIconActionBar(Utils.iconNavigation[position]);
        setIconActionBar(R.drawable.ic_launcher);
        if(posicion == -1)
		    setSubtitleActionBar("Inicio");
        else
            setSubtitleActionBar(Utilidades.getTitleItem(NavigationMain.this, posicion));
	}

	public int getCounterItemDownloads() {
		return counterItemDownloads;
	}

	public void setCounterItemDownloads(int value) {
		this.counterItemDownloads = value;
	}

    private void MostrarLogin()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View layout = inflater.inflate(R.layout.principal_login, null);

        builder.setView(layout);
        builder.setTitle("LOGIN");
        //builder.setIcon(R.drawable.ic_login);
        builder.setCancelable(false);

       /* final EditText editTextTelefono = (EditText)layout.findViewById(R.id.editTextTelefono);
        final EditText editTextNombre = (EditText)layout.findViewById(R.id.editTextNombre);
        final EditText editTextDireccion = (EditText)layout.findViewById(R.id.editTextDireccion);
        editTextDireccion.setText(VariablesGenerales.getDireccionPersona());*/

        builder.setPositiveButton("INGRESAR", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                estaAutenticado = true;
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("SALIR", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
                System.exit(0);
            }
        });

        builder.create().show();
    }
}
