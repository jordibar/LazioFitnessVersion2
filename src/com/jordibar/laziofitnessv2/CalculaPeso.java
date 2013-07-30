package com.jordibar.laziofitnessv2;

import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class CalculaPeso extends Activity{
	
	private EditText dia, peso;
	private ListView resultadoLV;
	private Button buttonGrabar, buttonMostrarRegistros;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calculapeso);
		
		dia = (EditText) findViewById(R.id.dia);
		peso = (EditText) findViewById(R.id.peso);
		resultadoLV = (ListView) this.findViewById(R.id.resultadoLV);
		buttonGrabar = (Button) findViewById(R.id.buttonGrabar);
		buttonMostrarRegistros = (Button) findViewById(R.id.buttonMostrarRegistros);
		
		
		
		buttonGrabar.setOnClickListener(new Button.OnClickListener()
		{
			public void onClick(View arg0)
			{
				grabar(null);
			}
		});

		buttonMostrarRegistros.setOnClickListener(new Button.OnClickListener()
		{
			public void onClick(View arg0)
			{
				mostrarRegistrosPesos(null);
			}
		});
		
		
	}//final onCreate
	


	public void grabar(View v)
	{
		try {
		    FileOutputStream fos = openFileOutput("pesos", Context.MODE_APPEND);
		    String texto = "DÍA: "+dia.getText()+" - PESO: "+peso.getText()+"\n";
		    fos.write(texto.getBytes());
		    fos.close();
		    
		    Toast.makeText(this, "Los datos han sido grabados correctamente",Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	
	public void mostrarRegistrosPesos(View v)
	{
		Intent mostrarRegistrosPesos = new Intent(getParent(), MostrarRegistrosPesos.class);
		TabGroupActivity parentActivity = (TabGroupActivity)getParent();
		parentActivity.startChildActivity("mostrarRegistrosPesos", mostrarRegistrosPesos);
	}
}
