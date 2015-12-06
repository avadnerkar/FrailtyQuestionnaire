package physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import physiotherapy.mcgill.com.frailtyquestionnaire.Activities.QuestionnaireActivity;
import physiotherapy.mcgill.com.frailtyquestionnaire.Activities.HomeActivity;
import physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers.ItemQuestion;
import physiotherapy.mcgill.com.frailtyquestionnaire.R;

/**
 * Created by Abhishek Vadnerkar on 15-11-05.
 */
public class QuestionSmiley {

    public QuestionSmiley(Context context, int sectionNum, int questionNum, final QuestionnaireActivity.QuestionHandler questionHandler){

        QuestionnaireActivity.containerLayout.removeAllViews();
        final ItemQuestion question = QuestionnaireActivity.sections.get(sectionNum).questions.get(questionNum);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.cell_smiley, QuestionnaireActivity.containerLayout, true);


        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText(question.title);


        ImageButton button1 = (ImageButton) view.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion(1, question, questionHandler);
            }
        });

        ImageButton button2 = (ImageButton) view.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion(2, question, questionHandler);
            }
        });

        ImageButton button3 = (ImageButton) view.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion(3, question, questionHandler);
            }
        });

        ImageButton button4 = (ImageButton) view.findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion(4, question, questionHandler);
            }
        });

        ImageButton button5 = (ImageButton) view.findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion(5, question, questionHandler);
            }
        });

        ImageButton button6 = (ImageButton) view.findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion(6, question, questionHandler);
            }
        });

        ImageButton button7 = (ImageButton) view.findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion(7, question, questionHandler);
            }
        });

    }


    public void nextQuestion(final int score, final ItemQuestion question, final QuestionnaireActivity.QuestionHandler questionHandler){
        Thread thread = new Thread(){
            @Override
            public void run() {
                HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[0], String.valueOf(score));
            }
        };
        thread.start();

        questionHandler.showNext();
    }

}
