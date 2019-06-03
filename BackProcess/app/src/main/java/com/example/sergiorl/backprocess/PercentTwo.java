package com.example.sergiorl.backprocess;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class PercentTwo extends AsyncTask<String, Integer, String> {

    private MainActivity context;
    private ProgressBar progressBarDos;
    private TextView tvDos;

    public PercentTwo(MainActivity context)
    {
        this.context = context;
    }
    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        Toast.makeText(context, "Progreso X2", Toast.LENGTH_LONG).show();
    }
    @Override
    protected String doInBackground(String... params) {
        for(int i = 0; i <= 100; i++)
        {
            try
            {
                Thread.sleep(200);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
        }
        return String.valueOf(params[0]);
    }
    @Override
    protected void onProgressUpdate (Integer... valores)
    {
        super.onProgressUpdate(valores);
        progressBarDos = (ProgressBar)context.findViewById(R.id.progressBarDos);
        progressBarDos.setProgress(valores[0]);
        tvDos = (TextView)context.findViewById(R.id.tvDos);
        tvDos.setText(valores[0] + "%");
    }
    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        Toast.makeText(context, s,Toast.LENGTH_LONG).show();
        new PercentFive(context).execute("Carga Finalizada X5");
    }
}

