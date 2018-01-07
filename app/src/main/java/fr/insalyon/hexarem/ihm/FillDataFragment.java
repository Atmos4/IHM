package fr.insalyon.hexarem.ihm;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Matthieu on 07/01/2018.
 */

public class FillDataFragment extends Fragment {
    public FillDataFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //TODO Insert content here
        return inflater.inflate(R.layout.fragment_donnees, container, false);
    }
}