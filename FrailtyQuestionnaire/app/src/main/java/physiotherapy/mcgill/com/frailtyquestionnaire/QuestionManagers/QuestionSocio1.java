package physiotherapy.mcgill.com.frailtyquestionnaire.QuestionManagers;

import android.app.DatePickerDialog;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

import physiotherapy.mcgill.com.frailtyquestionnaire.Activities.HomeActivity;
import physiotherapy.mcgill.com.frailtyquestionnaire.Activities.QuestionnaireActivity;
import physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers.ItemQuestion;
import physiotherapy.mcgill.com.frailtyquestionnaire.R;

/**
 * Created by Abhishek Vadnerkar on 15-12-29.
 */
public class QuestionSocio1 {

    public QuestionSocio1(final Context context, int sectionNum, int questionNum, final QuestionnaireActivity.QuestionHandler questionHandler){

        QuestionnaireActivity.containerLayout.removeAllViews();
        final ItemQuestion question = QuestionnaireActivity.sections.get(sectionNum).questions.get(questionNum);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.cell_socio_form_1, QuestionnaireActivity.containerLayout, true);


        final EditText editName = (EditText) view.findViewById(R.id.edit_name);
        final EditText editPhone1 = (EditText) view.findViewById(R.id.edit_phone_1);
        final EditText editPhone2 = (EditText) view.findViewById(R.id.edit_phone_2);
        final EditText editFamilyPhone = (EditText) view.findViewById(R.id.edit_family_phone);
        final EditText editAnticipatedPlaceDischarge = (EditText) view.findViewById(R.id.edit_anticipated_place_discharge);
        final EditText editAnticipatedDateDischarge = (EditText) view.findViewById(R.id.edit_anticipated_date_discharge);

        Cursor cursor = HomeActivity.myDb.getFields(HomeActivity.currentPatientID, question.dbKey);
        if (cursor.moveToFirst()){
            String name = cursor.getString(0);
            if (name != null){
                editName.setText(name);
            }

            String phone1 = cursor.getString(1);
            if (phone1 != null){
                editPhone1.setText(phone1);
            }

            String phone2 = cursor.getString(2);
            if (phone2 != null){
                editPhone2.setText(phone2);
            }

            String familyPhone = cursor.getString(3);
            if (familyPhone != null){
                editFamilyPhone.setText(familyPhone);
            }

            String anticipatedPlaceDischarge = cursor.getString(4);
            if (anticipatedPlaceDischarge != null){
                editAnticipatedPlaceDischarge.setText(anticipatedPlaceDischarge);
            }

            String anticipatedDateDischarge = cursor.getString(5);
            if (anticipatedDateDischarge != null){
                editAnticipatedDateDischarge.setText(anticipatedDateDischarge);
            }
        }

        editAnticipatedDateDischarge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //To show current date in the datepicker
                Calendar mcurrentDate=Calendar.getInstance();
                int mYear=mcurrentDate.get(Calendar.YEAR);
                int mMonth=mcurrentDate.get(Calendar.MONTH);
                int mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        selectedmonth = selectedmonth + 1;
                        editAnticipatedDateDischarge.setText(selectedyear + "-" + selectedmonth + "-" + selectedday);
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

                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[0], editName.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[1], editPhone1.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[2], editPhone2.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[3], editFamilyPhone.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[4], editAnticipatedPlaceDischarge.getText().toString());
                        HomeActivity.myDb.updateAnswer(HomeActivity.currentPatientID, question.dbKey[5], editAnticipatedDateDischarge.getText().toString());

                    }
                };
                thread.start();
                questionHandler.showNext();
            }
        });

    }

}
