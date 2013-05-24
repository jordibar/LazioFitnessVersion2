package com.jordibar.laziofitnessv2;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;


public class Principal extends TabGroupActivity
{
	
	Button botonPrincipal;
	Button botonPrincipal2;
	//BORRAR Intent i1;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal);

		//Al pulsar el botonPrincipal se inicia la Activity sociosNoSocios
		botonPrincipal = (Button) findViewById(R.id.botonPrincipal);		
		botonPrincipal.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View view)
			{
				lanzarSociosNoSocios(null);
			}
		});
		
		//Al pulsar el botonPrincipal2 se inicia la Activity sociosNoSocios
		botonPrincipal2 = (Button) findViewById(R.id.botonPrincipal2);		
		botonPrincipal2.setOnClickListener(new OnClickListener(){
			public void onClick(View view)
			{
				lanzarSociosNoSocios(null);
			}
		});
		
	}//Final onCreate
	
	
	
	
	public void lanzarSociosNoSocios(View view)
	{
		//Creamos un intent para llamar a la actividad SociosNoSocios
		Intent sociosNoSociosIntent = new Intent(getParent(),SociosNoSocios.class);
		TabGroupActivity parentActivity = (TabGroupActivity)getParent();
		parentActivity.startChildActivity("socionosocios", sociosNoSociosIntent);
	}
	
}
