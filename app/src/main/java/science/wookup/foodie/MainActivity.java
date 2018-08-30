package science.wookup.foodie;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends LoggingActivity implements ListAdapter.OnFoodClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListFragment savedFragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.placeholder);

        if (savedFragment == null) {
            ListFragment listFragment = new ListFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.placeholder, listFragment);
            fragmentTransaction.commit();
        }

    }

    @Override
    public void onFoodClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_POSITION, position);
        ViewPagerFragment viewPagerFragment = new ViewPagerFragment();
        viewPagerFragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeholder, viewPagerFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
