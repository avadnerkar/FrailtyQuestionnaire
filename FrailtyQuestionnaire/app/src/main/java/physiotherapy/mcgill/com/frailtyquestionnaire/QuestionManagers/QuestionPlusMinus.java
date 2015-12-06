package physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import physiotherapy.mcgill.com.frailtyquestionnaire.Activities.QuestionnaireActivity;
import physiotherapy.mcgill.com.frailtyquestionnaire.Activities.HomeActivity;
import physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers.ItemQuestion;
import physiotherapy.mcgill.com.frailtyquestionnaire.R;

/**
 * Created by Abhishek Vadnerkar on 15-11-05.
 */
public class QuestionPlusMinus {

    static int number;

    public QuestionPlusMinus(Context context, int sectionNum, int questionNum, final QuestionnaireActivity.QuestionHandler questionHandler){

        QuestionnaireActivity.containerLayout.removeAllViews();
        final ItemQuestion question = QuestionnaireActivity.sections.get(sectionNum).questions.get(questionNum);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.cell_plus_minus, QuestionnaireActivity.containerLayout, true);

        number = 0;

        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText(question.title);

        final TextView textView = (TextView) view.findViewById(R.id.number);
        textView.setText(String.valueOf(number));

        Button plus = (Button) view.findViewById(R.id.button_plus);
        Button minus = (Button) view.findViewById(R.id.button_minus);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Math.min(50, number + 1);
                textView.setText(String.valueOf(number));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Math.max(0, number - 1);
                textView.setText(String.valueOf(number));
            }
        });


        Button next = (Button) view.findViewById(R.id.button);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[0], textView.getText().toString());
                    }
                };
                thread.start();

                questionHandler.showNext();
            }
        });
    }
}
