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
 * Created by Abhishek Vadnerkar on 15-12-23.
 */
public class QuestionVerticalJump {

    public QuestionVerticalJump(Context context, int sectionNum, int questionNum, final QuestionnaireActivity.QuestionHandler questionHandler){

        QuestionnaireActivity.containerLayout.removeAllViews();
        final ItemQuestion question = QuestionnaireActivity.sections.get(sectionNum).questions.get(questionNum);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.cell_vertical_jump, QuestionnaireActivity.containerLayout, true);

        final EditText editJump1 = (EditText) view.findViewById(R.id.jump1);
        final EditText editJump2 = (EditText) view.findViewById(R.id.jump2);
        final EditText editJump3 = (EditText) view.findViewById(R.id.jump3);


        Cursor cursor = HomeActivity.myDb.getFields(HomeActivity.currentPatientID, question.dbKey);
        if (cursor.moveToFirst()){
            String jump1 = cursor.getString(0);
            if (jump1 != null){
                editJump1.setText(jump1);
            }

            String jump2 = cursor.getString(1);
            if (jump2 != null){
                editJump2.setText(jump2);
            }

            String jump3 = cursor.getString(2);
            if (jump3 != null){
                editJump3.setText(jump3);
            }

        }


        Button buttonNext = (Button) view.findViewById(R.id.button);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(){
                    @Override
                    public void run() {

                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[0], editJump1.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[1], editJump2.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[2], editJump3.getText().toString());

                    }
                };
                thread.start();
                questionHandler.showNext();
            }
        });

    }

}
