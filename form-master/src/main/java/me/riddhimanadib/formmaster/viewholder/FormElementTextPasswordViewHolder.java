package me.riddhimanadib.formmaster.viewholder;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import me.riddhimanadib.formmaster.R;
import me.riddhimanadib.formmaster.listener.FormItemEditTextListener;
import me.riddhimanadib.formmaster.model.BaseFormElement;

/**
 * Created by Riddhi - Rudra on 30-Jul-17.
 */

public class FormElementTextPasswordViewHolder extends BaseViewHolder {

    public AppCompatTextView mTextViewTitle;
    public AppCompatEditText mEditTextValue;
    public FormItemEditTextListener mFormCustomEditTextListener;

    public FormElementTextPasswordViewHolder(View v, FormItemEditTextListener listener) {
        super(v);
        mTextViewTitle = (AppCompatTextView) v.findViewById(R.id.formElementTitle);
        mEditTextValue = (AppCompatEditText) v.findViewById(R.id.formElementValue);
        mFormCustomEditTextListener = listener;
        mEditTextValue.addTextChangedListener(mFormCustomEditTextListener);
        mEditTextValue.setRawInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD|InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
    }

    @Override
    public FormItemEditTextListener getListener() {
        return mFormCustomEditTextListener;
    }

    @Override
    public void bind(int position, BaseFormElement formElement, final Context context) {
        mTextViewTitle.setText(formElement.getTitle());
        mEditTextValue.setText(formElement.getValue());
        mEditTextValue.setHint(formElement.getHint());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditTextValue.requestFocus();
                InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(mEditTextValue, InputMethodManager.SHOW_IMPLICIT);
            }
        });
    }

}
