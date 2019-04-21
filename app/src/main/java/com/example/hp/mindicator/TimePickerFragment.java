package com.example.hp.mindicator;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar calendar= Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute=calendar.get(Calendar.MINUTE);

        TimePickerDialog tpd= new TimePickerDialog(getActivity(),this,hour,minute,false);
        return tpd;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Button button = getActivity().findViewById(R.id.button_timepicker_);
        String time_  = String.valueOf(hourOfDay)+":"+String.valueOf(minute);
        button.setText(time_);
    }
}
