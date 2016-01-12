package physiotherapy.mcgill.com.frailtyquestionnaire.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers.DBAdapter;
import physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers.DataSource;
import physiotherapy.mcgill.com.frailtyquestionnaire.Dialogs.DialogDisclaimer;
import physiotherapy.mcgill.com.frailtyquestionnaire.Dialogs.DialogQuestionnaireSelector;
import physiotherapy.mcgill.com.frailtyquestionnaire.Dialogs.DialogSimple;
import physiotherapy.mcgill.com.frailtyquestionnaire.Dialogs.DialogTwoButton;
import physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers.ItemSection;
import physiotherapy.mcgill.com.frailtyquestionnaire.R;
import physiotherapy.mcgill.com.frailtyquestionnaire.Utilities.AppUtils;

public class HomeActivity extends Activity {

    public static DBAdapter myDb;
    public static long currentPatientID;
    public Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        context = this;
        DataSource.init(this);
        myDb = new DBAdapter(this);
        myDb.open();

        EditText editEvaluator = (EditText) findViewById(R.id.evaluator);
        EditText editSubjectId = (EditText) findViewById(R.id.subject_id);

        editEvaluator.setText("");
        editSubjectId.setText("");

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

        EditText editEvaluator = (EditText) findViewById(R.id.evaluator);
        EditText editSubjectId = (EditText) findViewById(R.id.subject_id);

        final String evaluator = editEvaluator.getText().toString();
        final String subjectId = editSubjectId.getText().toString();

        if (subjectId.equals("")){
            AppUtils.showPopup(getString(R.string.error_id), context);
            return;
        }

        Cursor cursor = myDb.getColumns(new String[]{DBAdapter.KEY_ROWID, DBAdapter.KEY_HOSPITALID});
        if (cursor.moveToFirst()){
            do {
                if (cursor.getString(1).equals(subjectId)){
                    final int id = cursor.getInt(0);
                    DialogTwoButton.ClickHandler clickHandler = new DialogTwoButton.ClickHandler() {
                        @Override
                        public void onPositiveClick() {
                            currentPatientID = id;
                            showQuestionnaireSelector();
                        }

                        @Override
                        public void onNegativeClick() {

                        }
                    };
                    String titleFormat = context.getString(R.string.patient_already_exists);
                    String title = String.format(titleFormat, subjectId);
                    AppUtils.showTwoButtonDialog(title, getString(R.string.yes), getString(R.string.cancel), context, clickHandler);
                    return;
                }
            } while (cursor.moveToNext());
        }


        DialogDisclaimer.ClickHandler handler = new DialogDisclaimer.ClickHandler() {
            @Override
            public void onSuccess() {

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

                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                String formattedDate = df.format(c.getTime());

                currentPatientID = myDb.createData(evaluator, subjectId, formattedDate, language);

                showQuestionnaireSelector();

            }

            @Override
            public void onFailure() {
                DialogSimple dialog = new DialogSimple(context);
                //dialog.setTitle(context.getString(R.string.disclaimer_error));
                dialog.show();
                TextView title = (TextView) dialog.findViewById(R.id.dialog_title);
                title.setText(context.getString(R.string.disclaimer_error));
            }
        };
        DialogDisclaimer dialog = new DialogDisclaimer(this, handler);
        dialog.show();

    }

    public void showQuestionnaireSelector(){
        final Intent intent = new Intent(context, QuestionnaireActivity.class);
        DialogQuestionnaireSelector.ClickHandler selectHandler = new DialogQuestionnaireSelector.ClickHandler() {
            @Override
            public void onSocioClick() {
                intent.putExtra("questionnaire_name", ItemSection.Questionnaire.SOCIO);
                startActivity(intent);
            }

            @Override
            public void onNurseClick() {
                intent.putExtra("questionnaire_name", ItemSection.Questionnaire.NURSE);
                startActivity(intent);
            }

            @Override
            public void onEvaluatorClick() {
                intent.putExtra("questionnaire_name", ItemSection.Questionnaire.EVALUATOR);
                startActivity(intent);
            }

            @Override
            public void onPhysicalClick() {
                intent.putExtra("questionnaire_name", ItemSection.Questionnaire.PHYSICAL);
                startActivity(intent);
            }
        };
        DialogQuestionnaireSelector selectorDialog = new DialogQuestionnaireSelector(context, selectHandler);
        selectorDialog.show();
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
