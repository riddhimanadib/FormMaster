package me.riddhimanadib.formmaster.viewholder;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import me.riddhimanadib.formmaster.R;
import me.riddhimanadib.formmaster.listener.ReloadListener;
import me.riddhimanadib.formmaster.model.BaseFormElement;
import me.riddhimanadib.formmaster.model.FormElementPickerSingle;

/**
 * Created by Riddhi - Rudra on 30-Jul-17.
 */

public class FormElementPickerSingleViewHolder extends BaseViewHolder {

    private AppCompatTextView mTextViewTitle;
    private AppCompatEditText mEditTextValue;
    private ReloadListener mReloadListener;
    private BaseFormElement mFormElement;
    private FormElementPickerSingle mFormElementPickerSingle;
    private int mPosition;

    public FormElementPickerSingleViewHolder(View v, Context context, ReloadListener reloadListener) {
        super(v);
        mTextViewTitle = (AppCompatTextView) v.findViewById(R.id.formElementTitle);
        mEditTextValue = (AppCompatEditText) v.findViewById(R.id.formElementValue);
        mReloadListener = reloadListener;
    }

    @Override
    public void bind(final int position, BaseFormElement formElement, final Context context) {
        mFormElement = formElement;
        mPosition = position;
        mFormElementPickerSingle = (FormElementPickerSingle) mFormElement;

        mTextViewTitle.setText(formElement.getTitle());
        mEditTextValue.setText(formElement.getValue());
        mEditTextValue.setHint(formElement.getHint());
        mEditTextValue.setFocusableInTouchMode(false);

        // reformat the options in format needed
        final CharSequence[] options = new CharSequence[mFormElementPickerSingle.getOptions().size()];
        for (int i = 0; i < mFormElementPickerSingle.getOptions().size(); i++) {
            options[i] = mFormElementPickerSingle.getOptions().get(i);
        }

        final AlertDialog dialog = new AlertDialog.Builder(context)
            .setTitle(mFormElementPickerSingle.getPickerTitle())
            .setItems(options, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    mEditTextValue.setText(options[which]);
                    mFormElementPickerSingle.setValue(options[which].toString());
                    mFormElementPickerSingle.setSelectedIndex(which);
                    mReloadListener.updateValue(position, options[which].toString());
                }
            })
            .create();

        mEditTextValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

        mTextViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
    }

}
