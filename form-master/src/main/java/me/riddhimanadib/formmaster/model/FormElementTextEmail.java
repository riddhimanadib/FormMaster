package me.riddhimanadib.formmaster.model;

/**
 * Created by Riddhi - Rudra on 28-Jul-17.
 */

public class FormElementTextEmail extends BaseFormElement {

    public FormElementTextEmail() {
    }

    public static FormElementTextEmail createInstance() {
        FormElementTextEmail FormElementTextEmail = new FormElementTextEmail();
        FormElementTextEmail.setType(BaseFormElement.TYPE_EDITTEXT_EMAIL);
        return FormElementTextEmail;
    }

    public FormElementTextEmail setTag(String mTag) {
        return (FormElementTextEmail)  super.setTag(mTag);
    }

    public FormElementTextEmail setType(int mType) {
        return (FormElementTextEmail)  super.setType(mType);
    }

    public FormElementTextEmail setTitle(String mTitle) {
        return (FormElementTextEmail)  super.setTitle(mTitle);
    }

    public FormElementTextEmail setValue(String mValue) {
        return (FormElementTextEmail)  super.setValue(mValue);
    }

    public FormElementTextEmail setHint(String mHint) {
        return (FormElementTextEmail)  super.setHint(mHint);
    }

    public FormElementTextEmail setRequired(boolean required) {
        return (FormElementTextEmail)  super.setRequired(required);
    }

}
