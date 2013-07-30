package com.jordibar.laziofitnessv2;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class CalculaGrasa extends Activity implements OnClickListener{
	
	private EditText altura, cadera;
	TextView resultado;
	private Button buttonCalcular;
	private float total;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calculagrasa);
		
		altura = (EditText) this.findViewById(R.id.altura);
		cadera = (EditText) this.findViewById(R.id.cadera);
		resultado = (TextView) this.findViewById(R.id.resultado);
		buttonCalcular = (Button) this.findViewById(R.id.buttonGrabar);
		
		//Actions
		buttonCalcular.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		//Con este if advertimos qué campos son obligatorios si no se han rellenado
		if (altura.getText().toString().length()==0 || cadera.getText().toString().length()==0)
		{
			Toast.makeText(this,  R.string.errorCalculaGrasaCamposVacios, Toast.LENGTH_LONG).show();
		}
		else
		{
			int valorAltura = Integer.parseInt(altura.getText().toString());
			int valorCadera = Integer.parseInt(cadera.getText().toString());
			
			//Calculamos el resultado
			total = (valorAltura * valorCadera);
			
			//Ponemos el resultado al TextEdit correspondiente
			resultado.setText("Porcentaje de grasa: " +String.valueOf(total)+ " %."+"\n"+"\n"+"Puedes consultar tus dudas con tu monitor/a.");
		}
		
	}

}
