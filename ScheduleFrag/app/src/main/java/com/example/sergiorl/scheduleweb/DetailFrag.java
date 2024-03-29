package com.example.sergiorl.scheduleweb;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFrag extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    TextView assignature, classroom, hours, teacher;

    public DetailFrag() {
    }

    public static DetailFrag newInstance(String param1, String param2) {
        DetailFrag fragment = new DetailFrag();
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

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        assignature = (TextView) view.findViewById(R.id.assignatureFrag);
        classroom = (TextView) view.findViewById(R.id.classroomFrag);
        hours = (TextView) view.findViewById(R.id.hoursFrag);
        teacher = (TextView) view.findViewById(R.id.teacherFrag);

        Bundle objectAssignature = getArguments();
        Assignatures assignatures = null;

        if (objectAssignature!=null){
            assignatures = (Assignatures) objectAssignature.getSerializable("object");
            assignature.setText("Materia: "+assignatures.getAssignature());
            classroom.setText("Aula: "+assignatures.getClassroom());
            hours.setText("Hora: "+assignatures.getInitHour()+":00 - "+assignatures.getEndHour()+":00");
            teacher.setText("Docente: "+assignatures.getTeacher());
        }

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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
