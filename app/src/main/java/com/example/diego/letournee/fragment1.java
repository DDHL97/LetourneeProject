package com.example.diego.letournee;

/**
 * Created by Diego on 07/04/2017.
 */
//import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class fragment1 extends Fragment {
public static fragment1 newInstance(){
    fragment1 fragment = new fragment1();
    return  fragment;
}

    public fragment1(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment1,container,false);
        return rootView;
    }

}
