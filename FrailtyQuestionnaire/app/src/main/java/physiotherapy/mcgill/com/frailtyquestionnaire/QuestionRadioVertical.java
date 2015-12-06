package physiotherapy.mcgill.com.frailtyquestionnaire;

import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by Abhishek Vadnerkar on 15-11-03.
 */
public class QuestionRadioVertical {

    public QuestionRadioVertical(Context context, int sectionNum, int questionNum, final QuestionnaireActivity.QuestionHandler questionHandler){

        QuestionnaireActivity.containerLayout.removeAllViews();
        final ItemQuestion question = QuestionnaireActivity.sections.get(sectionNum).questions.get(questionNum);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.cell_radio_vertical, QuestionnaireActivity.containerLayout, true);

        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText(question.title);

        TextView subtitle = (TextView) view.findViewById(R.id.subtitle);
        if (question.subtitle ==null){
            subtitle.setVisibility(View.GONE);
        } else {
            subtitle.setText(question.subtitle);
        }



        final RadioGroup rg = (RadioGroup) view.findViewById(R.id.rg);

        for (int i=0; i<question.options.length; i++){
            final String rbText = question.options[i];
            final Integer rbValue = (Integer) question.dbValues[i];
            RadioButton rb = new RadioButton(context);
            rb.setText(rbText);
            rg.addView(rb);
            rb.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimension(R.dimen.text_medium));
            rb.setTextColor(ContextCompat.getColor(context, R.color.White));

            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    Thread thread = new Thread(){
                        @Override
                        public void run() {
                            HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[0], String.valueOf(rbValue));
                        }
                    };
                    thread.start();

                    Handler h = new Handler();
                    h.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            questionHandler.showNext();
                        }
                    }, 200);

                }
            });
        }


        Cursor cursor = HomeActivity.myDb.getField(HomeActivity.currentPatientID, question.dbKey[0]);

        if (cursor.moveToFirst()){

            if (cursor.isNull(cursor.getColumnIndex(question.dbKey[0])) || cursor.getString(cursor.getColumnIndex(question.dbKey[0])).length()>3){
                rg.clearCheck();
            } else {
                int radioValue = cursor.getInt(cursor.getColumnIndex(question.dbKey[0]));
                for (int i=0; i<question.options.length; i++){
                    Integer rbValue = (Integer) question.dbValues[i];
                    if (rbValue == radioValue){
                        ((RadioButton)rg.getChildAt(i)).setChecked(true);
                    }
                }
            }

        } else {
            rg.clearCheck();
        }

        cursor.close();

    }

}
