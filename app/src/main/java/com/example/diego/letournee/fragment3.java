package com.example.diego.letournee;

/**
 * Created by Diego on 07/04/2017.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragment3 extends android.support.v4.app.Fragment{
    public static fragment3 newInstance(){
        fragment3 fragment = new fragment3();
        return  fragment;
    }

    public fragment3(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment3,container,false);
        return rootView;
    }

}
