package physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
public class QuestionSocio5 {

    public QuestionSocio5(final Context context, int sectionNum, int questionNum, final QuestionnaireActivity.QuestionHandler questionHandler){

        QuestionnaireActivity.containerLayout.removeAllViews();
        final ItemQuestion question = QuestionnaireActivity.sections.get(sectionNum).questions.get(questionNum);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.cell_socio_form_5, QuestionnaireActivity.containerLayout, true);

        final RadioGroup rgHelpNeeded = (RadioGroup) view.findViewById(R.id.rg_help);
        final EditText editOther1 = (EditText) view.findViewById(R.id.edit_home_care_other1);
        final EditText editOther2 = (EditText) view.findViewById(R.id.edit_home_care_other2);
        final EditText editOther3 = (EditText) view.findViewById(R.id.edit_home_care_other3);
        final EditText editNumVisits1 = (EditText) view.findViewById(R.id.edit_num_visits_1);
        final EditText editNumVisits2 = (EditText) view.findViewById(R.id.edit_num_visits_2);
        final EditText editNumVisits3 = (EditText) view.findViewById(R.id.edit_num_visits_3);
        final EditText editNumVisits4 = (EditText) view.findViewById(R.id.edit_num_visits_4);
        final EditText editNumVisits5 = (EditText) view.findViewById(R.id.edit_num_visits_5);
        final EditText editNumVisits6 = (EditText) view.findViewById(R.id.edit_num_visits_6);
        final EditText editNumVisits7 = (EditText) view.findViewById(R.id.edit_num_visits_7);
        final EditText editNumVisits8 = (EditText) view.findViewById(R.id.edit_num_visits_8);
        final CheckBox needed1 = (CheckBox) view.findViewById(R.id.needed1);
        final CheckBox needed2 = (CheckBox) view.findViewById(R.id.needed2);
        final CheckBox needed3 = (CheckBox) view.findViewById(R.id.needed3);
        final CheckBox needed4 = (CheckBox) view.findViewById(R.id.needed4);
        final CheckBox needed5 = (CheckBox) view.findViewById(R.id.needed5);
        final CheckBox needed6 = (CheckBox) view.findViewById(R.id.needed6);
        final CheckBox needed7 = (CheckBox) view.findViewById(R.id.needed7);
        final CheckBox needed8 = (CheckBox) view.findViewById(R.id.needed8);
        final CheckBox received1 = (CheckBox) view.findViewById(R.id.received1);
        final CheckBox received2 = (CheckBox) view.findViewById(R.id.received2);
        final CheckBox received3 = (CheckBox) view.findViewById(R.id.received3);
        final CheckBox received4 = (CheckBox) view.findViewById(R.id.received4);
        final CheckBox received5 = (CheckBox) view.findViewById(R.id.received5);
        final CheckBox received6 = (CheckBox) view.findViewById(R.id.received6);
        final CheckBox received7 = (CheckBox) view.findViewById(R.id.received7);
        final CheckBox received8 = (CheckBox) view.findViewById(R.id.received8);

        Cursor cursor = HomeActivity.myDb.getFields(HomeActivity.currentPatientID, question.dbKey);
        if (cursor.moveToFirst()){

            String homeCare = cursor.getString(0);
            if (homeCare != null){
                RadioButton rbYes = (RadioButton) view.findViewById(R.id.help_yes);
                RadioButton rbNo = (RadioButton) view.findViewById(R.id.help_no);

                if (homeCare.equals(rbYes.getText())){
                    rgHelpNeeded.check(R.id.help_yes);
                } else if (homeCare.equals(rbNo.getText())){
                    rgHelpNeeded.check(R.id.help_no);
                }
            }


            String care1 = cursor.getString(1);
            String care1num = care1;
            if (care1 != null){
                if (care1.contains("Needed")){
                    needed1.setChecked(true);
                    care1num = care1num.replace("Needed", "");
                } else {
                    needed1.setChecked(false);
                }

                if (care1.contains("Received")){
                    received1.setChecked(true);
                    care1num = care1num.replace("Received", "");
                } else {
                    received1.setChecked(false);
                }
                editNumVisits1.setText(care1num);
            }


            String care2 = cursor.getString(2);
            String care2num = care2;
            if (care2 != null){
                if (care2.contains("Needed")){
                    needed2.setChecked(true);
                    care2num = care2num.replace("Needed", "");
                } else {
                    needed2.setChecked(false);
                }

                if (care2.contains("Received")){
                    received2.setChecked(true);
                    care2num = care2num.replace("Received", "");
                } else {
                    received2.setChecked(false);
                }
                editNumVisits2.setText(care2num);
            }

            String care3 = cursor.getString(3);
            String care3num = care3;
            if (care3 != null){
                if (care3.contains("Needed")){
                    needed3.setChecked(true);
                    care3num = care3num.replace("Needed", "");
                } else {
                    needed3.setChecked(false);
                }

                if (care3.contains("Received")){
                    received3.setChecked(true);
                    care3num = care3num.replace("Received", "");
                } else {
                    received3.setChecked(false);
                }
                editNumVisits3.setText(care3num);
            }

            String care4 = cursor.getString(4);
            String care4num = care4;
            if (care4 != null){
                if (care4.contains("Needed")){
                    needed4.setChecked(true);
                    care4num = care4num.replace("Needed", "");
                } else {
                    needed4.setChecked(false);
                }

                if (care4.contains("Received")){
                    received4.setChecked(true);
                    care4num = care4num.replace("Received", "");
                } else {
                    received4.setChecked(false);
                }
                editNumVisits4.setText(care4num);
            }

            String care5 = cursor.getString(5);
            String care5num = care5;
            if (care5 != null){
                if (care5.contains("Needed")){
                    needed5.setChecked(true);
                    care5num = care5num.replace("Needed", "");
                } else {
                    needed5.setChecked(false);
                }

                if (care5.contains("Received")){
                    received5.setChecked(true);
                    care5num = care5num.replace("Received", "");
                } else {
                    received5.setChecked(false);
                }
                editNumVisits5.setText(care5num);
            }

            String other1 = cursor.getString(6);
            if (other1 != null){
                editOther1.setText(other1);
            }

            String care6 = cursor.getString(7);
            String care6num = care6;
            if (care6 != null){
                if (care6.contains("Needed")){
                    needed6.setChecked(true);
                    care6num = care6num.replace("Needed", "");
                } else {
                    needed6.setChecked(false);
                }

                if (care6.contains("Received")){
                    received6.setChecked(true);
                    care6num = care6num.replace("Received", "");
                } else {
                    received6.setChecked(false);
                }
                editNumVisits6.setText(care6num);
            }

            String other2 = cursor.getString(8);
            if (other2 != null){
                editOther2.setText(other2);
            }

            String care7 = cursor.getString(9);
            String care7num = care7;
            if (care7 != null){
                if (care7.contains("Needed")){
                    needed7.setChecked(true);
                    care7num = care7num.replace("Needed", "");
                } else {
                    needed7.setChecked(false);
                }

                if (care7.contains("Received")){
                    received7.setChecked(true);
                    care7num = care7num.replace("Received", "");
                } else {
                    received7.setChecked(false);
                }
                editNumVisits7.setText(care7num);
            }

            String other3 = cursor.getString(10);
            if (other3 != null){
                editOther3.setText(other3);
            }

            String care8 = cursor.getString(11);
            String care8num = care8;
            if (care8 != null){
                if (care8.contains("Needed")){
                    needed8.setChecked(true);
                    care8num = care8num.replace("Needed", "");
                } else {
                    needed8.setChecked(false);
                }

                if (care8.contains("Received")){
                    received8.setChecked(true);
                    care8num = care8num.replace("Received", "");
                } else {
                    received8.setChecked(false);
                }
                editNumVisits8.setText(care8num);
            }



        }

        Button buttonNext = (Button) view.findViewById(R.id.button);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(){
                    @Override
                    public void run() {

                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[0], ((RadioButton)view.findViewById(rgHelpNeeded.getCheckedRadioButtonId())).getText().toString());

                        String text1 = (String)(needed1.isChecked() ? "Needed" : "") + (String)(received1.isChecked() ? "Received" : "") + editNumVisits1.getText().toString();
                        String text2 = (String)(needed2.isChecked() ? "Needed" : "") + (String)(received2.isChecked() ? "Received" : "") + editNumVisits2.getText().toString();
                        String text3 = (String)(needed3.isChecked() ? "Needed" : "") + (String)(received3.isChecked() ? "Received" : "") + editNumVisits3.getText().toString();
                        String text4 = (String)(needed4.isChecked() ? "Needed" : "") + (String)(received4.isChecked() ? "Received" : "") + editNumVisits4.getText().toString();
                        String text5 = (String)(needed5.isChecked() ? "Needed" : "") + (String)(received5.isChecked() ? "Received" : "") + editNumVisits5.getText().toString();
                        String text6 = (String)(needed6.isChecked() ? "Needed" : "") + (String)(received6.isChecked() ? "Received" : "") + editNumVisits6.getText().toString();
                        String text7 = (String)(needed7.isChecked() ? "Needed" : "") + (String)(received7.isChecked() ? "Received" : "") + editNumVisits7.getText().toString();
                        String text8 = (String)(needed8.isChecked() ? "Needed" : "") + (String)(received8.isChecked() ? "Received" : "") + editNumVisits8.getText().toString();

                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[1], text1);
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[2], text2);
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[3], text3);
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[4], text4);
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[5], text5);
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[6], editOther1.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[7], text6);
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[8], editOther2.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[9], text7);
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[10], editOther3.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[11], text8);

                    }
                };
                thread.start();
                questionHandler.showNext();
            }
        });

    }

}
