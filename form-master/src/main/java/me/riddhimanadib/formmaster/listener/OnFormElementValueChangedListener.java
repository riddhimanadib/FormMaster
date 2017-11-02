package me.riddhimanadib.formmaster.listener;

import me.riddhimanadib.formmaster.model.BaseFormElement;

/**
 * Callback to activity when any data in form adapter is changed
 */

public interface OnFormElementValueChangedListener {

    void onValueChanged(BaseFormElement baseFormElement);

}