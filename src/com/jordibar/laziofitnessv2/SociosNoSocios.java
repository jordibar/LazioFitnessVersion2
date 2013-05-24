package com.jordibar.laziofitnessv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SociosNoSocios extends TabGroupActivity
{
	Button buttonSocios;
	Button buttonNoSocios;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sociosnosocios);
		
		//El boton socios inicia la actividad intentSocios
		buttonSocios = (Button) findViewById(R.id.buttonSocios);
		buttonSocios.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view)
			{
				lanzarSocios(null);
			}
		});
		
		
		//El boton socios inicia la actividad intentSocios
		buttonNoSocios = (Button) findViewById(R.id.buttonNoSocios);
		buttonNoSocios.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View view)
			{
				lanzarNoSocios(null);
			}
		});
		
	}//Final onCreate

	public void lanzarSocios(View view)
	{
		Intent intentSocios = new Intent(getParent(), Socios.class);
		TabGroupActivity parentActivity = (TabGroupActivity)getParent();
		parentActivity.startChildActivity("socios", intentSocios);
	}
	
	public void lanzarNoSocios(View view)
	{
		Intent intentNoSocios = new Intent(getParent(), NoSocios.class);
		TabGroupActivity parentActivity = (TabGroupActivity)getParent();
		parentActivity.startChildActivity("socios", intentNoSocios);
	}

}
