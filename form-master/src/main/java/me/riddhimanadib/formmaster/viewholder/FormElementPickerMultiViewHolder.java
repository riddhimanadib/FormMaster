package me.riddhimanadib.formmaster.viewholder;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import java.util.ArrayList;

import me.riddhimanadib.formmaster.R;
import me.riddhimanadib.formmaster.listener.ReloadListener;
import me.riddhimanadib.formmaster.model.BaseFormElement;
import me.riddhimanadib.formmaster.model.FormElementPickerMulti;

/**
 * Created by Riddhi - Rudra on 30-Jul-17.
 */

public class FormElementPickerMultiViewHolder extends BaseViewHolder {

    private AppCompatTextView mTextViewTitle;
    private AppCompatEditText mEditTextValue;
    private ReloadListener mReloadListener;
    private BaseFormElement mFormElement;
    private FormElementPickerMulti mFormElementPickerMulti;
    private int mPosition;

    public FormElementPickerMultiViewHolder(View v, Context context, ReloadListener reloadListener) {
        super(v);
        mTextViewTitle = (AppCompatTextView) v.findViewById(R.id.formElementTitle);
        mEditTextValue = (AppCompatEditText) v.findViewById(R.id.formElementValue);
        mReloadListener = reloadListener;
    }

    @Override
    public void bind(final int position, BaseFormElement formElement, final Context context) {
        mFormElement = formElement;
        mPosition = position;
        mFormElementPickerMulti = (FormElementPickerMulti) mFormElement;

        mTextViewTitle.setText(formElement.getTitle());
        mEditTextValue.setText(formElement.getValue());
        mEditTextValue.setHint(formElement.getHint());
        mEditTextValue.setFocusableInTouchMode(false);

        // reformat the options in format needed
        final CharSequence[] options = new CharSequence[mFormElementPickerMulti.getOptions().size()];
        final boolean[] optionsSelected = new boolean[mFormElementPickerMulti.getOptions().size()];
        final ArrayList<Integer> mSelectedItems = new ArrayList();

        for (int i = 0; i < mFormElementPickerMulti.getOptions().size(); i++) {
            options[i] = mFormElementPickerMulti.getOptions().get(i);
            optionsSelected[i] = false;

            if (mFormElementPickerMulti.getOptionsSelected().contains(options[i])) {
                optionsSelected[i] = true;
                mSelectedItems.add(i);
            }
        }

        // prepare the dialog
        final AlertDialog dialog  = new AlertDialog.Builder(context)
                .setTitle("Pick one or more")
                .setMultiChoiceItems(options, optionsSelected,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    mSelectedItems.add(which);
                                } else if (mSelectedItems.contains(which)) {
                                    // Else, if the item is already in the array, remove it
                                    mSelectedItems.remove(Integer.valueOf(which));
                                }
                            }
                        })
                // Set the action buttons
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String s = "";
                        for (int i = 0; i < mSelectedItems.size(); i++) {
                            s += options[mSelectedItems.get(i)];

                            if (i < mSelectedItems.size() - 1) {
                                s += ", ";
                            }
                        }
                        mEditTextValue.setText(s);
                        mReloadListener.updateValue(position, s);
                    }
                })
                .setNegativeButton("Cancel", null)
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
