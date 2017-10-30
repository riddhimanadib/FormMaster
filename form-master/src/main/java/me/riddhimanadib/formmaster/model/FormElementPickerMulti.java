package me.riddhimanadib.formmaster.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Riddhi - Rudra on 28-Jul-17.
 */

public class FormElementPickerMulti extends BaseFormElement {

    private String pickerTitle; // custom title for picker
    private List<String> options; // list of options for single and multi picker
    private List<String> optionsSelected; // list of selected options for single and multi picker
    private String positiveText = "Ok"; // text for positive operation, like "ok"
    private String negativeText = "Cancel"; // text for negative operation, like "cancel"

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
        this.options = mOptions;
        return this;
    }

    public FormElementPickerMulti setOptionsSelected(List<String> mOptionsSelected) {
        this.optionsSelected = mOptionsSelected;
        return this;
    }

    public FormElementPickerMulti setPickerTitle(String title) {
        this.pickerTitle = title;
        return this;
    }

    // custom getters
    public List<String> getOptions() {
        return (this.options == null) ? new ArrayList<String>() : this.options;
    }

    public List<String> getOptionsSelected() {
        return (this.optionsSelected == null) ? new ArrayList<String>() : this.optionsSelected;
    }

    public FormElementPickerMulti setPositiveText(String positiveText) {
        this.positiveText = positiveText;
        return this;
    }

    public FormElementPickerMulti setNegativeText(String negativeText) {
        this.negativeText = negativeText;
        return this;
    }

    // custom getters
    public String getPickerTitle() {
        return this.pickerTitle;
    }

    public String getPositiveText() {
        return this.positiveText;
    }

    public String getNegativeText() {
        return this.negativeText;
    }

}
