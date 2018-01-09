package fr.insalyon.hexarem.ihm;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.preference.PreferenceFragmentCompat;

/**
 * Created by Arnaud on 03/01/2018.
 */


public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferences);
    }


    @Override
    public void onPause() {
        super.onPause();
    }
}
