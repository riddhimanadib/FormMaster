package me.riddhimanadib.formmaster.viewholder;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import me.riddhimanadib.formmaster.R;
import me.riddhimanadib.formmaster.model.BaseFormElement;

/**
 * ViewHolder for Header
 * Created by Riddhi - Rudra on 30-Jul-17.
 */

public class FormElementHeader extends BaseViewHolder {

    public AppCompatTextView mTextViewTitle;

    public FormElementHeader(View v) {
        super(v);
        mTextViewTitle = (AppCompatTextView) v.findViewById(R.id.formElementTitle);
    }

    @Override
    public void bind(int position, BaseFormElement formElement, final Context context) {
        mTextViewTitle.setText(formElement.getTitle());
    }

}
