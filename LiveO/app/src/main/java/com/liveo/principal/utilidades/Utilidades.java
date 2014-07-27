package com.liveo.principal.utilidades;
import android.content.Context;

import com.liveo.R;

public class Utilidades {

	//Set all the navigation icons and always to set "zero 0" for the item is a category
	public static int[] iconNavigation = new int[]
            {
                0,
                R.drawable.ic_ingresada1,
                R.drawable.ic_pendiente,
                R.drawable.ic_digitacion,
                R.drawable.ic_verificada,
                R.drawable.ic_calificada,
                0,
                R.drawable.ic_gestion_cobro,
                R.drawable.ic_action_add,
                R.drawable.ic_action_discard,
                0,
                R.drawable.ic_action_map,
                R.drawable.ic_action_share
            };
	
	//get title of the item navigation
	public static String getTitleItem(Context context, int posicao){		
		String[] titulos = context.getResources().getStringArray(R.array.nav_menu_items);  
		return titulos[posicao];
	} 
	
}
