package physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import physiotherapy.mcgill.com.frailtyquestionnaire.Activities.QuestionnaireActivity;
import physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers.ItemQuestion;
import physiotherapy.mcgill.com.frailtyquestionnaire.R;

/**
 * Created by Abhishek Vadnerkar on 15-11-14.
 */
public class QuestionTitle {

    public QuestionTitle(Context context, int sectionNum, int questionNum, final QuestionnaireActivity.QuestionHandler questionHandler){

        QuestionnaireActivity.containerLayout.removeAllViews();
        final ItemQuestion question = QuestionnaireActivity.sections.get(sectionNum).questions.get(questionNum);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.cell_section_titlepage, QuestionnaireActivity.containerLayout, true);

        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText(question.title);

        TextView description = (TextView) view.findViewById(R.id.description);
        if (question.subtitle == null){
            description.setVisibility(View.GONE);
        } else {
            description.setText(question.subtitle);
        }


        Button button = (Button) view.findViewById(R.id.button_next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionHandler.showNext();
            }
        });
    }
}
