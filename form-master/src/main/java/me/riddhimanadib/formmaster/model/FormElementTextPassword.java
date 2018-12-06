package me.riddhimanadib.formmaster.model;

/**
 * Created by Riddhi - Rudra on 28-Jul-17.
 */

public class FormElementTextPassword extends BaseFormElement {

    public FormElementTextPassword() {
    }

    public static FormElementTextPassword createInstance() {
        FormElementTextPassword FormElementTextPassword = new FormElementTextPassword();
        FormElementTextPassword.setType(BaseFormElement.TYPE_EDITTEXT_PASSWORD);
        return FormElementTextPassword;
    }

    public FormElementTextPassword setTag(String mTag) {
        return (FormElementTextPassword)  super.setTag(mTag);
    }

    public FormElementTextPassword setType(int mType) {
        return (FormElementTextPassword)  super.setType(mType);
    }

    public FormElementTextPassword setTitle(String mTitle) {
        return (FormElementTextPassword)  super.setTitle(mTitle);
    }

    public FormElementTextPassword setValue(String mValue) {
        return (FormElementTextPassword)  super.setValue(mValue);
    }

    public FormElementTextPassword setHint(String mHint) {
        return (FormElementTextPassword)  super.setHint(mHint);
    }

    public FormElementTextPassword setRequired(boolean required) {
        return (FormElementTextPassword)  super.setRequired(required);
    }
    
}
