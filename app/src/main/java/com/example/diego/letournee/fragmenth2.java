package com.example.diego.letournee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Diego on 07/04/2017.
 */

public class fragmenth2 extends android.support.v4.app.Fragment {
    public static fragmenth2 newInstance(){
        fragmenth2 fragment = new fragmenth2();
        return  fragment;
    }

    public fragmenth2(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_huasca2,container,false);
        return rootView;
    }
}
