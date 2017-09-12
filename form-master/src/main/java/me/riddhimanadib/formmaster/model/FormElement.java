package me.riddhimanadib.formmaster.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adib on 16-Apr-17.
 */

public class FormElement implements FormObject {

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
    public static final Parcelable.Creator<FormElement> CREATOR = new Creator<FormElement>() {
        @Override
        public FormElement createFromParcel(Parcel source) {
            return new FormElement(source);
        }

        @Override
        public FormElement[] newArray(int size) {
            return new FormElement[size];
        }
    };
    // private variables
    private int mTag; // unique tag to identify the object
    private int mType; // type for the form element
    private String mTitle; // title to be shown on left
    private String mValue; // value to be shown on right
    private List<String> mOptions; // list of options for single and multi picker
    private List<String> mOptionsSelected; // list of selected options for single and multi picker
    private String mHint; // value to be shown if mValue is null
    private boolean mRequired; // value to set is the field is required

    public FormElement() {
    }

    private FormElement(Parcel in) {
        this.mTag = in.readInt();
        this.mType = in.readInt();
        this.mTitle = in.readString();
        this.mValue = in.readString();
        this.mOptions = new ArrayList<>();
        in.readStringList(this.mOptions);
        this.mOptionsSelected = new ArrayList<>();
        in.readStringList(this.mOptionsSelected);
        mRequired = in.readByte() != 0;
    }

    /**
     * static method to create instance
     *
     * @return
     */
    public static FormElement createInstance() {
        return new FormElement();
    }

    public int getTag() {
        return this.mTag;
    }

    // getters and setters
    public FormElement setTag(int mTag) {
        this.mTag = mTag;
        return this;
    }

    public int getType() {
        return this.mType;
    }

    public FormElement setType(int mType) {
        this.mType = mType;
        return this;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public FormElement setTitle(String mTitle) {
        this.mTitle = mTitle;
        return this;
    }

    public String getValue() {
        return (this.mValue == null) ? "" : this.mValue;
    }

    public FormElement setValue(String mValue) {
        this.mValue = mValue;
        return this;
    }

    public String getHint() {
        return (this.mHint == null) ? "" : this.mHint;
    }

    public FormElement setHint(String mHint) {
        this.mHint = mHint;
        return this;
    }

    public boolean isRequired() {
        return this.mRequired;
    }

    public FormElement setRequired(boolean required) {
        this.mRequired = required;
        return this;
    }

    public List<String> getOptions() {
        return (this.mOptions == null) ? new ArrayList<String>() : this.mOptions;
    }

    public FormElement setOptions(List<String> mOptions) {
        this.mOptions = mOptions;
        return this;
    }

    public List<String> getOptionsSelected() {
        return (this.mOptionsSelected == null) ? new ArrayList<String>() : this.mOptionsSelected;
    }

    public FormElement setOptionsSelected(List<String> mOptionsSelected) {
        this.mOptionsSelected = mOptionsSelected;
        return this;
    }

    @Override
    public boolean isHeader() {
        return false;
    }

    @Override
    public String toString() {
        return "TAG: " + String.valueOf(this.mTag) + ", TITLE: " + this.mTitle + ", VALUE: " + this.mValue + ", REQUIRED: " + String.valueOf(this.mRequired);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
//        this.mTag = in.readInt();
//        this.mType = in.readInt();
//        this.mTitle = in.readString();
//        this.mValue = in.readString();
//        this.mOptions = new ArrayList<>();
//        in.readStringList(this.mOptions);
//        this.mOptionsSelected = new ArrayList<>();
//        in.readStringList(this.mOptionsSelected);
//        mRequired = in.readByte() != 0;

        dest.writeInt(getTag());
        dest.writeInt(getType());
        dest.writeString(getTitle());
        dest.writeString(getValue());
        dest.writeStringList(getOptions());
        dest.writeStringList(getOptionsSelected());
        dest.writeByte((byte) (isRequired() ? 1 : 0));
    }

}
