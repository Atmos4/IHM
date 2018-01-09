package fr.insalyon.hexarem.ihm;



import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

/**
 * The main activity of the application, handling the fragments and managing the logic of the program core
 * @author Arnaud
 * @see fr.insalyon.hexarem.ihm.HomeFragment
 * @see fr.insalyon.hexarem.ihm.StatsFragment
 * @see fr.insalyon.hexarem.ihm.ChallengeFragment
 */
public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private int navBarSelectedId =R.id.navigation_home;
    /**
     * The toolbar on top of the screen
     */
    private Toolbar myToolbar;
    /**
     * The navigation bar at the bottom of the screen
     */
    private BottomNavigationView bottomNavigation;
    /**
     * Currently active fragment
     */
    private Fragment fragment;
    /**
     * The Fragment manager that will handle fragment transaction(e.g. handling dynamic transitions)
     */
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting up the toolbar (top)
        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitle(R.string.title_home);


        //Setting up the fragment that will first be displayed -> HomeFragment
        fragment = new HomeFragment();
        fragmentManager = getSupportFragmentManager();
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_content, fragment).commit();

        //Setting up the navigation bar (bottom)
        bottomNavigation = findViewById(R.id.navigation);
        bottomNavigation.setSelectedItemId(R.id.navigation_home);
        //Handling clicks on the nav bar
        bottomNavigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, loads the SettingsFragment
                if (myToolbar.getTitle().equals("Paramètres"))
                    return true;
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                myToolbar.setTitle(R.string.action_settings);
                navBarSelectedId =0;
                fragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_top,R.anim.slide_out_bottom,R.anim.slide_in_bottom,R.anim.slide_out_top)
                        .replace(R.id.main_content, new SettingsFragment())
                        .commit();
                return true;

            case android.R.id.home:
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                myToolbar.setTitle(R.string.title_home);
                fragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_top,R.anim.slide_in_top,R.anim.slide_out_bottom)
                        .replace(R.id.main_content, new HomeFragment())
                        .commit();
                return true;



            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Quitter l'application")
                .setMessage("Vous partez si vite ?")
                .setPositiveButton("Hélas oui", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("Non, bien sûr", null)
                .show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (navBarSelectedId == item.getItemId())
            return true;

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        navBarSelectedId = item.getItemId();
        boolean slideRight = false;

        switch (navBarSelectedId){
            case R.id.navigation_challenge:
                fragment = new ChallengeFragment();
                myToolbar.setTitle(R.string.title_challenge);
                break;
            case R.id.navigation_stats:
                fragment = new StatsFragment();
                myToolbar.setTitle(R.string.title_stats);
                break;
            default:
                fragment = new HomeFragment();
                myToolbar.setTitle(R.string.title_home);
                break;
        }
        //Loading the fragment in the main_content layout
        fragmentManager.beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out)
                .replace(R.id.main_content, fragment)
                .commit();
        return true;
    }
}
