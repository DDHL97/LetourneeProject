package com.example.diego.letournee;

/**
 * Created by Diego on 07/04/2017.
 */
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragment2 extends android.support.v4.app.Fragment{
    public static fragment2 newInstance(){
        fragment2 fragment = new fragment2();
        return  fragment;
    }

    public fragment2(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment2,container,false);
        return rootView;
    }

}