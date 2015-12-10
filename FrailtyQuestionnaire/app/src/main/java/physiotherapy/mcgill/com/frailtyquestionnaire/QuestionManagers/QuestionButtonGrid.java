package physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import physiotherapy.mcgill.com.frailtyquestionnaire.Activities.QuestionnaireActivity;
import physiotherapy.mcgill.com.frailtyquestionnaire.Activities.HomeActivity;
import physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers.ItemQuestion;
import physiotherapy.mcgill.com.frailtyquestionnaire.R;

/**
 * Created by Abhishek Vadnerkar on 15-12-06.
 */
public class QuestionButtonGrid {

    public QuestionButtonGrid(Context context, int sectionNum, int questionNum, final QuestionnaireActivity.QuestionHandler questionHandler){

        QuestionnaireActivity.containerLayout.removeAllViews();
        final ItemQuestion question = QuestionnaireActivity.sections.get(sectionNum).questions.get(questionNum);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.cell_grid_28, QuestionnaireActivity.containerLayout, true);

        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText(question.title);

        TextView subtitle = (TextView) view.findViewById(R.id.subtitle);
        subtitle.setText(question.subtitle);

        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.button_container);

        for (int i=0; i<4; i++){

            LinearLayout subLayout = new LinearLayout(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);
            layoutParams.setMargins(0, 5, 0, 5);
            subLayout.setLayoutParams(layoutParams);
            linearLayout.addView(subLayout);

            for (int j=0; j<7; j++){
                Button button = new Button(context);
                LinearLayout.LayoutParams subLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
                subLayoutParams.setMargins(5, 0, 5, 0);
                button.setLayoutParams(subLayoutParams);
                button.setText(String.valueOf(i*7+j+1));button.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.text_medium));
                button.setBackground(ContextCompat.getDrawable(context, R.drawable.button_primary));
                button.setTransformationMethod(null);

                subLayout.addView(button);
                final String dbValueFinal = button.getText().toString();

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Thread thread = new Thread() {
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
}
