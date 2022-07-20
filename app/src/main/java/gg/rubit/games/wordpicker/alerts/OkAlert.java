package gg.rubit.games.wordpicker.alerts;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class OkAlert extends DialogFragment {

    private final String message;

    public OkAlert(String message) {
        this.message = message;
    }

    @NonNull @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(message).setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.cancel());

        return builder.create();
    }
}
