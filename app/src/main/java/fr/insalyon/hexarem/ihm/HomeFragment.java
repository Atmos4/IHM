package fr.insalyon.hexarem.ihm;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Arnaud on 15/12/2017.
 */

public class HomeFragment extends Fragment {
    public HomeFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //TODO Insert content here
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
