package com.trabalholp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.appspot.trabalholp_1342.gradeapi.Gradeapi;
import com.appspot.trabalholp_1342.gradeapi.model.Avaliacao;
import com.appspot.trabalholp_1342.gradeapi.model.Nota;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;

/**
 * The Main Activity.
 * 
 * This activity starts up the RegisterActivity immediately, which communicates
 * with your App Engine backend using Cloud Endpoints. It also receives push
 * notifications from backend via Google Cloud Messaging (GCM).
 * 
 * Check out RegisterActivity.java for more details.
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button bAvaliacao = (Button) findViewById(R.id.botaoAvaliacao);
		Button bNota = (Button) findViewById(R.id.botaoNota);
		
		bAvaliacao.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Avaliacao aval = new Avaliacao();
				aval.setNome("P2");
				aval.setDisciplina("OAC");
				aval.setGabarito("FFVVFF");
				aval.setValor(Float.valueOf(10));
				aval.setMatriculaProfessor("14/0100");
				aval.setTemFator(false);
				
				new SalvarAvaliacaoAsync(MainActivity.this).execute(aval);
			}
		});
		
		bNota.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Avaliacao aval = new Avaliacao();
				aval.setNome("P2");
				aval.setDisciplina("OAC");
				aval.setGabarito("FFVVFF");
				aval.setValor(Float.valueOf(10));
				aval.setMatriculaProfessor("14/0100");
				aval.setTemFator(false);
				Nota nota = new Nota();
				nota.setAvaliacao(aval);
				nota.setPontuacao(Float.valueOf(5));
				nota.setMatriculaAluno("14/0039082");
				nota.setRespostas("VVFFVV");
				
				
				new SalvarNotaAsync(MainActivity.this).execute(nota);
				
			}
		});
		
		
	}
	
	private class SalvarNotaAsync extends AsyncTask<Nota, Void, Nota>{
        Context context;
        Nota resultado = null;
        private ProgressDialog pd;

        public SalvarNotaAsync(Context context) {
          this.context = context;
        }
        
        protected void onPreExecute(){ 
           super.onPreExecute();
                pd = new ProgressDialog(context);
                pd.setMessage("Salvando Nota...");
                pd.show();    
        }

        protected Nota doInBackground(Nota... nota) {
        	try{
              Gradeapi.Builder builder = new Gradeapi.Builder(AndroidHttp.newCompatibleTransport(), new GsonFactory(), null);
              Gradeapi service =  builder.build();
              resultado = service.addNota(nota[0]).execute();
        	}
        	catch(Exception ex){
        		Log.d("Não foi possível salvar nota", ex.getMessage(), ex);
        	}
        	
        	return resultado;
        }

        protected void onPostExecute(Nota nota) {
                //Clear the progress dialog and the fields
                pd.dismiss();
                
                //Display success message to user
                Toast.makeText(getBaseContext(), "Nota salva com sucesso!", Toast.LENGTH_SHORT).show();
        }
      }
	
	private class SalvarAvaliacaoAsync extends AsyncTask<Avaliacao, Void, Avaliacao>{
        Context context;
        private ProgressDialog pd;

        public SalvarAvaliacaoAsync(Context context) {
          this.context = context;
        }
        
        protected void onPreExecute(){ 
           super.onPreExecute();
                pd = new ProgressDialog(context);
                pd.setMessage("Salvando Avaliacao...");
                pd.show();    
        }

        protected Avaliacao doInBackground(Avaliacao... avaliacao) {
        	Avaliacao resultado = null;
        	try{
              Gradeapi.Builder builder = new Gradeapi.Builder(AndroidHttp.newCompatibleTransport(), new GsonFactory(), null);
              Gradeapi service =  builder.build();
              resultado = service.addAvaliacao(avaliacao[0]).execute();
        	}
        	catch(Exception ex){
        		Log.d("Não foi possível salvar avaliação", ex.getMessage(), ex);
        	}
        	
        	return resultado;
        }
        
        @Override
        protected void onPostExecute(Avaliacao avaliacao) {
                //Clear the progress dialog and the fields
                pd.dismiss();
                
                //Display success message to user
                Toast.makeText(getBaseContext(), "Nota salva com sucesso!", Toast.LENGTH_SHORT).show();
        }
      }
	
	
}
