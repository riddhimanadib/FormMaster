package me.riddhimanadib.formmaster.model;

/**
 * Created by Riddhi - Rudra on 28-Jul-17.
 */

public class FormElementTextMultiLine extends BaseFormElement {

    public FormElementTextMultiLine() {
    }

    public static FormElementTextMultiLine createInstance() {
        FormElementTextMultiLine FormElementTextMultiLine = new FormElementTextMultiLine();
        FormElementTextMultiLine.setType(BaseFormElement.TYPE_EDITTEXT_TEXT_MULTILINE);
        return FormElementTextMultiLine;
    }

    public FormElementTextMultiLine setTag(String mTag) {
        return (FormElementTextMultiLine)  super.setTag(mTag);
    }

    public FormElementTextMultiLine setType(int mType) {
        return (FormElementTextMultiLine)  super.setType(mType);
    }

    public FormElementTextMultiLine setTitle(String mTitle) {
        return (FormElementTextMultiLine)  super.setTitle(mTitle);
    }

    public FormElementTextMultiLine setValue(String mValue) {
        return (FormElementTextMultiLine)  super.setValue(mValue);
    }

    public FormElementTextMultiLine setHint(String mHint) {
        return (FormElementTextMultiLine)  super.setHint(mHint);
    }

    public FormElementTextMultiLine setRequired(boolean required) {
        return (FormElementTextMultiLine)  super.setRequired(required);
    }

}
