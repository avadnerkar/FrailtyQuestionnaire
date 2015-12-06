package physiotherapy.mcgill.com.frailtyquestionnaire.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;

import physiotherapy.mcgill.com.frailtyquestionnaire.R;

/**
 * Created by Abhishek on 9/07/2015.
 */

/**
 * *****************************************************************************************
 * Custom 1 button dialog, dismisses on click
 * *****************************************************************************************
 */
public class DialogDisclaimer extends Dialog {

    public Context context;
    public Dialog d;
    public Button ok;
    public ClickHandler handler;


    public DialogDisclaimer(Context context, ClickHandler handler) {
        super(context);
        this.context = context;
        this.handler = handler;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.dialog_disclaimer);

        final CheckBox disclaimer1 = (CheckBox) findViewById(R.id.disclaimer1);
        final CheckBox disclaimer2 = (CheckBox) findViewById(R.id.disclaimer2);

        ok = (Button) findViewById(R.id.dialog_ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                if (disclaimer1.isChecked() && disclaimer2.isChecked()){
                    handler.onSuccess();

                } else {
                    handler.onFailure();
                }
            }
        });
    }

    public interface ClickHandler{
        void onSuccess();

        void onFailure();
    }

}
