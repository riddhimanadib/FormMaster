package me.riddhimanadib.formmaster.model;

import android.os.Parcelable;

/**
 * Basic interface for all form elements,
 * every form header and element will implement this
 * Created by Adib on 18-Apr-17.
 */

public interface FormObject extends Parcelable {

    /**
     * returns if header element or not
     */
    boolean isHeader();

}
