package me.riddhimanadib.formmaster.model;

/**
 * Object for header of the form lists
 * Created by Adib on 18-Apr-17.
 */

public class FormHeader implements FormObject {

    private String mTitle;

    public FormHeader() {
    }

    /**
     * static method to create instance
     * @return
     */
    public static FormHeader createInstance() {
        return new FormHeader();
    }

    /**
     * sets the title, returns itself
     * @param title
     * @return
     */
    public FormHeader setTitle(String title) {
        this.mTitle = title;
        return this;
    }

    /**
     * returns the title
     * @return
     */
    public String getTitle() {
        return this.mTitle;
    }

    @Override
    public boolean isHeader() {
        return true;
    }

    @Override
    public String toString() {
        return this.mTitle;
    }
}
