package me.riddhimanadib.formmaster.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adib on 16-Apr-17.
 */

public class FormElement<T extends Object> implements FormObject {

    // different types for the form elements
    public static final int TYPE_EDITTEXT_TEXT_SINGLELINE = 1;
    public static final int TYPE_EDITTEXT_TEXT_MULTILINE = 2;
    public static final int TYPE_EDITTEXT_NUMBER = 3;
    public static final int TYPE_EDITTEXT_EMAIL = 4;
    public static final int TYPE_EDITTEXT_PHONE = 5;
    public static final int TYPE_PICKER_DATE = 6;
    public static final int TYPE_PICKER_TIME = 7;
    public static final int TYPE_SPINNER_DROPDOWN = 8;
    public static final int TYPE_PICKER_MULTI_CHECKBOX = 9;
    public static final int TYPE_EDITTEXT_PASSWORD = 10;

    // private variables
    private int mTag; // unique tag to identify the object
    private int mType; // type for the form element
    private String mTitle; // title to be shown on left
    private T mValue; // value to be shown on right
    private List<T> mOptions; // list of options for single and multi picker
    private List<T> mOptionsSelected; // list of selected options for single and multi picker
    private String mHint; // value to be shown if mValue is null
    private boolean mRequired; // value to set is the field is required

    public FormElement() {
    }

    /**
     * static method to create instance
     *
     * @return
     */
    public static FormElement<String> createInstance() {
        return new FormElement<>();
    }

    /**
     * static method to create instance using
     * custom generic value type
     * @return
     */
    public static <T> FormElement<T> createGenericInstance() { return new FormElement<T>(); }

    // getters and setters
    public FormElement<T> setTag(int mTag) {
        this.mTag = mTag;
        return this;
    }

    public FormElement<T> setType(int mType) {
        this.mType = mType;
        return this;
    }

    public FormElement<T> setTitle(String mTitle) {
        this.mTitle = mTitle;
        return this;
    }

    public FormElement<T> setValue(T mValue) {
        this.mValue = mValue;
        return this;
    }

    public FormElement<T> setHint(String mHint) {
        this.mHint = mHint;
        return this;
    }

    public FormElement<T> setRequired(boolean required) {
        this.mRequired = required;
        return this;
    }

    public FormElement<T> setOptions(List<T> mOptions) {
        this.mOptions = mOptions;
        return this;
    }

    public FormElement<T> setOptionsSelected(List<T> mOptionsSelected) {
        this.mOptionsSelected = mOptionsSelected;
        return this;
    }

    public int getTag() {
        return this.mTag;
    }

    public int getType() {
        return this.mType;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public T getValue() {
        return this.mValue;
    }

    public String getValueAsString() {
        return (this.mValue == null) ? "" : this.mValue.toString();
    }

    public String getHint() {
        return (this.mHint == null) ? "" : this.mHint;
    }

    public boolean isRequired() {
        return this.mRequired;
    }

    public List<T> getOptions() {
        return (this.mOptions == null) ? new ArrayList<T>() : this.mOptions;
    }

    public List<T> getOptionsSelected() {
        return (this.mOptionsSelected == null) ? new ArrayList<T>() : this.mOptionsSelected;
    }

    @Override
    public boolean isHeader() {
        return false;
    }

    @Override
    public String toString() {
        return "TAG: " + String.valueOf(this.mTag) + ", TITLE: " + this.mTitle + ", VALUE: " + this.mValue + ", REQUIRED: " + String.valueOf(this.mRequired);
    }

}
