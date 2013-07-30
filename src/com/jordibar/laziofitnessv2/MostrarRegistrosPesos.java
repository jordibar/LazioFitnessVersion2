package com.jordibar.laziofitnessv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MostrarRegistrosPesos extends Activity{
	
	private ListView resultadoLV;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mostrar_registros_pesos);
		
		resultadoLV = (ListView) this.findViewById(R.id.resultadoLV);
		
		
		Vector<String> result = new Vector<String>();
		
		try {
		    BufferedReader entrada = new BufferedReader(new InputStreamReader(openFileInput("pesos")));
		    int n=0;
		    String linea;
		    
		    do {
		    	linea = entrada.readLine();
		    	if(linea != null)
		    	{
		    		result.add(linea);
		    		n++;
		    	}
		    }while (linea != null);
		    entrada.close();

		} catch (IOException e) {
		    e.printStackTrace();
		}
		//resultado2.setText(result.toString());
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, result);
		resultadoLV.setAdapter(adapter);
	}//Final onCreate

}
