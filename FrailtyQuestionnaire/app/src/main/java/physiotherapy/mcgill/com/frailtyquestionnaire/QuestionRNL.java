package physiotherapy.mcgill.com.frailtyquestionnaire;

import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Abhishek Vadnerkar on 15-10-31.
 */
public class QuestionRNL {

    public QuestionRNL(Context context, int sectionNum, int questionNum, final QuestionnaireActivity.PlaceholderFragment.Handler handler){

        QuestionnaireActivity.PlaceholderFragment.containerLayout.removeAllViews();
        ItemQuestion question = DataSource.sections.get(sectionNum).questions.get(questionNum);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.cell_rnl, QuestionnaireActivity.PlaceholderFragment.containerLayout, true);

        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText(question.title);

        TextView subtitle = (TextView) view.findViewById(R.id.subtitle);
        subtitle.setText(question.subtitle);

        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Debug", "Button clicked");
                handler.showNext();
            }
        });
    }

}
