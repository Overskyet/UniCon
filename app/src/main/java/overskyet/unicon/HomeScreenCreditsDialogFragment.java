package overskyet.unicon;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeScreenCreditsDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.home_screen_credits_dialog, null));
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        Button okBtn = alertDialog.findViewById(R.id.home_screen_ok_dialog_button);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        TextView creditsBody = alertDialog.findViewById(R.id.home_screen_credits_dialog_body);
        creditsBody.setMovementMethod(LinkMovementMethod.getInstance());

        return alertDialog;
    }
}
