package physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import physiotherapy.mcgill.com.frailtyquestionnaire.Activities.HomeActivity;
import physiotherapy.mcgill.com.frailtyquestionnaire.Activities.QuestionnaireActivity;
import physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers.ItemQuestion;
import physiotherapy.mcgill.com.frailtyquestionnaire.R;

/**
 * Created by Abhishek Vadnerkar on 15-12-22.
 */
public class QuestionGripStrength {

    public QuestionGripStrength(Context context, int sectionNum, int questionNum, final QuestionnaireActivity.QuestionHandler questionHandler){

        QuestionnaireActivity.containerLayout.removeAllViews();
        final ItemQuestion question = QuestionnaireActivity.sections.get(sectionNum).questions.get(questionNum);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.cell_grip_strength, QuestionnaireActivity.containerLayout, true);

        final EditText editLeft1 = (EditText) view.findViewById(R.id.left1);
        final EditText editLeft2 = (EditText) view.findViewById(R.id.left2);
        final EditText editLeft3 = (EditText) view.findViewById(R.id.left3);
        final EditText editRight1 = (EditText) view.findViewById(R.id.right1);
        final EditText editRight2 = (EditText) view.findViewById(R.id.right2);
        final EditText editRight3 = (EditText) view.findViewById(R.id.right3);


        Cursor cursor = HomeActivity.myDb.getFields(HomeActivity.currentPatientID, question.dbKey);
        if (cursor.moveToFirst()){
            String left1 = cursor.getString(0);
            if (left1 != null){
                editLeft1.setText(left1);
            }

            String left2 = cursor.getString(1);
            if (left2 != null){
                editLeft2.setText(left2);
            }

            String left3 = cursor.getString(2);
            if (left3 != null){
                editLeft3.setText(left3);
            }

            String right1 = cursor.getString(3);
            if (right1 != null){
                editRight1.setText(right1);
            }

            String right2 = cursor.getString(4);
            if (right2 != null){
                editRight2.setText(right2);
            }

            String right3 = cursor.getString(5);
            if (right3 != null){
                editRight3.setText(right3);
            }
        }


        Button buttonNext = (Button) view.findViewById(R.id.button);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(){
                    @Override
                    public void run() {

                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[0], editLeft1.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[1], editLeft2.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[2], editLeft3.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[3], editRight1.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[4], editRight2.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[5], editRight3.getText().toString());

                    }
                };
                thread.start();
                questionHandler.showNext();
            }
        });

    }

}
