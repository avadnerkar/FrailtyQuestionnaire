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

        GridLayout gridLayout = (GridLayout) view.findViewById(R.id.button_container);
        int margin = 5;
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
        layoutParams.setMargins(margin, margin, margin, margin);

        for (int i=0, r=0, c = 0; i<28; i++, c++){

            if (c==7){
                c=0;
                r++;
            }
            Button button = new Button(context);
            //ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            layoutParams.columnSpec = GridLayout.spec(c);
            layoutParams.rowSpec = GridLayout.spec(r);
            //layoutParams.setGravity(Gravity.RIGHT);
            //layoutParams.height = (gridLayout.getHeight()-gridLayout.getPaddingTop() - gridLayout.getPaddingBottom())/gridLayout.getRowCount() - 2*margin;
            //layoutParams.width = (gridLayout.getWidth() - gridLayout.getPaddingLeft() - gridLayout.getPaddingRight())/gridLayout.getColumnCount() - 2*margin;
            //layoutParams.height = 50;
            //layoutParams.width = 50;
            button.setLayoutParams(layoutParams);
            button.setText(String.valueOf(i + 1));
            button.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.text_medium));
            button.setBackground(ContextCompat.getDrawable(context, R.drawable.button_primary));
            button.setTransformationMethod(null);
            gridLayout.addView(button);

            final String dbValueFinal = String.valueOf(i+1);

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
