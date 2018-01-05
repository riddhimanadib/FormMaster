package me.riddhimanadib.formmaster.model;

/**
 * Created by rodolfo on 12/26/17.
 */

public class FormElementClickableLabel extends BaseFormElement {

    public FormElementClickableLabel() {
    }

    /**
     * static method to create instance with title
     * @param title
     * @return
     */
    public static FormElementClickableLabel createInstance(String title) {
        FormElementClickableLabel formElementButton = new FormElementClickableLabel();
        formElementButton.setType(BaseFormElement.TYPE_CLICKABLE_LABEL);
        formElementButton.setTitle(title);
        return formElementButton;
    }

    public FormElementClickableLabel setTag(int mTag) {
        return (FormElementClickableLabel)  super.setTag(mTag);
    }

}
