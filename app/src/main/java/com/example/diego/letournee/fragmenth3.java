package com.example.diego.letournee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Diego on 07/04/2017.
 */
public class fragmenth3 extends android.support.v4.app.Fragment {
    public static fragmenth3 newInstance(){
        fragmenth3 fragment = new fragmenth3();
        return  fragment;
    }

    public fragmenth3(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_huasca3,container,false);
        return rootView;
    }
}
