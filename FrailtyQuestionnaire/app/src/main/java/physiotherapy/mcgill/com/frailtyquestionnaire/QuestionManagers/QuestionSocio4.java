package physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers;

import android.app.DatePickerDialog;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import physiotherapy.mcgill.com.frailtyquestionnaire.Activities.HomeActivity;
import physiotherapy.mcgill.com.frailtyquestionnaire.Activities.QuestionnaireActivity;
import physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers.ItemQuestion;
import physiotherapy.mcgill.com.frailtyquestionnaire.R;

/**
 * Created by Abhishek Vadnerkar on 16-01-03.
 */
public class QuestionSocio4 {

    public QuestionSocio4(final Context context, int sectionNum, int questionNum, final QuestionnaireActivity.QuestionHandler questionHandler){

        QuestionnaireActivity.containerLayout.removeAllViews();
        final ItemQuestion question = QuestionnaireActivity.sections.get(sectionNum).questions.get(questionNum);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.cell_socio_form_4, QuestionnaireActivity.containerLayout, true);

        final RadioGroup rgComplementary = (RadioGroup) view.findViewById(R.id.rg_complementary);
        final EditText editOtherDrug = (EditText) view.findViewById(R.id.other_drug);
        final EditText editComplementary = (EditText) view.findViewById(R.id.edit_complementary);
        final EditText editPrescription = (EditText) view.findViewById(R.id.edit_prescription);
        final CheckBox check1 = (CheckBox) view.findViewById(R.id.check1);
        final CheckBox check2 = (CheckBox) view.findViewById(R.id.check2);
        final CheckBox check3 = (CheckBox) view.findViewById(R.id.check3);
        final CheckBox check4 = (CheckBox) view.findViewById(R.id.check4);
        final CheckBox check5 = (CheckBox) view.findViewById(R.id.check5);
        final CheckBox check6 = (CheckBox) view.findViewById(R.id.check6);
        final CheckBox check7 = (CheckBox) view.findViewById(R.id.check7);
        final CheckBox check8 = (CheckBox) view.findViewById(R.id.check8);
        final CheckBox check9 = (CheckBox) view.findViewById(R.id.check9);

        Cursor cursor = HomeActivity.myDb.getFields(HomeActivity.currentPatientID, question.dbKey);
        if (cursor.moveToFirst()){

            String drugs = cursor.getString(0);
            String otherDrugs = drugs;
            if (drugs != null){
                if (drugs.contains(check1.getTag().toString())){
                    check1.setChecked(true);
                    otherDrugs = otherDrugs.replace(check1.getTag().toString() + " ", "");
                } else {
                    check1.setChecked(false);
                }

                if (drugs.contains(check2.getTag().toString())){
                    check2.setChecked(true);
                    otherDrugs = otherDrugs.replace(check2.getTag().toString() + " ", "");
                } else {
                    check2.setChecked(false);
                }

                if (drugs.contains(check3.getTag().toString())){
                    check3.setChecked(true);
                    otherDrugs = otherDrugs.replace(check3.getTag().toString() + " ", "");
                } else {
                    check3.setChecked(false);
                }

                if (drugs.contains(check4.getTag().toString())){
                    check4.setChecked(true);
                    otherDrugs = otherDrugs.replace(check4.getTag().toString() + " ", "");
                } else {
                    check4.setChecked(false);
                }

                if (drugs.contains(check5.getTag().toString())){
                    check5.setChecked(true);
                    otherDrugs = otherDrugs.replace(check5.getTag().toString() + " ", "");
                } else {
                    check5.setChecked(false);
                }

                if (drugs.contains(check6.getTag().toString())){
                    check6.setChecked(true);
                    otherDrugs = otherDrugs.replace(check6.getTag().toString() + " ", "");
                } else {
                    check6.setChecked(false);
                }

                if (drugs.contains(check7.getTag().toString())){
                    check7.setChecked(true);
                    otherDrugs = otherDrugs.replace(check7.getTag().toString() + " ", "");
                } else {
                    check7.setChecked(false);
                }

                if (drugs.contains(check8.getTag().toString())){
                    check8.setChecked(true);
                    otherDrugs = otherDrugs.replace(check8.getTag().toString() + " ", "");
                } else {
                    check8.setChecked(false);
                }

                if (drugs.contains(check9.getTag().toString())){
                    check9.setChecked(true);
                    otherDrugs = otherDrugs.replace(check9.getTag().toString() + " ", "");
                } else {
                    check9.setChecked(false);
                }

                editOtherDrug.setText(otherDrugs);
            }

            String useComplementary = cursor.getString(1);
            if (useComplementary != null){
                RadioButton rbYes = (RadioButton) view.findViewById(R.id.complementary_yes);
                RadioButton rbNo = (RadioButton) view.findViewById(R.id.complementary_no);

                if (useComplementary.equals(rbYes.getText())){
                    rgComplementary.check(R.id.complementary_yes);
                } else if (useComplementary.equals(rbNo.getText())){
                    rgComplementary.check(R.id.complementary_no);
                }
            }

            String complementary = cursor.getString(2);
            if (complementary != null){
                editComplementary.setText(complementary);
            }

            String prescription = cursor.getString(3);
            if (prescription != null){
                editPrescription.setText(prescription);
            }

        }

        Button buttonNext = (Button) view.findViewById(R.id.button);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        String drugText = (String)(check1.isChecked() ? check1.getTag().toString() + " " : "") + (String)(check2.isChecked() ? check2.getTag().toString() + " " : "") + (String)(check3.isChecked() ? check3.getTag().toString() + " " : "") + (String)(check4.isChecked() ? check4.getTag().toString() + " " : "") + (String)(check5.isChecked() ? check5.getTag().toString() + " " : "") + (String)(check6.isChecked() ? check6.getTag().toString() + " " : "") + (String)(check7.isChecked() ? check7.getTag().toString() + " " : "") + (String)(check8.isChecked() ? check8.getTag().toString() + " " : "") + (String)(check9.isChecked() ? check9.getTag().toString() + " " : "") + editOtherDrug.getText().toString();

                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[0], drugText);
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[1], ((RadioButton)view.findViewById(rgComplementary.getCheckedRadioButtonId())).getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[2], editComplementary.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[3], editPrescription.getText().toString());

                    }
                };
                thread.start();
                questionHandler.showNext();
            }
        });

    }
}
