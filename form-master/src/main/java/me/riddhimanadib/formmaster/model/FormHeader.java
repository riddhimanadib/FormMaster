package me.riddhimanadib.formmaster.model;

/**
 * Object for header of the form lists
 * Created by Adib on 18-Apr-17.
 */

public class FormHeader extends BaseFormElement {

    public FormHeader() {
    }

    /**
     * static method to create instance with title
     * @param title
     * @return
     */
    public static FormHeader createInstance(String title) {
        FormHeader formHeader = new FormHeader();
        formHeader.setTitle(title);
        return formHeader;
    }

    @Override
    public boolean isHeader() {
        return true;
    }

}
