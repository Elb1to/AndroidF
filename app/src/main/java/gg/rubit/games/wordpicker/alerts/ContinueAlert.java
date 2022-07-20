package gg.rubit.games.wordpicker.alerts;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import gg.rubit.games.wordpicker.WordPickerActivity;

public class ContinueAlert extends DialogFragment {

    private final String message;

    public ContinueAlert(String message) {
        this.message = message;
    }

    @NonNull @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(message).setPositiveButton("Continuar", (dialogInterface, i) -> startActivity(new Intent(getContext(), WordPickerActivity.class)));

        return builder.create();
    }
}
