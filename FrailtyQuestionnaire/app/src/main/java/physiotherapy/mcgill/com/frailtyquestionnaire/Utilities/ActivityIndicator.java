package physiotherapy.mcgill.com.frailtyquestionnaire.Utilities;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;
import android.view.WindowManager;

import physiotherapy.mcgill.com.frailtyquestionnaire.R;

/**
 * Created by alexandrehuot on 15-10-17.
 */
public class ActivityIndicator {

    public static Dialog progressDialog;

    public static void showProgressDialog(Activity currentActivity) {
        if (progressDialog == null) {
            progressDialog = new Dialog(currentActivity);
            try {
                currentActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
                        progressDialog.getWindow().setBackgroundDrawableResource(R.color.Transparent);
                        progressDialog.setCancelable(false);
                        progressDialog.setContentView(R.layout.dialog_activityindicator);

                        progressDialog.show();
                    }
                });
            }
            catch (WindowManager.BadTokenException e) {
            }
        }
    }

    public static void dismissProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}
