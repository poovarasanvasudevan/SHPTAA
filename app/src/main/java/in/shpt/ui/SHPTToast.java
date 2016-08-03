package in.shpt.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.EBean;

import in.shpt.R;

/**
 * Created by poovarasanv on 3/8/16.
 */
@EBean
public class SHPTToast {

    static Activity activity;
    static TextView textView;
    static View layout;

    public static void longToast(Activity context, String text) {

        activity = (Activity) context;

        LayoutInflater inflater = activity.getLayoutInflater();
        layout = inflater.inflate(R.layout.toast, (ViewGroup) activity.findViewById(R.id.root));
        textView = (TextView) layout.findViewById(R.id.toasttext);


        textView.setText(text);

        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    public static void shortToast(Activity context, String text) {

        activity = (Activity) context;

        LayoutInflater inflater = activity.getLayoutInflater();
        layout = inflater.inflate(R.layout.toast, (ViewGroup) activity.findViewById(R.id.root));
        textView = (TextView) layout.findViewById(R.id.toasttext);


        textView.setText(text);

        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    public static void success(Activity context, String text) {

        activity = (Activity) context;

        LayoutInflater inflater = activity.getLayoutInflater();
        layout = inflater.inflate(R.layout.toast, (ViewGroup) activity.findViewById(R.id.root));
        textView = (TextView) layout.findViewById(R.id.toasttext);

        layout.setBackgroundResource(R.color.md_green_300);

        textView.setText(text);

        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    public static void error(Activity context, String text) {

        activity = (Activity) context;

        LayoutInflater inflater = activity.getLayoutInflater();
        layout = inflater.inflate(R.layout.toast, (ViewGroup) activity.findViewById(R.id.root));
        textView = (TextView) layout.findViewById(R.id.toasttext);

        layout.setBackgroundResource(R.color.md_red_300);

        textView.setText(text);

        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}
