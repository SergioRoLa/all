package com.example.sergiorl.backprocess;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class PercentFive extends AsyncTask<String, Integer, String> {

    private MainActivity context;
    private ProgressBar progressBarCinco;
    private TextView tvCinco;

    public PercentFive(MainActivity context)
    {
        this.context = context;
    }
    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        Toast.makeText(context, "Progreso X5", Toast.LENGTH_LONG).show();
    }
    @Override
    protected String doInBackground(String... params) {
        for(int i = 0; i <= 100; i++)
        {
            try
            {
                Thread.sleep(500);

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
        progressBarCinco = (ProgressBar)context.findViewById(R.id.progressBarCinco);
        progressBarCinco.setProgress(valores[0]);
        tvCinco = (TextView)context.findViewById(R.id.tvCinco);
        tvCinco.setText(valores[0] + "%");
    }
    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        Toast.makeText(context, s,Toast.LENGTH_LONG).show();
        new PercentTen(context).execute("Carga Finalizada X10");
    }
}
