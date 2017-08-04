package me.riddhimanadib.formmaster.model;

/**
 * Created by Riddhi - Rudra on 28-Jul-17.
 */

public class FormElementPickerDate extends BaseFormElement {

    // TODO: add date formats

    public FormElementPickerDate() {
    }

    public static FormElementPickerDate createInstance() {
        FormElementPickerDate FormElementPickerDate = new FormElementPickerDate();
        FormElementPickerDate.setType(BaseFormElement.TYPE_PICKER_DATE);
        return FormElementPickerDate;
    }

    public FormElementPickerDate setTag(int mTag) {
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
    
}
