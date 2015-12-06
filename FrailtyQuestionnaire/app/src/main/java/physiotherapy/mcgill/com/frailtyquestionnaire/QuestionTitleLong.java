package physiotherapy.mcgill.com.frailtyquestionnaire;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Abhishek Vadnerkar on 15-12-05.
 */
public class QuestionTitleLong {

    public QuestionTitleLong(Context context, int sectionNum, int questionNum, final QuestionnaireActivity.QuestionHandler questionHandler){

        QuestionnaireActivity.containerLayout.removeAllViews();
        final ItemQuestion question = QuestionnaireActivity.sections.get(sectionNum).questions.get(questionNum);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.cell_section_title_long, QuestionnaireActivity.containerLayout, true);

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
