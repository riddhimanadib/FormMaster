package me.riddhimanadib.formmaster.viewholder;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import me.riddhimanadib.formmaster.R;
import me.riddhimanadib.formmaster.model.BaseFormElement;

/**
 * Created by rodolfo on 12/26/17.
 */

public class FormElementLabelHolder extends BaseViewHolder {

    public AppCompatTextView mTextViewTitle;

    public FormElementLabelHolder(View v) {
        super(v);
        mTextViewTitle = (AppCompatTextView) v.findViewById(R.id.formElementTitle);
    }

    @Override
    public void bind(int position, BaseFormElement formElement, final Context context) {
        mTextViewTitle.setText(formElement.getTitle());
    }

}
