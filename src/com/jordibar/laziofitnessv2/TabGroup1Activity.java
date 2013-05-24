package com.jordibar.laziofitnessv2;

import android.content.Intent;
import android.os.Bundle;

public class TabGroup1Activity extends TabGroupActivity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		startChildActivity("Principal", new Intent(this,Principal.class));
	}
}
