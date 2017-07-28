package me.riddhimanadib.formmaster.model;

/**
 * Created by Riddhi - Rudra on 28-Jul-17.
 */

public class FormElementPickerTime extends BaseFormElement {

    public FormElementPickerTime() {
    }

    public static FormElementPickerTime createInstance() {
        FormElementPickerTime FormElementPickerTime = new FormElementPickerTime();
        FormElementPickerTime.setType(BaseFormElement.TYPE_PICKER_TIME);
        return FormElementPickerTime;
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

}
