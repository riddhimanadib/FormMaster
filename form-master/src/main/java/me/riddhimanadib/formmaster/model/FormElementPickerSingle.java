package me.riddhimanadib.formmaster.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Riddhi - Rudra on 28-Jul-17.
 */

public class FormElementPickerSingle extends BaseFormElement {

    private String pickerTitle; // custom title for picker
    private List mOptions; // list of options for single and multi picker
    private List mOptionsSelected; // list of selected options for single and multi picker
    private int selectedIndex;

    public FormElementPickerSingle() {
    }

    public static FormElementPickerSingle createInstance() {
        FormElementPickerSingle formElementPickerSingle = new FormElementPickerSingle();
        formElementPickerSingle.setType(BaseFormElement.TYPE_PICKER_SINGLE);
        formElementPickerSingle.setPickerTitle("Pick one");
        return formElementPickerSingle;
    }

    public FormElementPickerSingle setTag(int mTag) {
        return (FormElementPickerSingle)  super.setTag(mTag);
    }

    public FormElementPickerSingle setType(int mType) {
        return (FormElementPickerSingle)  super.setType(mType);
    }

    public FormElementPickerSingle setTitle(String mTitle) {
        return (FormElementPickerSingle)  super.setTitle(mTitle);
    }

    public FormElementPickerSingle setValue(String mValue) {
        return (FormElementPickerSingle)  super.setValue(mValue);
    }

    public FormElementPickerSingle setHint(String mHint) {
        return (FormElementPickerSingle)  super.setHint(mHint);
    }

    public FormElementPickerSingle setRequired(boolean required) {
        return (FormElementPickerSingle)  super.setRequired(required);
    }

    // custom setters
    public FormElementPickerSingle setOptions(List mOptions) {
        this.mOptions = mOptions;
        return this;
    }

    public FormElementPickerSingle setOptionsSelected(List mOptionsSelected) {
        this.mOptionsSelected = mOptionsSelected;
        return this;
    }

    public FormElementPickerSingle setPickerTitle(String title) {
        this.pickerTitle = title;
        return this;
    }

    // custom getters
    public List getOptions() {
        return (this.mOptions == null) ? new ArrayList<>() : this.mOptions;
    }

    public List getOptionsSelected() {
        return (this.mOptionsSelected == null) ? new ArrayList<>() : this.mOptionsSelected;
    }

    public String getPickerTitle() {
        return this.pickerTitle;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }
}
