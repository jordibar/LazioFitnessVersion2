package com.jordibar.laziofitnessv2;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.opengl.Visibility;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import com.jordibar.laziofitnessv2.R;

public class Principal2 extends TabActivity {
	
	private TabHost mTabHost;
	
	private void setupTabHost() {
		mTabHost = (TabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal2);
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		if(!prefs.getBoolean("firstTime", false))
		{
			//La primera vez que se ejecuta
			SharedPreferences.Editor editor =prefs.edit();
			editor.putBoolean("firstTime", true);
			editor.commit();
		}
				
		setupTabHost();
		mTabHost.getTabWidget().setDividerDrawable(R.drawable.tab_divider);
		
		//Añadimos las pestanas
		setupTab(new TextView(this), "Principal", "Principal.class");
		setupTab(new TextView(this), "Socios / No Socios", "SociosNoSocios.class");
		setupTab(new TextView(this), "Horarios Clases", "Horarios.class");
		setupTab(new TextView(this), "Noticias", "Noticias.class");
		}
		
	
	
		private void setupTab(final View view, final String tag, final String className)
		{
			View tabview = createTabView(mTabHost.getContext(), tag);
			TabHost tabHost = getTabHost();
			TabHost.TabSpec spec;
			Intent intent;
			intent = new Intent().setClass(this, SociosNoSocios.class); 
			tabHost.setCurrentTab(1);//Indica con que Tab se abre la Activity
			//tabHost.getTabWidget().getChildAt(2).setVisibility(View.GONE);
			
			if (className.equals("Principal.class"))
			{
				intent = new Intent().setClass(this, Principal.class); 
			}
			if (className.equals("SociosNoSocios.class"))
			{
				intent = new Intent().setClass(this, SociosNoSocios.class);
			}
			if (className.equals("Horarios.class"))
			{
				intent = new Intent().setClass(this, Horarios.class);
			}
			if (className.equals("Noticias.class"))
			{
				intent = new Intent().setClass(this, Noticias.class);
			}
			
			TabSpec setContent = mTabHost.newTabSpec(tag).setIndicator(tabview).setContent(intent);
			
			mTabHost.addTab(setContent);
			
			//tabHost.getTabWidget().getChildTabViewAt(1).setVisibility(View.GONE);
		}
	
		
		private static View createTabView(final Context context, final String text)
		{
			View view = LayoutInflater.from(context).inflate(R.layout.tabs_bg, null);
			TextView tv = (TextView) view.findViewById(R.id.tabsText);
			tv.setText(text);
			return view;
		}
}

