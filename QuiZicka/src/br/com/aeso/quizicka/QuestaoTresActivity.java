package br.com.aeso.quizicka;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuestaoTresActivity extends Activity {

	private Button confirmaQuestao;
	private int cont = 0;
	
	private OnClickListener onClick = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(QuestaoTresActivity.this, 
					QuestaoQuatroActivity.class);
			int idRadioSelecionado =((RadioGroup)findViewById(R.id.radioGroupQ3)).
					getCheckedRadioButtonId();
//Tem que informoar qual é a resposta correta no IF
//			if(idRadioSelecionado == 2){
//				respCerta().show();
//				cont++;
//			}else{
//				respErrada().show();
//			}
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
		setContentView(R.layout.activity_questao_tres);
		
		int totalPontos = this.getIntent().getIntExtra("Total de Pontos", cont++);
		confirmaQuestao = (Button) findViewById(R.id.buttonConfirmaQuestao);
		confirmaQuestao.setOnClickListener(onClick);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.questao_tres, menu);
		return true;
	}

}
