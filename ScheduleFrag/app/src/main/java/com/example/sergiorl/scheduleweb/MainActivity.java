package com.example.sergiorl.scheduleweb;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ListFrag.OnFragmentInteractionListener,
    DetailFrag.OnFragmentInteractionListener, sendInfoFrag{

    ListFrag listFrag;
    DetailFrag detailFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void sendInfo(Assignatures assignatures) {
        detailFrag = new DetailFrag();
        Bundle bundle = new Bundle();
        bundle.putSerializable("object", assignatures);
        detailFrag.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment, detailFrag).addToBackStack(null).commit();
    }
}

