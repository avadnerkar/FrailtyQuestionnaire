package physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import physiotherapy.mcgill.com.frailtyquestionnaire.Activities.HomeActivity;
import physiotherapy.mcgill.com.frailtyquestionnaire.Activities.QuestionnaireActivity;
import physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers.ItemQuestion;
import physiotherapy.mcgill.com.frailtyquestionnaire.R;

/**
 * Created by Abhishek Vadnerkar on 15-12-29.
 */
public class QuestionSocio2 {

    public QuestionSocio2(final Context context, int sectionNum, int questionNum, final QuestionnaireActivity.QuestionHandler questionHandler){

        QuestionnaireActivity.containerLayout.removeAllViews();
        final ItemQuestion question = QuestionnaireActivity.sections.get(sectionNum).questions.get(questionNum);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.cell_socio_form_2, QuestionnaireActivity.containerLayout, true);

        final EditText editWeight = (EditText) view.findViewById(R.id.edit_weight);
        final EditText editHeight = (EditText) view.findViewById(R.id.edit_height);
        final EditText editComorbidity = (EditText) view.findViewById(R.id.edit_comorbidity);
        final EditText editMultipleMorbidities = (EditText) view.findViewById(R.id.edit_multiple_morbidities);
        final EditText editMiniMental = (EditText) view.findViewById(R.id.edit_mini_mental);
        final EditText editMoca = (EditText) view.findViewById(R.id.edit_moca);

        final RadioGroup radioWeight = (RadioGroup) view.findViewById(R.id.rg_weight);
        final RadioGroup radioHeight = (RadioGroup) view.findViewById(R.id.rg_height);
        final TextView calcBmi = (TextView) view.findViewById(R.id.calc_bmi);

        Cursor cursor = HomeActivity.myDb.getFields(HomeActivity.currentPatientID, question.dbKey);
        if (cursor.moveToFirst()){
            String weight = cursor.getString(0);
            if (weight != null){
                editWeight.setText(weight);
            }

            String height = cursor.getString(1);
            if (height != null){
                editHeight.setText(height);
            }

            String bmi = cursor.getString(2);
            if (bmi != null){
                calcBmi.setText(bmi);
            }

            String comorbidity = cursor.getString(3);
            if (comorbidity != null){
                editComorbidity.setText(comorbidity);
            }

            String multipleMorbidities = cursor.getString(4);
            if (multipleMorbidities != null){
                editMultipleMorbidities.setText(multipleMorbidities);
            }

            String miniMental = cursor.getString(5);
            if (miniMental != null){
                editMiniMental.setText(miniMental);
            }

            String moca = cursor.getString(6);
            if (moca != null){
                editMoca.setText(moca);
            }
        }


        EditText.OnFocusChangeListener listener = new EditText.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    String[] bmiData = calculateBMI(editWeight.getText().toString(), editHeight.getText().toString(), radioWeight.getCheckedRadioButtonId(), radioHeight.getCheckedRadioButtonId());
                    calcBmi.setText(bmiData[2]);
                }
            }
        };
        editWeight.setOnFocusChangeListener(listener);
        editHeight.setOnFocusChangeListener(listener);

        RadioGroup.OnCheckedChangeListener checkedChangeListener = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String[] bmiData = calculateBMI(editWeight.getText().toString(), editHeight.getText().toString(), radioWeight.getCheckedRadioButtonId(), radioHeight.getCheckedRadioButtonId());
                calcBmi.setText(bmiData[2]);

                TextView heightInstructions = (TextView) view.findViewById(R.id.ft_instructions);
                if (checkedId == R.id.radio_weight_ft){
                    heightInstructions.setVisibility(View.VISIBLE);
                } else if (checkedId == R.id.radio_height_cm){
                    heightInstructions.setVisibility(View.GONE);
                }
            }
        };

        radioWeight.setOnCheckedChangeListener(checkedChangeListener);
        radioHeight.setOnCheckedChangeListener(checkedChangeListener);

        Button buttonNext = (Button) view.findViewById(R.id.button);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(){
                    @Override
                    public void run() {

                        String[] bmiData = calculateBMI(editWeight.getText().toString(), editHeight.getText().toString(), radioWeight.getCheckedRadioButtonId(), radioHeight.getCheckedRadioButtonId());

                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[0], bmiData[0]);
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[1], bmiData[1]);
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[2], bmiData[2]);

                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[3], editComorbidity.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[4], editMultipleMorbidities.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[5], editMiniMental.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[6], editMoca.getText().toString());

                    }
                };
                thread.start();
                questionHandler.showNext();
            }
        });

    }

    private String[] calculateBMI(String weight, String height, int weightUnitsId, int heightUnitsId){

        String weightString;
        String heightString;
        String bmiString;

        Float weightKg = null;
        Float heightCm = null;

        if (weight.equals("")){
            weightString = "";
        } else {
            if (weightUnitsId == R.id.radio_weight_kg){
                weightKg = Float.parseFloat(weight);
            } else {
                weightKg = Float.parseFloat(weight)/2.2f;
            }

            weightString = String.valueOf(weightKg);
        }

        if (height.equals("")){
            heightString = "";
        } else{
            if (heightUnitsId == R.id.radio_height_cm){
                heightCm = Float.parseFloat(height);
            } else {
                String[] splitText = height.split("\\.");

                int ft = 0;
                int inches = 0;
                if (splitText.length>0){
                    ft = Integer.valueOf(splitText[0]);
                }

                if (splitText.length>1){
                    inches = Integer.valueOf(splitText[1]);
                }

                heightCm = ft*30.48f + inches*2.54f;
            }
            heightString = String.valueOf(heightCm);
        }

        if (weightKg != null && heightCm !=null){
            bmiString = String.valueOf(weightKg/((heightCm/100)*(heightCm/100)));
        } else {
            bmiString = "";
        }

        return new String[]{weightString, heightString, bmiString};


    }


}
