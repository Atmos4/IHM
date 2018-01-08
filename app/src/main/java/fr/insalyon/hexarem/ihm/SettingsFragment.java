package fr.insalyon.hexarem.ihm;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Arnaud on 03/01/2018.
 */


public class SettingsFragment extends PreferenceFragment {

    private ActionBar actionBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public PreferenceFragment setActionBar(ActionBar mActionBar){
        this.actionBar=mActionBar;
        return this;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);

        }
    }
}
