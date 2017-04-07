package com.example.diego.letournee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Diego on 07/04/2017.
 */

public class fragmenth1 extends android.support.v4.app.Fragment {
    public static fragmenth1 newInstance(){
        fragmenth1 fragment = new fragmenth1();
        return  fragment;
    }

    public fragmenth1(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_huasca1,container,false);
        return rootView;
    }
}
