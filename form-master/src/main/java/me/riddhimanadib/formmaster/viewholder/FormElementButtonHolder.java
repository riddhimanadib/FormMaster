package me.riddhimanadib.formmaster.viewholder;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import me.riddhimanadib.formmaster.R;
import me.riddhimanadib.formmaster.listener.OnActionListener;
import me.riddhimanadib.formmaster.model.BaseFormElement;

/**
 * Created by rodolfo on 12/26/17.
 */

public class FormElementButtonHolder extends BaseViewHolder {

    public AppCompatTextView mTextViewTitle;
    private OnActionListener mOnActionListener;

    public FormElementButtonHolder(View v, OnActionListener onActionListener) {
        super(v);
        mTextViewTitle = (AppCompatTextView) v.findViewById(R.id.formElementTitle);
        mOnActionListener = onActionListener;
    }

    @Override
    public void bind(int position, final BaseFormElement formElement, final Context context) {
        mTextViewTitle.setText(formElement.getTitle());

        mTextViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnActionListener != null) {
                    mOnActionListener.onAction(formElement);
                }
            }
        });
    }

}
