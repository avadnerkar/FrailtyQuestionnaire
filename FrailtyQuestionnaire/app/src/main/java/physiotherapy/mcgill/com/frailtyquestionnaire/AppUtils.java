package physiotherapy.mcgill.com.frailtyquestionnaire;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Abhishek Vadnerkar on 15-11-03.
 */
public class AppUtils {

    public static ProgressDialog createProgressDialog(Context mContext) {

        final ProgressDialog dialog = new ProgressDialog(mContext);
        try {
            Activity a = (Activity) mContext;
            a.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    dialog.show();
                }
            });
        } catch (WindowManager.BadTokenException e) {

        }
        dialog.setCancelable(false);
        return dialog;
    }


    // SIMPLE WARNING ALERT
    @SuppressWarnings("deprecation")
    public static void showAlert(final String title, final String msg, final Context context) {

        Activity a = (Activity) context;
        a.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AlertDialog alertDialog = new AlertDialog.Builder(context).create();
                alertDialog.setTitle(title);
                alertDialog.setMessage(msg);
                alertDialog.setButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.show();
            }
        });
    }

    /*
    Displays custom one button dialog
     */
    public static void showSimpleDialog(String message, Context context){
        final DialogSimple dialog = new DialogSimple(context);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(R.id.dialog_title);
        textView.setText(message);
    }

    public static void showTwoButtonDialog(String message, String positiveButton, String negativeButton, Context context, DialogTwoButton.ClickHandler clickHandler){
        final DialogTwoButton dialog = new DialogTwoButton(context, clickHandler);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(R.id.dialog_title);
        textView.setText(message);

        textView = (TextView) dialog.findViewById(R.id.dialog_ok);
        textView.setText(positiveButton);

        textView = (TextView) dialog.findViewById(R.id.dialog_cancel);
        textView.setText(negativeButton);
    }

    public static void showThreeButtonDialog(String message, String positiveButton, String negativeButton, String thirdButton, Context context, DialogThreeButton.ClickHandler clickHandler){
        final DialogThreeButton dialog = new DialogThreeButton(context, clickHandler);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(R.id.dialog_title);
        textView.setText(message);

        textView = (TextView) dialog.findViewById(R.id.dialog_ok);
        textView.setText(positiveButton);

        textView = (TextView) dialog.findViewById(R.id.dialog_cancel);
        textView.setText(negativeButton);

        textView = (TextView) dialog.findViewById(R.id.dialog_third);
        textView.setText(thirdButton);
    }

    /*
    Displays custom list dialog
     */
    public static void showListDialog(String title, String[] items, Context context, final ListHandler h){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                h.onClick(i);
            }
        });
        builder.show();
    }

    public interface ListHandler{
        void onClick(int i);
    }




    public static void showAlertWithImage(String title, String msg, Context context, ImageView image) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(context).
                        setTitle(title).
                        setMessage(msg).
                        setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).
                        setView(image);
        builder.create().show();
    }

    public static void showPopup(final String msg, final Context context) {
        Activity a = (Activity) context;
        a.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
            }
        });
    }

}
