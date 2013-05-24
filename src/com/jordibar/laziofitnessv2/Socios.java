package com.jordibar.laziofitnessv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Socios extends TabGroupActivity{
	
	Button buttonPromociones;
	Button buttonServicios;
	Button buttonSugerencias;
	Button buttonEntreno;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.socios);
		
		//Boton Promociones
		buttonPromociones = (Button) findViewById(R.id.buttonPromociones);
		buttonPromociones.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View view)
			{
				lanzarPromociones(null);
			}
		});
		
		//Boton Servicios
		buttonServicios = (Button) findViewById(R.id.buttonServicios);
		buttonServicios.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View view)
			{
				lanzarServicios(null);
			}
		});
		
		//Boton Sugerencias
		buttonSugerencias = (Button) findViewById(R.id.buttonSugerencias);
		buttonSugerencias.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View view)
			{
				lanzarSugerencias(null);
			}
		});
		
		//Boton Entreno
		buttonEntreno = (Button) findViewById(R.id.buttonEntreno);
		buttonEntreno.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View view)
			{
				lanzarEntreno(null);
			}
		});		
	}//Final OnCreate
	
	
	
	public void lanzarPromociones(View view)
	{
		Intent promocionesIntent = new Intent(getParent(), Promociones.class);
		TabGroupActivity parentActivity = (TabGroupActivity)getParent();
		parentActivity.startChildActivity("promociones", promocionesIntent);
	}
	
	
	public void lanzarServicios(View view)
	{
		Intent serviciosIntent = new Intent(getParent(), Servicios.class);
		TabGroupActivity parentActivity = (TabGroupActivity)getParent();
		parentActivity.startChildActivity("servicios", serviciosIntent);
	}
	
	
	public void lanzarSugerencias(View view)
	{
		Intent sugerenciasIntent = new Intent(getParent(), Sugerencias.class);
		TabGroupActivity parentActivity = (TabGroupActivity)getParent();
		parentActivity.startChildActivity("sugerencias", sugerenciasIntent);
	}
	
	
	public void lanzarEntreno(View view)
	{
		Intent entrenoIntent = new Intent(getParent(), Entreno.class);
		TabGroupActivity parentActivity = (TabGroupActivity)getParent();
		parentActivity.startChildActivity("entreno", entrenoIntent);
	}

}//Final Socios.java
