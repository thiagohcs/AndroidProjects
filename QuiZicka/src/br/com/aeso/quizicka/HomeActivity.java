package br.com.aeso.quizicka;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends Activity {

	private Button start;
	
	private OnClickListener onClick = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(HomeActivity.this,
					QuestaoUmActivity.class);
			startActivity(intent);
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		start = (Button) findViewById(R.id.buttonStart);
		start.setOnClickListener(onClick);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
