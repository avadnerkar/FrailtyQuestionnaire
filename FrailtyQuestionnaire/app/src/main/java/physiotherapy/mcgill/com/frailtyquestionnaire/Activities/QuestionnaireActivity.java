package physiotherapy.mcgill.com.frailtyquestionnaire.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;
import android.widget.FrameLayout;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.Question2Min;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.Question5Metre;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionAnthropometric;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionButtonFlexible;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionButtonFlexibleScrollable;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionButtonGrid;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionCompleted;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionGripStrength;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionPlusMinus;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionRadioVertical;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionSingleField;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionSitToRise;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionSlider;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionSlider100;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionSlider100Percent;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionSliderEdit;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionSliderReverse;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionSmiley;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionSocio1;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionSocio2;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionSocio3;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionSocio4;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionSocio5;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionTitle;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionTitleLong;
import physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers.QuestionVerticalJump;
import physiotherapy.mcgill.com.frailtyquestionnaire.Utilities.ActivityIndicator;
import physiotherapy.mcgill.com.frailtyquestionnaire.Utilities.AppUtils;
import physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers.DBAdapter;
import physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers.DataSource;
import physiotherapy.mcgill.com.frailtyquestionnaire.Dialogs.DialogTwoButton;
import physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers.ItemQuestion;
import physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers.ItemSection;
import physiotherapy.mcgill.com.frailtyquestionnaire.R;

public class QuestionnaireActivity extends AppCompatActivity
        implements DrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private DrawerFragment mNavigationDrawerFragment;
    public static Context context;
    public static int sectionNumber;
    public static int questionNumber;
    public static ArrayList<ItemSection> sections;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    public static FrameLayout containerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        ItemSection.Questionnaire questionnaire = (ItemSection.Questionnaire) intent.getSerializableExtra("questionnaire_name");
        switch (questionnaire){

            case NURSE:
                sections = DataSource.nurseSections();
                break;
            case EVALUATOR:
                sections = DataSource.evaluatorSections();
                break;
            case PHYSICAL:
                sections = DataSource.physicalSections();
                break;
            case SOCIO:
                sections = DataSource.socioSections();
                break;
        }
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

            if (sections.get(sectionNumber).questions.get(questionNumber).dbKey.length == 1){
                AppUtils.showTwoButtonDialog(getResources().getString(R.string.skip_title), getResources().getString(R.string.not_applicable), getResources().getString(R.string.no_answer), this, new DialogTwoButton.ClickHandler() {
                    @Override
                    public void onPositiveClick() {

                        if (sections.get(sectionNumber).questions.get(questionNumber).dbKey != null) {
                            HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, sections.get(sectionNumber).questions.get(questionNumber).dbKey[0], getString(R.string.not_applicable));

                        }
                        nextQuestion();
                    }

                    @Override
                    public void onNegativeClick() {

                        if (sections.get(sectionNumber).questions.get(questionNumber).dbKey != null) {
                            HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, sections.get(sectionNumber).questions.get(questionNumber).dbKey[0], getString(R.string.no_answer));
                        }
                        nextQuestion();
                    }
                });
            } else {
                nextQuestion();
            }


            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void loadQuestion(int sectionNum, int questionNum){
        ItemQuestion question = sections.get(sectionNum).questions.get(questionNum);
        ItemQuestion.QuestionType questionType = question.questionType;

        switch (questionType){
            case TITLE:
                new QuestionTitle(context, sectionNum, questionNum, questionHandler);
                break;
            case TITLE_LONG:
                new QuestionTitleLong(context, sectionNum, questionNum, questionHandler);
                break;
            case SLIDER:
                new QuestionSlider(context, sectionNum, questionNum, questionHandler);
                break;
            case COMPLETION:
                new QuestionCompleted(context, sectionNum, questionNum, questionHandler);
                break;
            case RADIO_VERTICAL:
                new QuestionRadioVertical(context, sectionNum, questionNum, questionHandler);
                break;
            case BUTTON_FLEXIBLE:
                new QuestionButtonFlexible(context, sectionNum, questionNum, questionHandler);
                break;
            case SLIDER_REVERSE:
                new QuestionSliderReverse(context, sectionNum, questionNum, questionHandler);
                break;
            case SLIDER_EDIT:
                new QuestionSliderEdit(context, sectionNum, questionNum, questionHandler);
                break;
            case PLUS_MINUS:
                new QuestionPlusMinus(context, sectionNum, questionNum, questionHandler);
                break;
            case SMILEY:
                new QuestionSmiley(context, sectionNum, questionNum, questionHandler);
                break;
            case SLIDER_100:
                new QuestionSlider100(context, sectionNum, questionNum, questionHandler);
                break;
            case SLIDER_100_PERCENT:
                new QuestionSlider100Percent(context, sectionNum, questionNum, questionHandler);
                break;
            case BUTTON_GRID:
                new QuestionButtonGrid(context, sectionNum, questionNum, questionHandler);
                break;
            case ANTHROPOMETRIC:
                new QuestionAnthropometric(context, sectionNum, questionNum, questionHandler);
                break;
            case GRIP_STRENGTH:
                new QuestionGripStrength(context, sectionNum, questionNum, questionHandler);
                break;
            case VERTICAL_JUMP:
                new QuestionVerticalJump(context, sectionNum, questionNum, questionHandler);
                break;
            case BUTTON_FLEXIBLE_SCROLLABLE:
                new QuestionButtonFlexibleScrollable(context, sectionNum, questionNum, questionHandler);
                break;
            case SINGLE_FIELD:
                new QuestionSingleField(context, sectionNum, questionNum, questionHandler);
                break;
            case TEST_5_METRE:
                new Question5Metre(context, sectionNum, questionNum, questionHandler);
                break;
            case TEST_2_MIN:
                new Question2Min(context, sectionNum, questionNum, questionHandler);
                break;
            case SIT_TO_RISE:
                new QuestionSitToRise(context, sectionNum, questionNum, questionHandler);
                break;
            case FORM_SOCIO1:
                new QuestionSocio1(context, sectionNum, questionNum, questionHandler);
                break;
            case FORM_SOCIO2:
                new QuestionSocio2(context, sectionNum, questionNum, questionHandler);
                break;
            case FORM_SOCIO3:
                new QuestionSocio3(context, sectionNum, questionNum, questionHandler);
                break;
            case FORM_SOCIO4:
                new QuestionSocio4(context, sectionNum, questionNum, questionHandler);
                break;
            case FORM_SOCIO5:
                new QuestionSocio5(context, sectionNum, questionNum, questionHandler);
                break;
        }

        mTitle = sections.get(sectionNum).title;
        restoreActionBar();
    }

    public void nextQuestion(){

        ActivityIndicator.showProgressDialog((Activity) context);
        Handler delayedHandler = new Handler();
        delayedHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (questionNumber < sections.get(sectionNumber).questions.size()-1){
                    questionNumber = questionNumber + 1;
                    loadQuestion(sectionNumber, questionNumber);
                } else if (sectionNumber < sections.size()-1){
                    sectionNumber = sectionNumber + 1;
                    questionNumber = 0;
                    onNavigationDrawerItemSelected(sectionNumber);
                } else {
                    //finish
                    finish();
                }

                ActivityIndicator.dismissProgressDialog();
            }
        }, 1000);


    }

    public void previousQuestion(){

        ActivityIndicator.showProgressDialog((Activity) context);
        Handler delayedHandler = new Handler();
        delayedHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (questionNumber > 0){
                    questionNumber = questionNumber - 1;
                    loadQuestion(sectionNumber, questionNumber);
                } else if (sectionNumber > 0){
                    sectionNumber = sectionNumber - 1;
                    onNavigationDrawerItemSelected(sectionNumber);
                    questionNumber = sections.get(sectionNumber).questions.size() - 1;
                    loadQuestion(sectionNumber, questionNumber);
                } else {
                    //Do nothing
                }

                ActivityIndicator.dismissProgressDialog();
            }
        }, 1000);
    }


    public static void exportToCSV(){

        ArrayList<String> keyList = new ArrayList<>();
        keyList.add(DBAdapter.KEY_ROWID);
        keyList.add(DBAdapter.KEY_EVALUATOR);
        keyList.add(DBAdapter.KEY_HOSPITALID);
        keyList.add(DBAdapter.KEY_DATE);
        keyList.add(DBAdapter.KEY_LANGUAGE);
        for (ItemSection section : DataSource.sections){
            for (ItemQuestion question : section.questions){
                if (question.dbKey != null){
                    Collections.addAll(keyList, question.dbKey);
                }
            }
        }

        String[] keys = keyList.toArray(new String[keyList.size()]);

        Cursor cursor = HomeActivity.myDb.getColumns(keys);
        cursor.moveToFirst();

        File path = Environment.getExternalStorageDirectory();
        File filename = new File(path, "/FrailtyAnswers-" + cursor.getString(cursor.getColumnIndex(DBAdapter.KEY_HOSPITALID)) +".csv");

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(filename), '\t');
            writer.writeNext(new String[]{"sep=\t"});

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


    private QuestionHandler questionHandler = new QuestionHandler() {
        @Override
        public void showNext() {
            nextQuestion();

        }

        @Override
        public void showPrevious() {

        }
    };

    public interface QuestionHandler {
        void showNext();

        void showPrevious();

    }

}
