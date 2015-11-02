package physiotherapy.mcgill.com.frailtyquestionnaire;

import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

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
        // update the main content by replacing fragments

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
            getMenuInflater().inflate(R.menu.main, menu);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
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
