package physiotherapy.mcgill.com.frailtyquestionnaire;

import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;
import android.widget.FrameLayout;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class QuestionnaireActivity extends AppCompatActivity
        implements DrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private DrawerFragment mNavigationDrawerFragment;
    public static Context context;
    public static int sectionNumber;
    public static int questionNumber;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    public static FrameLayout containerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        context = this;
        mNavigationDrawerFragment = (DrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        containerLayout = (FrameLayout) findViewById(R.id.container);

        sectionNumber = 0;
        questionNumber = 0;

        loadQuestion(sectionNumber, questionNumber);

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the menu_questionnaire content by replacing fragments

        sectionNumber = position;
        questionNumber = 0;

        if (containerLayout !=null){
            loadQuestion(sectionNumber, questionNumber);
        }

    }


    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.menu_questionnaire, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_undo) {
            previousQuestion();
            return true;
        }

        if (id == R.id.action_skip){

            AppUtils.showTwoButtonDialog(getResources().getString(R.string.skip_title), getResources().getString(R.string.not_applicable), getResources().getString(R.string.no_answer), this, new DialogTwoButton.ClickHandler() {
                @Override
                public void onPositiveClick() {
                    HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, DataSource.sections.get(sectionNumber).questions.get(questionNumber).dbKey, getString(R.string.not_applicable));
                    nextQuestion();
                }

                @Override
                public void onNegativeClick() {
                    HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, DataSource.sections.get(sectionNumber).questions.get(questionNumber).dbKey, getString(R.string.no_answer));
                    nextQuestion();
                }
            });
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void loadQuestion(int sectionNum, int questionNum){
        ItemQuestion question = DataSource.sections.get(sectionNum).questions.get(questionNum);
        ItemQuestion.QuestionType questionType = question.questionType;

        switch (questionType){
            case RNL:
                new QuestionRNL(context, sectionNum, questionNum, handler);
                break;
            case COMPLETION:
                new QuestionCompleted(context, sectionNum, questionNum, handler);
                break;
        }

        mTitle = DataSource.sections.get(sectionNum).title;
        restoreActionBar();
    }

    public void nextQuestion(){
        if (questionNumber < DataSource.sections.get(sectionNumber).questions.size()-1){
            questionNumber = questionNumber + 1;
            loadQuestion(sectionNumber, questionNumber);
        } else if (sectionNumber < DataSource.sections.size()-1){
            sectionNumber = sectionNumber + 1;
            questionNumber = 0;
            onNavigationDrawerItemSelected(sectionNumber);
        } else {
            //finish
            finish();
        }
    }

    public void previousQuestion(){
        if (questionNumber > 0){
            questionNumber = questionNumber - 1;
            loadQuestion(sectionNumber, questionNumber);
        } else if (sectionNumber > 0){
            sectionNumber = sectionNumber - 1;
            questionNumber = 0;
            onNavigationDrawerItemSelected(sectionNumber);
        } else {
            //Do nothing
        }
    }


    public static void exportToCSV(){
        File path = Environment.getExternalStorageDirectory();
        File filename = new File(path, "/FrailtyAnswers-" + HomeActivity.currentPatientID +".csv");

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(filename), '\t');
            writer.writeNext(new String[]{"sep=\t"});

            Cursor cursor = HomeActivity.myDb.getRowData(HomeActivity.currentPatientID);
            writer.writeNext(cursor.getColumnNames());

            if (cursor.moveToFirst()){
                ArrayList<String> values = new ArrayList<>();
                for (int i=0; i<cursor.getColumnCount(); i++){
                    values.add(cursor.getString(i));
                }
                String[] stringValues = values.toArray(new String[values.size()]);
                writer.writeNext(stringValues);
            }

            writer.close();
            cursor.close();

        } catch (IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }


    private Handler handler = new Handler() {
        @Override
        public void showNext() {
            nextQuestion();
        }

        @Override
        public void showPrevious() {

        }
    };

    public interface Handler{
        void showNext();

        void showPrevious();

    }

}
