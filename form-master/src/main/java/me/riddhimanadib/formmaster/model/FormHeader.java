package me.riddhimanadib.formmaster.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Object for header of the form lists
 * Created by Adib on 18-Apr-17.
 */

public class FormHeader implements FormObject {

    public static final Parcelable.Creator<FormHeader> CREATOR = new Parcelable.Creator<FormHeader>() {
        @Override
        public FormHeader createFromParcel(Parcel in) {
            return new FormHeader(in);
        }

        @Override
        public FormHeader[] newArray(int size) {
            return new FormHeader[size];
        }
    };
    private String mTitle;

    public FormHeader() {
    }

    private FormHeader(Parcel in) {
        this.mTitle = in.readString();
    }

    /**
     * static method to create instance
     *
     * @return
     */
    public static FormHeader createInstance() {
        return new FormHeader();
    }

    /**
     * returns the title
     *
     * @return
     */
    public String getTitle() {
        return this.mTitle;
    }

    /**
     * sets the title, returns itself
     *
     * @param title
     * @return
     */
    public FormHeader setTitle(String title) {
        this.mTitle = title;
        return this;
    }

    // methods necessary for saving this object in case of
    // activity getting destroyed

    @Override
    public boolean isHeader() {
        return true;
    }

    @Override
    public String toString() {
        return this.mTitle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(this.mTitle);
    }
}
