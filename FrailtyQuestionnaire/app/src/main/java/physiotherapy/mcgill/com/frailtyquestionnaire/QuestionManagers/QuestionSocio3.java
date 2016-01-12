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
 * Created by Abhishek Vadnerkar on 15-12-29.
 */
public class QuestionSocio3 {

    public QuestionSocio3(final Context context, int sectionNum, int questionNum, final QuestionnaireActivity.QuestionHandler questionHandler){

        QuestionnaireActivity.containerLayout.removeAllViews();
        final ItemQuestion question = QuestionnaireActivity.sections.get(sectionNum).questions.get(questionNum);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.cell_socio_form_3, QuestionnaireActivity.containerLayout, true);

        final RadioGroup rgSex = (RadioGroup) view.findViewById(R.id.rg_sex);
        final EditText editDOB = (EditText) view.findViewById(R.id.edit_dob);
        final CheckBox cbEnglish = (CheckBox) view.findViewById(R.id.language_english);
        final CheckBox cbFrench = (CheckBox) view.findViewById(R.id.language_french);
        final EditText editLanguageOther = (EditText) view.findViewById(R.id.edit_language_other);
        final RadioGroup rgEducation = (RadioGroup) view.findViewById(R.id.rg_education);
        final RadioGroup rgLivingArrangement = (RadioGroup) view.findViewById(R.id.rg_livingarrangement);
        final RadioGroup rgChildren = (RadioGroup) view.findViewById(R.id.rg_children);

        Cursor cursor = HomeActivity.myDb.getFields(HomeActivity.currentPatientID, question.dbKey);
        if (cursor.moveToFirst()){

            String sex = cursor.getString(0);
            if (sex != null){
                RadioButton rbMale = (RadioButton) view.findViewById(R.id.sex_male);
                RadioButton rbFemale = (RadioButton) view.findViewById(R.id.sex_female);
                if (sex.equals(rbMale.getText())){
                    rgSex.check(R.id.sex_male);
                } else if (sex.equals(rbFemale.getText())){
                    rgSex.check(R.id.sex_female);
                }

            }

            String dob = cursor.getString(1);
            if (dob != null){
                editDOB.setText(dob);
            }

            String language = cursor.getString(2);
            String otherLanguage = language;
            if (language != null){
                if (language.contains(context.getString(R.string.english))){
                    cbEnglish.setChecked(true);
                    otherLanguage = otherLanguage.replace(context.getString(R.string.english), "");
                } else {
                    cbEnglish.setChecked(false);
                }

                if (language.contains(context.getString(R.string.french))){
                    cbFrench.setChecked(true);
                    otherLanguage = otherLanguage.replace(context.getString(R.string.french), "");
                } else {
                    cbFrench.setChecked(false);
                }

                editLanguageOther.setText(otherLanguage);
            }

            String education = cursor.getString(3);
            if (education != null){
                RadioButton rbHighSchool = (RadioButton) view.findViewById(R.id.education_highschool);
                RadioButton rbCegep = (RadioButton) view.findViewById(R.id.education_cegep);
                RadioButton rbPrimary = (RadioButton) view.findViewById(R.id.education_primary);
                RadioButton rbUniversity = (RadioButton) view.findViewById(R.id.education_university);
                RadioButton rbNone = (RadioButton) view.findViewById(R.id.education_none);
                if (education.equals(rbNone.getText())){
                    rgEducation.check(R.id.education_none);
                } else if (education.equals(rbPrimary.getText())){
                    rgEducation.check(R.id.education_primary);
                } else if (education.equals(rbHighSchool.getText())){
                    rgEducation.check(R.id.education_highschool);
                } else if (education.equals(rbCegep.getText())){
                    rgEducation.check(R.id.education_cegep);
                } else if (education.equals(rbUniversity.getText())){
                    rgEducation.check(R.id.education_university);
                }
            }

            String livingArrangement = cursor.getString(4);
            if (livingArrangement != null){
                RadioButton rbAlone = (RadioButton) view.findViewById(R.id.livingarrangement_alone);
                RadioButton rbRoomMate = (RadioButton) view.findViewById(R.id.livingarrangement_roommate);
                RadioButton rbSpouse = (RadioButton) view.findViewById(R.id.livingarrangement_spousefamily);
                RadioButton rbNoSpouse = (RadioButton) view.findViewById(R.id.livingarrangement_familynospouse);
                if (livingArrangement.equals(rbAlone.getText())){
                    rgLivingArrangement.check(R.id.livingarrangement_alone);
                } else if (livingArrangement.equals(rbRoomMate.getText())){
                    rgLivingArrangement.check(R.id.livingarrangement_roommate);
                } else if (livingArrangement.equals(rbSpouse.getText())){
                    rgLivingArrangement.check(R.id.livingarrangement_spousefamily);
                } else if (livingArrangement.equals(rbNoSpouse.getText())){
                    rgLivingArrangement.check(R.id.livingarrangement_familynospouse);
                }
            }

            String children = cursor.getString(5);
            if (children != null){
                RadioButton rbYes = (RadioButton) view.findViewById(R.id.children_yes);
                RadioButton rbNo = (RadioButton) view.findViewById(R.id.children_no);

                if (children.equals(rbYes.getText())){
                    rgChildren.check(R.id.children_yes);
                } else if (children.equals(rbNo.getText())){
                    rgChildren.check(R.id.children_no);
                }
            }

        }

        editDOB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int mYear=1960;
                int mMonth=0;
                int mDay=1;

                DatePickerDialog mDatePicker=new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        selectedmonth = selectedmonth + 1;
                        editDOB.setText(selectedyear + "-" + selectedmonth + "-" + selectedday);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.setTitle("Select date");
                mDatePicker.show();  }
        });

        Button buttonNext = (Button) view.findViewById(R.id.button);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(){
                    @Override
                    public void run() {

                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[0], ((RadioButton)view.findViewById(rgSex.getCheckedRadioButtonId())).getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[1], editDOB.getText().toString());

                        String languageText = (String)(cbEnglish.isChecked() ? cbEnglish.getText() : "") + (String)(cbFrench.isChecked() ? cbFrench.getText() : "") + editLanguageOther.getText().toString();
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[2], languageText);
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[3], ((RadioButton)view.findViewById(rgEducation.getCheckedRadioButtonId())).getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[4], ((RadioButton)view.findViewById(rgLivingArrangement.getCheckedRadioButtonId())).getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[5], ((RadioButton)view.findViewById(rgChildren.getCheckedRadioButtonId())).getText().toString());

                    }
                };
                thread.start();
                questionHandler.showNext();
            }
        });

    }

}
