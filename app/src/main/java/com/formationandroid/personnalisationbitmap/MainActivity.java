package com.formationandroid.personnalisationbitmap;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity
{
	
	// Constantes :
	private static final String LIEN_IMAGE = "http://www.denis-fremond.com/photos_art/20062014195748u38892506.JPG";
	private static final String CHEMIN_FONT = "font/Tangerine-Bold.ttf";
	
	// Vues :
	private TextView textViewLegende = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// init :
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// vues :
		ImageView imageView = findViewById(R.id.image);
		textViewLegende = findViewById(R.id.legende);
		
		// police de caractères personnalisée :
		Typeface typeface = Typeface.createFromAsset(getAssets(), CHEMIN_FONT);
		textViewLegende.setTypeface(typeface);
		
		// chargement de l'image :
		Picasso.with(this)
				.load(LIEN_IMAGE)
				.fit()
				.centerInside()
				.into(imageView);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// ajout du menu à l'action bar :
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.action_legende:
				
				// affichage de la légende :
				textViewLegende.setVisibility(View.VISIBLE);
				
				return true;
				
			default:
				
				return super.onOptionsItemSelected(item);
		}
	}
	
}
