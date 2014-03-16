package br.com.aeso.projeto;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuestionOneActivity extends Activity {
	
	Button confirmar;
	int acertos = 0;
	
	private OnClickListener onClick = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(QuestionOneActivity.this,
					QuestionTwoActivity.class);
			int radioGroupSelect = ((RadioGroup) findViewById(R.id.radioGroupQ1))
					.getCheckedRadioButtonId();
			if(radioGroupSelect==R.id.opcaoQuatroQuestionOne){
				correto().show();
				acertos++;
			}else{
				errado().show();
			}
			intent.putExtra("Acertos", acertos);
			startActivity(intent);
		}
	};
	
	public Toast correto(){
		Context context = getApplicationContext();
		CharSequence text = "Resposta correta";
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		return toast;
	}
	
	public Toast errado(){
		Context context = getApplicationContext();
		CharSequence text = "Resposta errada BURRO";
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		return toast;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question_one);
		
		confirmar = (Button) findViewById(R.id.buttonConfirmarQ1);
		confirmar.setOnClickListener(onClick);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.question_one, menu);
		return true;
	}

}
