package com.example.diego.letournee;

/**
 * Created by Diego on 07/04/2017.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragment5 extends android.support.v4.app.Fragment{
    public static fragment5 newInstance(){
        fragment5 fragment = new fragment5();
        return  fragment;
    }

    public fragment5(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment5,container,false);
        return rootView;
    }

}