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
 * Created by Abhishek Vadnerkar on 15-12-27.
 */
public class Question5Metre {

    public Question5Metre(Context context, int sectionNum, int questionNum, final QuestionnaireActivity.QuestionHandler questionHandler){

        QuestionnaireActivity.containerLayout.removeAllViews();
        final ItemQuestion question = QuestionnaireActivity.sections.get(sectionNum).questions.get(questionNum);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.cell_5_metre_walk, QuestionnaireActivity.containerLayout, true);


        final EditText editComfortablePace = (EditText) view.findViewById(R.id.edit_comfortable_pace);
        final EditText editAmbulatoryAid = (EditText) view.findViewById(R.id.edit_ambulatory_aid);
        final RadioGroup rgFootDrop = (RadioGroup) view.findViewById(R.id.rg_foot_drop);
        final RadioGroup rgAssistance = (RadioGroup) view.findViewById(R.id.rg_assistance);
        final EditText editComments = (EditText) view.findViewById(R.id.edit_comments);

        Cursor cursor = HomeActivity.myDb.getFields(HomeActivity.currentPatientID, question.dbKey);
        if (cursor.moveToFirst()){
            String comfortablePace = cursor.getString(0);
            if (comfortablePace != null){
                editComfortablePace.setText(comfortablePace);
            }

            String ambulatoryAid = cursor.getString(1);
            if (ambulatoryAid != null){
                editAmbulatoryAid.setText(ambulatoryAid);
            }

            String footDrop = cursor.getString(2);
            if (footDrop != null){
                RadioButton rbYes = (RadioButton) view.findViewById(R.id.foot_drop_yes);
                RadioButton rbNo = (RadioButton) view.findViewById(R.id.foot_drop_no);
                if (footDrop.equals(rbYes.getText())){
                    rgFootDrop.check(R.id.foot_drop_yes);
                } else if (footDrop.equals(rbNo.getText())){
                    rgFootDrop.check(R.id.foot_drop_no);
                }

            }


            String assistance = cursor.getString(3);
            if (assistance != null){
                RadioButton rbNone = (RadioButton) view.findViewById(R.id.assistance_none);
                RadioButton rbMinimal = (RadioButton) view.findViewById(R.id.assistance_minimal);
                RadioButton rbModerate = (RadioButton) view.findViewById(R.id.assistance_moderate);
                RadioButton rbMaximal = (RadioButton) view.findViewById(R.id.assistance_maximal);
                if (assistance.equals(rbNone.getText())){
                    rgAssistance.check(R.id.assistance_none);
                } else if (assistance.equals(rbMinimal.getText())){
                    rgAssistance.check(R.id.assistance_minimal);
                } else if (assistance.equals(rbModerate.getText())){
                    rgAssistance.check(R.id.assistance_moderate);
                } else if (assistance.equals(rbMaximal.getText())){
                    rgAssistance.check(R.id.assistance_maximal);
                }

            }

            String comments = cursor.getString(4);
            if (comments != null){
                editComments.setText(comments);
            }
        }


        Button buttonNext = (Button) view.findViewById(R.id.button);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(){
                    @Override
                    public void run() {

                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[0], editComfortablePace.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[1], editAmbulatoryAid.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[2], ((RadioButton)view.findViewById(rgFootDrop.getCheckedRadioButtonId())).getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[3], ((RadioButton)view.findViewById(rgAssistance.getCheckedRadioButtonId())).getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[4], editComments.getText().toString());

                    }
                };
                thread.start();
                questionHandler.showNext();
            }
        });

    }

}
