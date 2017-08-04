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

public class FormElementTextSingleLineViewHolder extends BaseViewHolder {

    public AppCompatTextView mTextViewTitle;
    public AppCompatEditText mEditTextValue;
    public FormItemEditTextListener mFormCustomEditTextListener;

    public FormElementTextSingleLineViewHolder(View v, FormItemEditTextListener listener) {
        super(v);
        mTextViewTitle = (AppCompatTextView) v.findViewById(R.id.formElementTitle);
        mEditTextValue = (AppCompatEditText) v.findViewById(R.id.formElementValue);
        mFormCustomEditTextListener = listener;
        mEditTextValue.addTextChangedListener(mFormCustomEditTextListener);
        mEditTextValue.setMaxLines(1);
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




/**
 * View holder class
 */
    /*
    public static class FormViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView mTextViewTitle;
        public AppCompatEditText mEditTextValue;
        public FormCustomEditTextListener mFormCustomEditTextListener;

        public FormViewHolder(View v, FormCustomEditTextListener listener) {
            super(v);
            mTextViewTitle = (AppCompatTextView) v.findViewById(R.id.formElementTitle);
            mEditTextValue = (AppCompatEditText) v.findViewById(R.id.formElementValue);
            mFormCustomEditTextListener = listener;

            if (mEditTextValue != null)
                mEditTextValue.addTextChangedListener(mFormCustomEditTextListener);
        }
    }*/



/**
 * setting up time picker dialog listener
 */
    /*TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            mCalendarCurrentTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            mCalendarCurrentTime.set(Calendar.MINUTE, minute);

            String myFormatTime = "KK:mm a"; // custom format
            SimpleDateFormat sdfTime = new SimpleDateFormat(myFormatTime, Locale.US);

            // act only if clicked position is a valid index
            if (clickedPosition >= 0) {
                // get current form element, existing value and new value
                BaseFormElement baseFormElement = mDataset.get(clickedPosition);
                String currentValue = baseFormElement.getValue();
                String newValue = sdfTime.format(mCalendarCurrentTime.getTime());

                // trigger event only if the value is changed
                if (!currentValue.equals(newValue)) {
                    baseFormElement.setValue(newValue);
                    notifyDataSetChanged();
                    if (mListener != null)
                        mListener.onValueChanged(baseFormElement);
                }

                // change clicked position to default value
                clickedPosition = -1;
            }
        }
    };*/


//    /**
//     * brings focus when clicked on the whole container
//     * @param holder
//     */
//    private void setEditTextFocusEnabled(Context context) {
//        this.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                this.mEditTextValue.requestFocus();
//                InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.showSoftInput(holder.mEditTextValue, InputMethodManager.SHOW_IMPLICIT);
//            }
//        });
//    }
//
//    /**
//     * prepares the datepicker for the clicked position and attaches click listener for the passed edittext and listener for the itemview
//     * @param holder
//     * @param position
//     */
//    private void setDatePicker(FormAdapter.FormViewHolder holder, final int position) {
//
//        holder.mEditTextValue.setFocusableInTouchMode(false);
//        holder.mEditTextValue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // saves clicked position for further reference
//                showDatePickerDialog(position);
//            }
//        });
//
//        holder.mTextViewTitle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // saves clicked position for further reference
//                showDatePickerDialog(position);
//            }
//        });
//
//    }
//
//    /**
//     * prepares the date picker dialog for the clicked position and updates the clickedPosition
//     * @param position
//     */
//    private void showDatePickerDialog(int position) {
//        clickedPosition = position;
//
//        // prepares date picker dialog
//        DatePickerDialog datePickerDialog = new DatePickerDialog(mContext,
//                date,
//                mCalendarCurrentDate.get(Calendar.YEAR),
//                mCalendarCurrentDate.get(Calendar.MONTH),
//                mCalendarCurrentDate.get(Calendar.DAY_OF_MONTH));
//
//        // this could be used to set a minimum date
//        // datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
//
//        // display the picker
//        datePickerDialog.show();
//    }
//
//    /**
//     * prepares the timepicker for the clicked position and attaches click listener for the passed edittext
//     * @param holder
//     * @param position
//     */
//    private void setTimePicker(FormAdapter.FormViewHolder holder, final int position) {
//
//        holder.mEditTextValue.setFocusableInTouchMode(false);
//        holder.mEditTextValue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showTimePicker(position);
//            }
//        });
//
//        holder.mTextViewTitle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showTimePicker(position);
//            }
//        });
//
//    }
//
//    /**
//     * prepares the time picker dialog for the clicked position and updates the clickedPosition
//     * @param position
//     */
//    private void showTimePicker(int position) {
//
//        // saves clicked position for further reference
//        clickedPosition = position;
//
//        // prepares time picker dialog
//        TimePickerDialog timePickerDialog = new TimePickerDialog(mContext,
//                time,
//                mCalendarCurrentDate.get(Calendar.HOUR),
//                mCalendarCurrentDate.get(Calendar.MINUTE),
//                false);
//
//        // display the picker
//        timePickerDialog.show();
//    }
//
//    /**
//     * prepares a single picker dialog for the clicked position and attaches click listener for the passed edittext
//     * @param holder
//     * @param position
//     */
//    private void setSingleOptionsDialog(final FormAdapter.FormViewHolder holder, final int position) {
//
//        // get the element
//        final FormElementPickerSingle currentObj = (FormElementPickerSingle) mDataset.get(position);
//
//        // reformat the options in format needed
//        final CharSequence[] options = new CharSequence[currentObj.getOptions().size()];
//        for (int i = 0; i < currentObj.getOptions().size(); i++) {
//            options[i] = currentObj.getOptions().get(i);
//        }
//
//        // prepare the dialog
//        final AlertDialog dialog = new AlertDialog.Builder(mContext)
//                .setTitle(currentObj.getPickerTitle())
//                .setItems(options, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        holder.mEditTextValue.setText(options[which]);
//                        currentObj.setValue(options[which].toString());
//                        notifyDataSetChanged();
//                    }
//                })
//                .create();
//
//        holder.mEditTextValue.setFocusableInTouchMode(false);
//        holder.mEditTextValue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.show();
//            }
//        });
//
//        holder.mTextViewTitle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.show();
//            }
//        });
//
//    }
//
//    /**
//     * prepares a multi checkbox picker dialog for the clicked position and attaches click listener for the passed edittext
//     * @param holder
//     * @param position
//     */
//    private void setMultipleOptionsDialog(final FormAdapter.FormViewHolder holder, final int position) {
//
//        // get the element
//        final FormElementPickerMulti currentObj = (FormElementPickerMulti) mDataset.get(position);
//
//        // reformat the options in format needed
//        final CharSequence[] options = new CharSequence[currentObj.getOptions().size()];
//        final boolean[] optionsSelected = new boolean[currentObj.getOptions().size()];
//        final ArrayList<Integer> mSelectedItems = new ArrayList();
//
//        for (int i = 0; i < currentObj.getOptions().size(); i++) {
//            options[i] = currentObj.getOptions().get(i);
//            optionsSelected[i] = false;
//
//            if (currentObj.getOptionsSelected().contains(options[i])) {
//                optionsSelected[i] = true;
//                mSelectedItems.add(i);
//            }
//        }
//
//        // prepare the dialog
//        final AlertDialog dialog  = new AlertDialog.Builder(mContext)
//                .setTitle("Pick one or more")
//                .setMultiChoiceItems(options, optionsSelected,
//                        new DialogInterface.OnMultiChoiceClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which,
//                                                boolean isChecked) {
//                                if (isChecked) {
//                                    // If the user checked the item, add it to the selected items
//                                    mSelectedItems.add(which);
//                                } else if (mSelectedItems.contains(which)) {
//                                    // Else, if the item is already in the array, remove it
//                                    mSelectedItems.remove(Integer.valueOf(which));
//                                }
//                            }
//                        })
//                // Set the action buttons
//                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//                        String s = "";
//                        for (int i = 0; i < mSelectedItems.size(); i++) {
//                            s += options[mSelectedItems.get(i)];
//
//                            if (i < mSelectedItems.size() - 1) {
//                                s += ", ";
//                            }
//                        }
//                        holder.mEditTextValue.setText(s);
//                        mDataset.get(position).setValue(s);
//                        notifyDataSetChanged();
//                    }
//                })
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//
//                    }
//                })
//                .create();
//
//        holder.mEditTextValue.setFocusableInTouchMode(false);
//        holder.mEditTextValue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.show();
//            }
//        });
//
//        holder.mTextViewTitle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.show();
//            }
//        });
//    }
