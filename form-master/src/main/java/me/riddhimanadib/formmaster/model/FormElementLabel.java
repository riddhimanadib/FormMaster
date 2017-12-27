package me.riddhimanadib.formmaster.model;

/**
 * Created by rodolfo on 12/26/17.
 */

public class FormElementLabel extends BaseFormElement {

    public FormElementLabel() {
    }

    /**
     * static method to create instance with title
     * @param title
     * @return
     */
    public static FormElementLabel createInstance(String title) {
        FormElementLabel label = new FormElementLabel();
        label.setType(BaseFormElement.TYPE_LABEL);
        label.setTitle(title);
        return label;
    }

}
