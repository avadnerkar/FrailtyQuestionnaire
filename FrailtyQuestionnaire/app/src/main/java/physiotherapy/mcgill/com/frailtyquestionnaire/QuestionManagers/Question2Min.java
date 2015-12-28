package physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import physiotherapy.mcgill.com.frailtyquestionnaire.Activities.HomeActivity;
import physiotherapy.mcgill.com.frailtyquestionnaire.Activities.QuestionnaireActivity;
import physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers.ItemQuestion;
import physiotherapy.mcgill.com.frailtyquestionnaire.R;

/**
 * Created by Abhishek Vadnerkar on 15-12-28.
 */
public class Question2Min {

    public Question2Min(Context context, int sectionNum, int questionNum, final QuestionnaireActivity.QuestionHandler questionHandler){

        QuestionnaireActivity.containerLayout.removeAllViews();
        final ItemQuestion question = QuestionnaireActivity.sections.get(sectionNum).questions.get(questionNum);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.cell_2min_walk, QuestionnaireActivity.containerLayout, true);


        final EditText editDistance = (EditText) view.findViewById(R.id.edit_distance);
        final EditText editAmbulatoryAid = (EditText) view.findViewById(R.id.edit_ambulatory_aid);
        final EditText editNumFalls = (EditText) view.findViewById(R.id.edit_number_falls);

        Cursor cursor = HomeActivity.myDb.getFields(HomeActivity.currentPatientID, question.dbKey);
        if (cursor.moveToFirst()){
            String distance = cursor.getString(0);
            if (distance != null){
                editDistance.setText(distance);
            }

            String ambulatoryAid = cursor.getString(1);
            if (ambulatoryAid != null){
                editAmbulatoryAid.setText(ambulatoryAid);
            }

            String numFalls = cursor.getString(2);
            if (numFalls != null){
                editNumFalls.setText(numFalls);
            }
        }


        Button buttonNext = (Button) view.findViewById(R.id.button);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(){
                    @Override
                    public void run() {

                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[0], editDistance.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[1], editAmbulatoryAid.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[2], editNumFalls.getText().toString());

                    }
                };
                thread.start();
                questionHandler.showNext();
            }
        });

    }

}
