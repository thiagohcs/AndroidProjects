package br.com.aeso.quizicka;

import org.w3c.dom.Text;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class EndActivity extends Activity {
	
	TextView resultado;
	Button jogarNovamente;
	Button sair;
	
	private OnClickListener onClikJogarNovamente = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(EndActivity.this, 
					QuestaoUmActivity.class);
			startActivity(intent);
		}
	};
	
	private OnClickListener onClickSair = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(Intent.ACTION_MAIN);
			finish();
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_end);
		//faltando apenas mostar o resultado
		//int total = this.getIntent().getIntExtra("Total de pontos", defaultValue)
		resultado = (TextView) findViewById(R.id.textViewResultado);
		jogarNovamente = (Button) findViewById(R.id.buttonJogarNovamente);
		sair = (Button) findViewById(R.id.buttonSair);
		
		resultado.setText("Você acertou " +/*totalPontos+*/"questões");
		jogarNovamente.setOnClickListener(onClikJogarNovamente);
		sair.setOnClickListener(onClickSair);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.end, menu);
		return true;
	}

}
