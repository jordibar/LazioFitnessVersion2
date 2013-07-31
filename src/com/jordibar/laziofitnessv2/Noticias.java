package com.jordibar.laziofitnessv2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Noticias extends ListActivity{
	String[] noticia_titulo = null;
	String[] noticia_descripcion = null;
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.noticias);
		
		JSONArray jArray;
		String result = null;
		InputStream is = null;
		StringBuilder sb = null;
		
		//ListView lv_noticias;
		
		//lv_noticias = (ListView) findViewById(R.id.lv_noticias);

	
	//http post
	try
	{
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost("http://jordibalba.p.ht/noticiasVersion2.php");
		//httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity entity = response.getEntity();
		is = entity.getContent();
	}catch(Exception e){
			Log.e("log_tag", "Error en la conexión http"+e.toString());
		}
	
	//Convert response to string
	try
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
		sb = new StringBuilder();
		sb.append(reader.readLine() + "\n");
		
		String line="0";
		while ((line = reader.readLine()) != null)
		{
			sb.append(line + "\n");
		}
		is.close();
		result=sb.toString();
	}catch(Exception e){
		Log.e("log_tag", "Error convirtiendo el resultado "+e.toString());
		}
	
	//paring data
	
	try
	{
		jArray = new JSONArray(result);
		JSONObject json_data=null;
		noticia_titulo = new String[jArray.length()];
		noticia_descripcion = new String[jArray.length()];
		
		for(int i=0; i<jArray.length(); i++)
		{
			json_data = jArray.getJSONObject(i);
			noticia_titulo[i] = json_data.getString("titulo");
			noticia_descripcion[i] = json_data.getString("descripcion");
		}
	}catch(JSONException el){
		Toast.makeText(getBaseContext(), "No se ha encontrado la información" ,Toast.LENGTH_LONG).show();
		} catch (ParseException el){
			el.printStackTrace();
		}
	
	setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, noticia_titulo));
	
	ListView lv_noticias;
	lv_noticias = getListView();
	lv_noticias.setTextFilterEnabled(true);
	lv_noticias.setOnItemClickListener(new OnItemClickListener()
	{
		public void onItemClick(AdapterView<?>parent, View view, int position, long id)
		{
			AlertDialog dialog = new AlertDialog.Builder(Noticias.this).create();

		    dialog.setCancelable(false);
		    dialog.setTitle(noticia_titulo[position]);
		    dialog.setMessage(noticia_descripcion[position]);
		    dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Cerrar", new DialogInterface.OnClickListener()
		    {
		        @Override
		        public void onClick(DialogInterface dialog, int which) {
		            // TODO Auto-generated method stub
		            dialog.dismiss();		
			
			
			
			//When clicked, show a toast with the TextView text
			//Toast.makeText(getApplicationContext(), noticia_descripcion[position], Toast.LENGTH_LONG).show();
		        }
		    });
		    dialog.show();
		}

	});
	}
}
