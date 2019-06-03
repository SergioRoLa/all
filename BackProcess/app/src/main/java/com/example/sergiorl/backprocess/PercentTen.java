package com.example.sergiorl.backprocess;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class PercentTen extends AsyncTask<String, Integer, String> {

    private MainActivity context;
    private ProgressBar progressBarDiez;
    private TextView tvDiez;

    public PercentTen(MainActivity context){
        this.context = context;
    }
    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        Toast.makeText(context, "Progreso X10", Toast.LENGTH_LONG).show();
    }
    @Override
    protected String doInBackground(String... params) {
        for(int i = 0; i <= 100; i++)
        {
            try
            {
                Thread.sleep(1000);

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
        progressBarDiez = (ProgressBar)context.findViewById(R.id.progressBarDiez);
        progressBarDiez.setProgress(valores[0]);
        tvDiez = (TextView)context.findViewById(R.id.tvDiez);
        tvDiez.setText(valores[0] + "%");
    }
    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        Toast.makeText(context, s,Toast.LENGTH_LONG).show();
    }
}
