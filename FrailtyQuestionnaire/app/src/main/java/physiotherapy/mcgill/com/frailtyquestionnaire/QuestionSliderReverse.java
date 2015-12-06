package physiotherapy.mcgill.com.frailtyquestionnaire;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Abhishek Vadnerkar on 15-11-04.
 */
public class QuestionSliderReverse {

    public QuestionSliderReverse(Context context, int sectionNum, int questionNum, final QuestionnaireActivity.QuestionHandler questionHandler){

        QuestionnaireActivity.containerLayout.removeAllViews();
        final ItemQuestion question = QuestionnaireActivity.sections.get(sectionNum).questions.get(questionNum);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.cell_10_point_reverse, QuestionnaireActivity.containerLayout, true);

        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText(question.title);

        TextView subtitle = (TextView) view.findViewById(R.id.subtitle);
        subtitle.setText(question.subtitle);

        TextView option1 = (TextView) view.findViewById(R.id.descriptor1);
        TextView option2 = (TextView) view.findViewById(R.id.descriptor2);

        option1.setText(question.options[0]);
        option2.setText(question.options[1]);

        final SeekBar seekBar = (SeekBar) view.findViewById(R.id.intensitySlider);
        Cursor cursor = HomeActivity.myDb.getField(HomeActivity.currentPatientID, question.dbKey[0]);
        if (cursor.moveToFirst()){
            int progress = cursor.getInt(0);
            seekBar.setProgress(progress);
        }

        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[0], String.valueOf(seekBar.getProgress()));
                    }
                };
                thread.start();

                questionHandler.showNext();
            }
        });
    }
}
