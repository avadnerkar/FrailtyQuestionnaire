package physiotherapy.mcgill.com.frailtyquestionnaire;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Abhishek Vadnerkar on 15-11-02.
 */
public class QuestionCompleted {

    public QuestionCompleted(Context context, int sectionNum, int questionNum, final QuestionnaireActivity.Handler handler){

        QuestionnaireActivity.containerLayout.removeAllViews();
        final ItemQuestion question = DataSource.sections.get(sectionNum).questions.get(questionNum);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.cell_completed, QuestionnaireActivity.containerLayout, true);

        Button button = (Button) view.findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestionnaireActivity.exportToCSV();
                handler.showNext();
            }
        });
    }

}
