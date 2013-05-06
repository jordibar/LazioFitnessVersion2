package com.jordibar.laziofitnessv2;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class MainActivity extends TabActivity{

	TabHost tabHost;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//------------------MENU-----------------------------------------------------------------------------------
		tabHost = getTabHost(); //Creamos el tabHost de la actividad
		TabHost.TabSpec spec; //Creamos un recurso para las propiedades de la pestana
		Intent intent; //Intent que se uilitzara para abrir cada pestana
		Resources res = getResources(); //Obtenemos los recursos
		
		
		
		//Se crea el intent para abrir la actividad que en realidad es una clase
		intent = new Intent().setClass(this,  Principal.class);
		//Se configura la pesrana con sus propiedades
		spec = tabHost.newTabSpec("Principal").setIndicator("Principal").setContent(intent);
		//Se carga la pestana en el contenedor TabHost
		tabHost.addTab(spec);
		
		
		
		//Repetimos lo mismo por cada pestana
		intent = new Intent().setClass(this,  Contacto.class);
		spec = tabHost.newTabSpec("Contacto").setIndicator("Contacto").setContent(intent);
		tabHost.addTab(spec);
		
		intent = new Intent().setClass(this,  Horarios.class);
		spec = tabHost.newTabSpec("Horarios").setIndicator("Horarios Classes").setContent(intent);
		tabHost.addTab(spec);
		
		intent = new Intent().setClass(this,  Noticias.class);
		spec = tabHost.newTabSpec("Noticias").setIndicator("Noticias").setContent(intent);
		tabHost.addTab(spec);
		

    
		//-----------------\MENU-----------------------------------------------------------------------------------
	}



}
