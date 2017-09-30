package hk.ust.cse.comp107x.movies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mtoolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar); //3sshan yrun el option menu wel title
    }@Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater mMenuInflater=getMenuInflater();
        mMenuInflater.inflate(R.menu.mymenu,menu);
        return true;
        //super
        //.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_setting)
            Toast.makeText(MainActivity.this,
                    "You have clicked on action setting menu",
                    Toast.LENGTH_SHORT)
                    .show();

        if (item.getItemId() == R.id.action_about_us){

            Toast.makeText(MainActivity.this,
                    "You have clicked on action about us menu",
                    Toast.LENGTH_SHORT)
                    .show();
        }
        return super.onOptionsItemSelected(item);

    }

}
