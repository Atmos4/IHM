package fr.insalyon.hexarem.ihm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by Arnaud on 15/12/2017.
 */

public class HomeFragment extends Fragment implements View.OnClickListener {

    ImageButton btnFriends,btnData,btnProfile,btnAdvices;

    public HomeFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //TODO Insert content here
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        //Setting up the buttons
        btnProfile = (ImageButton) rootView.findViewById(R.id.monprofil_btn);
        btnFriends = (ImageButton) rootView.findViewById(R.id.mesamis_btn);
        btnData = (ImageButton) rootView.findViewById(R.id.mesdonnees_btn);
        btnAdvices = (ImageButton) rootView.findViewById(R.id.mesconseils_btn);

        //Handling clicks on the buttons
        btnProfile.setOnClickListener(this);
        btnFriends.setOnClickListener(this);
        btnData.setOnClickListener(this);
        btnAdvices.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.monprofil_btn:
                //TODO Insert profile display here
                break;
            case R.id.mesamis_btn:
                //TODO Insert friends activity or fragment here
                break;
            case R.id.mesdonnees_btn:
                //TODO Insert data screen display here
                break;
            case R.id.mesconseils_btn:
                //TODO Insert what the fck you want here
                break;
        }
    }
}
