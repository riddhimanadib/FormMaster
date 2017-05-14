package me.riddhimanadib.formmaster.listener;

import me.riddhimanadib.formmaster.model.FormElement;

public interface OnFormElementValueChangedListener {

    public void onValueChanged(FormElement rowDescriptor, String newValue);

}