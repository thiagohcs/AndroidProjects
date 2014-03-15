package br.com.aeso.quizicka;

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

public class QuestaoUmActivity extends Activity {
	
	private Button confirmaQuestao;
	int totalPontos = 0;
	
	private OnClickListener onClick = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(QuestaoUmActivity.this,
					QuestaoDoisActivity.class);
			int idRadioSelecionado = ((RadioGroup)findViewById(R.id.radioGroupQ1)).
					getCheckedRadioButtonId();
			
			if(idRadioSelecionado == 4){
				respCerta().show();
				totalPontos++;
			}else{
				respErrada().show();
			}
			intent.putExtra("Total de Pontos", totalPontos);
			startActivity(intent);
		}
	};
	
	public Toast respCerta(){
		Context context = getApplicationContext();
		CharSequence text = "Resposta Correta!";
		int duration = 5000;
		Toast toast = Toast.makeText(context, text, duration);
		return toast;
	}
	
	public Toast respErrada(){
		Context context = getApplicationContext();
		CharSequence text = "Resposta errada BURRO!";
		int duration = 5000;
		Toast toast = Toast.makeText(context, text, duration);
		return toast;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_questao_um);
		
		confirmaQuestao = (Button) findViewById(R.id.buttonConfirmaQuestao);
		confirmaQuestao.setOnClickListener(onClick);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.questao_um, menu);
		return true;
	}

}
