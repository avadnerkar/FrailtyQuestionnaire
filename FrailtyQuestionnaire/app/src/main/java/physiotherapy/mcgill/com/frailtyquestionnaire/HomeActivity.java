package physiotherapy.mcgill.com.frailtyquestionnaire;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.Locale;

public class HomeActivity extends Activity {

    public static DBAdapter myDb;
    public static long currentPatientID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        DataSource.init(this);
        myDb = new DBAdapter(this);
        myDb.open();

        EditText editFirstName = (EditText) findViewById(R.id.first_name);
        EditText editLastName = (EditText) findViewById(R.id.last_name);
        EditText editHospitalID = (EditText) findViewById(R.id.hospital_id);

        editFirstName.setText("");
        editLastName.setText("");
        editHospitalID.setText("");

        RadioGroup rg = (RadioGroup) findViewById(R.id.language);
        rg.check(R.id.english);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDb.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void startQuestionnaire(View view) {

        EditText editFirstName = (EditText) findViewById(R.id.first_name);
        EditText editLastName = (EditText) findViewById(R.id.last_name);
        EditText editHospitalID = (EditText) findViewById(R.id.hospital_id);

        String firstName = editFirstName.getText().toString();
        String lastName = editLastName.getText().toString();
        String hospitalID = editHospitalID.getText().toString();



        RadioGroup rg = (RadioGroup) findViewById(R.id.language);
        String language;
        int id = rg.getCheckedRadioButtonId();
        if (id == R.id.english){
            setLocale("en");
            language = getString(R.string.english);
        } else{
            setLocale("fr");
            language = getString(R.string.french);
        }

        currentPatientID = myDb.createData(firstName, lastName, hospitalID, language);

        Intent intent = new Intent(this, QuestionnaireActivity.class);
        startActivity(intent);

    }

    public void continueQuestionnaire(View view) {

        Intent intent = new Intent(this, SelectPatientActivity.class);
        startActivity(intent);
    }



    public void setLocale(String lang) {

        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);

    }
}
