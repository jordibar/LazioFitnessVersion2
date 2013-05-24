package com.jordibar.laziofitnessv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Entreno extends TabGroupActivity{
	
	Button buttonCalculaGrasa;
	Button buttonCalculaPeso;
	Button buttonCalculaFuerza;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.entreno);
		
		//Boton CalculaGrasa
		buttonCalculaGrasa = (Button) findViewById(R.id.buttonCalculaGrasa);
		buttonCalculaGrasa.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View view)
			{
				lanzarCalculaGrasa(null);
			}
		});
		
		//Boton CalculaPeso
		buttonCalculaPeso = (Button) findViewById(R.id.buttonCalculaPeso);
		buttonCalculaPeso.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View view)
			{
				lanzarCalculaPeso(null);
			}
		});
		
		//Boton CalculaFuerza
		buttonCalculaFuerza = (Button) findViewById(R.id.buttonCalculaFuerza);
		buttonCalculaFuerza.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View view)
			{
				lanzarCalculaFuerza(null);
			}
		});		
		
	}//Final onCreate
	
	
	
	public void lanzarCalculaGrasa(View view)
	{
		Intent calculaGrasaIntent = new Intent(getParent(), CalculaGrasa.class);
		TabGroupActivity parentActivity = (TabGroupActivity)getParent();
		parentActivity.startChildActivity("valculaGrasa", calculaGrasaIntent);
	}
	
	
	public void lanzarCalculaPeso(View view)
	{
		Intent calculaPesoIntent = new Intent(getParent(), CalculaPeso.class);
		TabGroupActivity parentActivity = (TabGroupActivity)getParent();
		parentActivity.startChildActivity("calculaPeso", calculaPesoIntent);
	}
	
	
	public void lanzarCalculaFuerza(View view)
	{
		Intent calculaFuerzaIntent = new Intent(getParent(), CalculaFuerza.class);
		TabGroupActivity parentActivity = (TabGroupActivity)getParent();
		parentActivity.startChildActivity("calculaFuerza", calculaFuerzaIntent);
	}

}//Final Entreno.java
