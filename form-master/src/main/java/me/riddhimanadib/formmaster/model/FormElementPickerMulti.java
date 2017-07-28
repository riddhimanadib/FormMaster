package me.riddhimanadib.formmaster.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Riddhi - Rudra on 28-Jul-17.
 */

public class FormElementPickerMulti extends BaseFormElement {

    private String pickerTitle; // custom title for picker
    private List<String> mOptions; // list of options for single and multi picker
    private List<String> mOptionsSelected; // list of selected options for single and multi picker

    public FormElementPickerMulti() {
    }

    public static FormElementPickerMulti createInstance() {
        FormElementPickerMulti FormElementPickerMulti = new FormElementPickerMulti();
        FormElementPickerMulti.setType(BaseFormElement.TYPE_PICKER_MULTI);
        return FormElementPickerMulti;
    }

    public FormElementPickerMulti setTag(int mTag) {
        return (FormElementPickerMulti)  super.setTag(mTag);
    }

    public FormElementPickerMulti setType(int mType) {
        return (FormElementPickerMulti)  super.setType(mType);
    }

    public FormElementPickerMulti setTitle(String mTitle) {
        return (FormElementPickerMulti)  super.setTitle(mTitle);
    }

    public FormElementPickerMulti setValue(String mValue) {
        return (FormElementPickerMulti)  super.setValue(mValue);
    }

    public FormElementPickerMulti setHint(String mHint) {
        return (FormElementPickerMulti)  super.setHint(mHint);
    }

    public FormElementPickerMulti setRequired(boolean required) {
        return (FormElementPickerMulti)  super.setRequired(required);
    }

    // custom setters
    public FormElementPickerMulti setOptions(List<String> mOptions) {
        this.mOptions = mOptions;
        return this;
    }

    public FormElementPickerMulti setOptionsSelected(List<String> mOptionsSelected) {
        this.mOptionsSelected = mOptionsSelected;
        return this;
    }

    public FormElementPickerMulti setPickerTitle(String title) {
        this.pickerTitle = title;
        return this;
    }

    // custom getters
    public List<String> getOptions() {
        return (this.mOptions == null) ? new ArrayList<String>() : this.mOptions;
    }

    public List<String> getOptionsSelected() {
        return (this.mOptionsSelected == null) ? new ArrayList<String>() : this.mOptionsSelected;
    }

    public String getPickerTitle() {
        return this.pickerTitle;
    }

}
