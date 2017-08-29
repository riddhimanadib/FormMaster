package me.riddhimanadib.formmaster.model;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Riddhi - Rudra on 28-Jul-17.
 */

public class FormElementPickerTime extends BaseFormElement {

    private String timeFormat; // custom format for date

    public FormElementPickerTime() {
    }

    public static FormElementPickerTime createInstance() {
        FormElementPickerTime formElementPickerTime = new FormElementPickerTime();
        formElementPickerTime.setType(BaseFormElement.TYPE_PICKER_TIME);
        formElementPickerTime.setTimeFormat("KK:mm a");
        return formElementPickerTime;
    }

    public FormElementPickerTime setTag(int mTag) {
        return (FormElementPickerTime)  super.setTag(mTag);
    }

    public FormElementPickerTime setType(int mType) {
        return (FormElementPickerTime)  super.setType(mType);
    }

    public FormElementPickerTime setTitle(String mTitle) {
        return (FormElementPickerTime)  super.setTitle(mTitle);
    }

    public FormElementPickerTime setValue(String mValue) {
        return (FormElementPickerTime)  super.setValue(mValue);
    }

    public FormElementPickerTime setHint(String mHint) {
        return (FormElementPickerTime)  super.setHint(mHint);
    }

    public FormElementPickerTime setRequired(boolean required) {
        return (FormElementPickerTime)  super.setRequired(required);
    }

    // custom setter
    public FormElementPickerTime setTimeFormat(String format) {
        checkValidTimeFormat(format);
        this.timeFormat = format;
        return this;
    }

    // custom getter
    public String getTimeFormat() {
        return this.timeFormat;
    }

    private void checkValidTimeFormat(String format) {
        try {
            new SimpleDateFormat(format, Locale.US);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Time format is not correct: " + e.getMessage());
        }
    }

}
