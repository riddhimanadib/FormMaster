package me.riddhimanadib.formmaster.model;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Riddhi - Rudra on 28-Jul-17.
 */

public class FormElementPickerDate extends BaseFormElement {

    private String dateFormat; // custom format for date

    public FormElementPickerDate() {
    }

    public static FormElementPickerDate createInstance() {
        FormElementPickerDate formElementPickerDate = new FormElementPickerDate();
        formElementPickerDate.setType(BaseFormElement.TYPE_PICKER_DATE);
        formElementPickerDate.setDateFormat("dd/MM/yy");
        return formElementPickerDate;
    }

    public FormElementPickerDate setTag(String mTag) {
        return (FormElementPickerDate)  super.setTag(mTag);
    }

    public FormElementPickerDate setType(int mType) {
        return (FormElementPickerDate)  super.setType(mType);
    }

    public FormElementPickerDate setTitle(String mTitle) {
        return (FormElementPickerDate)  super.setTitle(mTitle);
    }

    public FormElementPickerDate setValue(String mValue) {
        return (FormElementPickerDate)  super.setValue(mValue);
    }

    public FormElementPickerDate setHint(String mHint) {
        return (FormElementPickerDate)  super.setHint(mHint);
    }

    public FormElementPickerDate setRequired(boolean required) {
        return (FormElementPickerDate)  super.setRequired(required);
    }

    // custom setter
    public FormElementPickerDate setDateFormat(String format) {
        checkValidDateFormat(format);
        this.dateFormat = format;
        return this;
    }

    // custom getter
    public String getDateFormat() {
        return this.dateFormat;
    }

    private void checkValidDateFormat(String format) {
        try {
            new SimpleDateFormat(format, Locale.US);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Date format is not correct: " + e.getMessage());
        }
    }
    
}
