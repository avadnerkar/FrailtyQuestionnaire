package physiotherapy.mcgill.com.frailtyquestionnaire.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import physiotherapy.mcgill.com.frailtyquestionnaire.R;

/**
 * Created by Abhishek Vadnerkar on 15-12-05.
 */
public class DialogQuestionnaireSelector extends Dialog{


    public Context context;
    public Button socioButton, nurseButton, evaluatorButton, physicalButton;
    public ClickHandler handler;

    public DialogQuestionnaireSelector(Context context, ClickHandler handler) {
        super(context);
        this.context = context;
        this.handler = handler;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_select_questionnaire);

        socioButton = (Button) findViewById(R.id.button_socio);
        socioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.onSocioClick();
                dismiss();
            }
        });

        nurseButton = (Button) findViewById(R.id.button_nurse);
        nurseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.onNurseClick();
                dismiss();
            }
        });

        evaluatorButton = (Button) findViewById(R.id.button_evaluator);
        evaluatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.onEvaluatorClick();
                dismiss();
            }
        });

        physicalButton = (Button) findViewById(R.id.button_physical);
        physicalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.onPhysicalClick();
                dismiss();
            }
        });
    }

    public interface ClickHandler{

        void onSocioClick();

        void onNurseClick();

        void onEvaluatorClick();

        void onPhysicalClick();
    }
}
