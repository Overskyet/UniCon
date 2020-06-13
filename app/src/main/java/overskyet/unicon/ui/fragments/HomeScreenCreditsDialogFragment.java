package overskyet.unicon.ui.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

import overskyet.unicon.R;

public class HomeScreenCreditsDialogFragment extends DialogFragment {

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialog_home_screen_credits, null));
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        Button okBtn = alertDialog.findViewById(R.id.home_screen_ok_dialog_button);
        okBtn.setOnClickListener(v -> Objects.requireNonNull(getDialog()).dismiss());

        TextView creditsBody = alertDialog.findViewById(R.id.home_screen_credits_dialog_body);
        creditsBody.setMovementMethod(LinkMovementMethod.getInstance());

        return alertDialog;
    }
}
