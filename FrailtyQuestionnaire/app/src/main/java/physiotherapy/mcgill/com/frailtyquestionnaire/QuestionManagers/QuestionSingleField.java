package physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import physiotherapy.mcgill.com.frailtyquestionnaire.Activities.HomeActivity;
import physiotherapy.mcgill.com.frailtyquestionnaire.Activities.QuestionnaireActivity;
import physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers.ItemQuestion;
import physiotherapy.mcgill.com.frailtyquestionnaire.R;

/**
 * Created by Abhishek Vadnerkar on 15-12-23.
 */
public class QuestionSingleField {

    public QuestionSingleField(Context context, int sectionNum, int questionNum, final QuestionnaireActivity.QuestionHandler questionHandler){

        QuestionnaireActivity.containerLayout.removeAllViews();
        final ItemQuestion question = QuestionnaireActivity.sections.get(sectionNum).questions.get(questionNum);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.cell_single_field, QuestionnaireActivity.containerLayout, true);

        final TextView title = (TextView) view.findViewById(R.id.title);
        title.setText(question.title);

        final EditText field = (EditText) view.findViewById(R.id.field);

        Cursor cursor = HomeActivity.myDb.getFields(HomeActivity.currentPatientID, question.dbKey);
        if (cursor.moveToFirst()){
            String text = cursor.getString(0);
            if (text != null){
                field.setText(text);
            }
        }


        Button buttonNext = (Button) view.findViewById(R.id.button);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(){
                    @Override
                    public void run() {

                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[0], field.getText().toString());

                    }
                };
                thread.start();
                questionHandler.showNext();
            }
        });

    }

}
