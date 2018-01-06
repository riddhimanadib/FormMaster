package me.riddhimanadib.formmaster.model;

/**
 * Created by rodolfo on 12/26/17.
 */

public class FormElementButton extends BaseFormElement {

    public FormElementButton() {
    }

    /**
     * static method to create instance with title
     * @param title
     * @return
     */
    public static FormElementButton createInstance(String title) {
        FormElementButton formElementButton = new FormElementButton();
        formElementButton.setType(BaseFormElement.TYPE_BUTTON);
        formElementButton.setTitle(title);
        return formElementButton;
    }

    public FormElementButton setTag(int mTag) {
        return (FormElementButton)  super.setTag(mTag);
    }

}
