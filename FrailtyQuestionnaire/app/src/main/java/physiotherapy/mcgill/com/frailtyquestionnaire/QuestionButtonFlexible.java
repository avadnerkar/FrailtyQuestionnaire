package physiotherapy.mcgill.com.frailtyquestionnaire;

import android.app.ActionBar;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Abhishek Vadnerkar on 15-11-04.
 */
public class QuestionButtonFlexible {

    public QuestionButtonFlexible(Context context, int sectionNum, int questionNum, final QuestionnaireActivity.Handler handler){

        QuestionnaireActivity.containerLayout.removeAllViews();
        final ItemQuestion question = DataSource.sections.get(sectionNum).questions.get(questionNum);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.cell_button_flexible, QuestionnaireActivity.containerLayout, true);

        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText(question.title);

        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.button_container);

        for (int i=0; i<question.options.length; i++){
            Button button = new Button(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);
            layoutParams.setMargins(0, 10, 0, 10);
            button.setLayoutParams(layoutParams);
            button.setText(question.options[i]);
            button.setBackground(ContextCompat.getDrawable(context, R.drawable.button_primary));
            linearLayout.addView(button);

//            if (i<question.options.length-1){
//                View space = new View(context);
//                space.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
//                linearLayout.addView(space);
//            }
        }

    }

}
