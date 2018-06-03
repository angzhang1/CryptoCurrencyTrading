package edu.scu.finalproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ErrorDialog extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_page);
    }

    public void error_alert(View view) {
        DialogFragment newFragment = new AlertDialogFragment();
        showDialogFragment(newFragment);
    }


    public static class AlertDialogFragment extends DialogFragment {
//        public static AlertDialogFragment newInstance() {
//            return new AlertDialogFragment();
//        }

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity(),
                    R.style.AlertDialogCustom);

            alertDialog.setTitle("Error");
            alertDialog.setMessage("The amount you sell is over the amount you own.\n" +
                    "Please change your selling amount.");
            alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
            alertDialog.setPositiveButton(android.R.string.ok, null);
            return alertDialog.create();
        }
    }

    void showDialogFragment(DialogFragment newFragment) {
        newFragment.show(getFragmentManager(), "error");
    }
}
