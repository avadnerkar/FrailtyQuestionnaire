package physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import physiotherapy.mcgill.com.frailtyquestionnaire.Activities.QuestionnaireActivity;
import physiotherapy.mcgill.com.frailtyquestionnaire.Activities.HomeActivity;
import physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers.ItemQuestion;
import physiotherapy.mcgill.com.frailtyquestionnaire.R;

/**
 * Created by Abhishek Vadnerkar on 15-11-04.
 */
public class QuestionButtonFlexible {

    public QuestionButtonFlexible(Context context, int sectionNum, int questionNum, final QuestionnaireActivity.QuestionHandler questionHandler){

        QuestionnaireActivity.containerLayout.removeAllViews();
        final ItemQuestion question = QuestionnaireActivity.sections.get(sectionNum).questions.get(questionNum);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.cell_button_flexible, QuestionnaireActivity.containerLayout, true);

        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText(question.title);

        TextView subtitle = (TextView) view.findViewById(R.id.subtitle);
        if (question.subtitle != null){
            subtitle.setText(question.subtitle);
        } else {
            subtitle.setVisibility(View.GONE);
        }

        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.button_container);

        for (int i=0; i<question.options.length; i++){
            Button button = new Button(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);
            layoutParams.setMargins(0, 10, 0, 10);
            button.setLayoutParams(layoutParams);
            button.setText(question.options[i]);
            button.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.text_medium));
            button.setBackground(ContextCompat.getDrawable(context, R.drawable.button_primary));
            button.setTransformationMethod(null);
            linearLayout.addView(button);

            String dbValue = null;
            if (question.dbValues == null){
                dbValue = question.options[i];
            } else if (question.dbValues[i] instanceof Integer){
                dbValue = String.valueOf(question.dbValues[i]);
            } else if (question.dbValues[i] instanceof String){
                dbValue = (String) question.dbValues[i];
            }
            final String dbValueFinal = dbValue;

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Thread thread = new Thread(){
                        @Override
                        public void run() {
                            HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[0], dbValueFinal);
                        }
                    };
                    thread.start();

                    questionHandler.showNext();
                }
            });

        }

    }

}
