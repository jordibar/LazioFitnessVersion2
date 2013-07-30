package com.jordibar.laziofitnessv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Sugerencias extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sugerencias);
	}
	
	//Al pulsar el botón que tiene onClick=enviarSugerencia
	public void enviarSugerencia(View v)
	{
		final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
		intent.setType("text/html");
		intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"gymlazio@laziofitnes.com"});
		intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Mensaje enviado desde LAZIO FITNESS APP");
		intent.putExtra(android.content.Intent.EXTRA_TEXT, "Escribe aquí tu sugerencia o duda");
        startActivity(Intent.createChooser(intent, "LAZIO FITNESS APP"));
	}

}
