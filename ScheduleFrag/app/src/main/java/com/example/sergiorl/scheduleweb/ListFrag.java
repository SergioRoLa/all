package com.example.sergiorl.scheduleweb;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class ListFrag extends Fragment{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    Calendar calendar = Calendar.getInstance();
    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    TextView textDay;

    ArrayList<Assignatures> assignaturesList, filteredList;
    RecyclerView recyclerView;
    Activity activity;
    sendInfoFrag sendInfoFrag;

    public ListFrag() {
    }

    public static ListFrag newInstance(String param1, String param2) {
        ListFrag fragment = new ListFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_list, container, false);
        textDay = (TextView) view.findViewById(R.id.textDay);
        switch (dayOfWeek){
            case 2:
                textDay.setText("Lunes");
                break;
            case 3:
                textDay.setText("Martes");
                break;
            case 4:
                textDay.setText("Miercoles");
                break;
            case 5:
                textDay.setText("Jueves");
                break;
            case 6:
                textDay.setText("Viernes");
                break;
            default:
                textDay.setText("Hoy no tienes ninguna clase");
        }

        assignaturesList = new ArrayList<>();
        filteredList = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        assignaturesList.add(new Assignatures("Desarrollo de aplicaciones a dispositivos móviles", "Lab. Comp. 2", 8,10, "Hugo René Lárraga Altamirano",2));
        assignaturesList.add(new Assignatures("Cómputo forense", "Lab. Comp. 5",10,12,"Juan Manuel Salazar Mata",2));
        assignaturesList.add(new Assignatures("Programación web", "Lab. Comp. 2", 10,12, "Jaime Jesus Delgado Meraz",3));
        assignaturesList.add(new Assignatures("Cómputo forense", "Lab. Redes",12,14,"Juan Manuel Salazar Mata",3));
        assignaturesList.add(new Assignatures("Programacion web", "Lab. Comp. 2",12,13, "Jaime Jesus Delgado Meraz",4));
        assignaturesList.add(new Assignatures("Administracion de redes", "Cisco", 13,15, "Hector Francisco Diaz Uribe",4));
        assignaturesList.add(new Assignatures("Taller de investigacion", "A6", 15,17, "Frank Second",4));
        assignaturesList.add(new Assignatures("Programacion logica y funcional", "Lab. Comp. 4",17,17, "Victor Manuel Abundis",4));
        assignaturesList.add(new Assignatures("Desarrollo de aplicaciones a dispositivos móviles", "Lab. Comp. 2",8,9, "Hugo René Lárraga Altamirano",5));
        assignaturesList.add(new Assignatures("Programación web", "Lab. Comp. 2", 9,11, "Jaime Jesus Delgado Meraz",5));
        assignaturesList.add(new Assignatures("Computo forense","Cisco",11,12,"Juan Manuel Salazar Mata",5));
        assignaturesList.add(new Assignatures("Administracion de redes","Cisco",12,14,"Hector Francisco Diaz Uribe",5));
        assignaturesList.add(new Assignatures("Desarrollo de aplicaciones a dispositivos móviles","Lab. Comp. 2",13,15,"Hugo René Lárraga Altamirano",6));
        assignaturesList.add(new Assignatures("Taller de investigacion","A6",15,17,"Frank Second",6));
        assignaturesList.add(new Assignatures("Programacion logica y funcional","Lab. Comp. 4",17,19,"Victor Manuel Abundis",6));
        if(dayOfWeek != 1 && dayOfWeek != 7){
            for (int i = 0; i < assignaturesList.size(); i++){
                if (assignaturesList.get(i).getDay() == dayOfWeek){
                    filteredList.add(assignaturesList.get(i));
                }
            }
        }
        Adaptador adaptador = new Adaptador(filteredList);
        recyclerView.setAdapter(adaptador);
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendInfoFrag.sendInfo(filteredList.get(recyclerView.getChildAdapterPosition(v)));
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity){
            this.activity = (Activity) context;
            sendInfoFrag = (sendInfoFrag) this.activity;
        }
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
