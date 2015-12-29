package physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import physiotherapy.mcgill.com.frailtyquestionnaire.Activities.HomeActivity;
import physiotherapy.mcgill.com.frailtyquestionnaire.Activities.QuestionnaireActivity;
import physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers.ItemQuestion;
import physiotherapy.mcgill.com.frailtyquestionnaire.R;

/**
 * Created by Abhishek Vadnerkar on 15-12-28.
 */
public class QuestionSitToRise {

    public View view;

    public QuestionSitToRise(Context context, int sectionNum, int questionNum, final QuestionnaireActivity.QuestionHandler questionHandler){

        QuestionnaireActivity.containerLayout.removeAllViews();
        final ItemQuestion question = QuestionnaireActivity.sections.get(sectionNum).questions.get(questionNum);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.cell_sit_to_rise, QuestionnaireActivity.containerLayout, true);

        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText(question.title);

        final EditText editTime = (EditText) view.findViewById(R.id.edit_time);
        final TextView textScore = (TextView) view.findViewById(R.id.calc_score);
        final RadioGroup rgHand = (RadioGroup) view.findViewById(R.id.rg_hand);
        final RadioGroup rgForearm = (RadioGroup) view.findViewById(R.id.rg_forearm);
        final RadioGroup rgKnee = (RadioGroup) view.findViewById(R.id.rg_knee);
        final RadioGroup rgLeg = (RadioGroup) view.findViewById(R.id.rg_leg);
        final RadioGroup rgOneHand = (RadioGroup) view.findViewById(R.id.rg_one_hand);
        final RadioGroup rgBalance = (RadioGroup) view.findViewById(R.id.rg_loss_of_balance);


        Cursor cursor = HomeActivity.myDb.getFields(HomeActivity.currentPatientID, question.dbKey);
        if (cursor.moveToFirst()){
            float time = cursor.getFloat(0);
            if (time != 0.0){
                editTime.setText(String.valueOf(time));
            }

            String score = cursor.getString(1);
            if (score != null){
                textScore.setText(score);
                rgHand.clearCheck();
                rgForearm.clearCheck();
                rgKnee.clearCheck();
                rgLeg.clearCheck();
                rgOneHand.clearCheck();
                rgBalance.clearCheck();
            } else {
                textScore.setText("5.0");
                rgHand.check(R.id.hand_no);
                rgForearm.check(R.id.forearm_no);
                rgKnee.check(R.id.knee_no);
                rgLeg.check(R.id.leg_no);
                rgOneHand.check(R.id.one_hand_no);
                rgBalance.check(R.id.loss_of_balance_no);
            }

        }

        RadioGroup.OnCheckedChangeListener checkedChangeListener = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                calculateScore();
            }
        };

        rgHand.setOnCheckedChangeListener(checkedChangeListener);
        rgForearm.setOnCheckedChangeListener(checkedChangeListener);
        rgKnee.setOnCheckedChangeListener(checkedChangeListener);
        rgLeg.setOnCheckedChangeListener(checkedChangeListener);
        rgOneHand.setOnCheckedChangeListener(checkedChangeListener);
        rgBalance.setOnCheckedChangeListener(checkedChangeListener);

        Button buttonNext = (Button) view.findViewById(R.id.button);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(){
                    @Override
                    public void run() {

                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[0], editTime.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[1], textScore.getText().toString());

                    }
                };
                thread.start();
                questionHandler.showNext();
            }
        });

    }


    private void calculateScore(){

        RadioButton handYes = (RadioButton) view.findViewById(R.id.hand_yes);
        RadioButton handNo = (RadioButton) view.findViewById(R.id.hand_no);
        Boolean hand = null;
        if (handYes.isChecked()){
            hand = true;
        } else if (handNo.isChecked()){
            hand = false;
        }

        RadioButton forearmYes = (RadioButton) view.findViewById(R.id.forearm_yes);
        RadioButton forearmNo = (RadioButton) view.findViewById(R.id.forearm_no);
        Boolean forearm = null;
        if (forearmYes.isChecked()){
            forearm = true;
        } else if (forearmNo.isChecked()){
            forearm = false;
        }

        RadioButton kneeYes = (RadioButton) view.findViewById(R.id.knee_yes);
        RadioButton kneeNo = (RadioButton) view.findViewById(R.id.knee_no);
        Boolean knee = null;
        if (kneeYes.isChecked()){
            knee = true;
        } else if (kneeNo.isChecked()){
            knee = false;
        }

        RadioButton legYes = (RadioButton) view.findViewById(R.id.leg_yes);
        RadioButton legNo = (RadioButton) view.findViewById(R.id.leg_no);
        Boolean leg = null;
        if (legYes.isChecked()){
            leg = true;
        } else if (legNo.isChecked()){
            leg = false;
        }

        RadioButton oneHandYes = (RadioButton) view.findViewById(R.id.one_hand_yes);
        RadioButton oneHandNo = (RadioButton) view.findViewById(R.id.one_hand_no);
        Boolean oneHand = null;
        if (oneHandYes.isChecked()){
            oneHand = true;
        } else if (oneHandNo.isChecked()){
            oneHand = false;
        }

        RadioButton balanceYes = (RadioButton) view.findViewById(R.id.loss_of_balance_yes);
        RadioButton balanceNo = (RadioButton) view.findViewById(R.id.loss_of_balance_no);
        Boolean balance = null;
        if (balanceYes.isChecked()){
            balance = true;
        } else if (balanceNo.isChecked()){
            balance = false;
        }

        if (hand == null || forearm == null || knee == null || leg == null || oneHand == null || balance == null){
            return;
        }

        float score = Math.max(5 - (hand ? 1: 0)*1.0f - (forearm ? 1: 0)*1.0f - (knee ? 1: 0)*1.0f - (leg ? 1: 0)*1.0f - (oneHand ? 1: 0)*1.0f - (balance ? 1: 0)*0.5f, 0.0f);

        final TextView textScore = (TextView) view.findViewById(R.id.calc_score);
        textScore.setText(String.valueOf(score));
    }


}
