package me.riddhimanadib.formmaster.adapter;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import me.riddhimanadib.formmaster.R;
import me.riddhimanadib.formmaster.model.FormElement;
import me.riddhimanadib.formmaster.model.FormHeader;
import me.riddhimanadib.formmaster.model.FormObject;

/**
 * The adpater the holds and displays the form objects
 * Created by Adib on 16-Apr-17.
 */

public class FormAdapter extends RecyclerView.Adapter<FormAdapter.ViewHolder> {

    // defining marker for header view
    private int IS_HEADER_VIEW = 0;

    private List<FormObject> mDataset;
    private Context mContext;
    private Calendar mCalendarCurrentDate;
    private Calendar mCalendarCurrentTime;

    private int clickedPosition;

    /**
     * public constructor with context
     * @param context
     */
    public FormAdapter(Context context) {
        mContext = context;
        mDataset = new ArrayList<>();
        mCalendarCurrentDate = Calendar.getInstance();
        mCalendarCurrentTime = Calendar.getInstance();
        clickedPosition = -1;
    }

    /**
     * adds list of elements to be shown
     * @param formObjects
     */
    public void addElements(List<FormObject> formObjects) {
        this.mDataset = formObjects;
    }

    /**
     * adds single element to be shown
     * @param formObject
     */
    public void addElement(FormObject formObject) {
        this.mDataset.add(formObject);
    }

    /**
     * set value for any unique index
     * @param position
     * @param value
     */
    public void setValueAtIndex(int position, String value) {
        FormElement formElement = (FormElement) mDataset.get(position);
        formElement.setValue(value);
    }

    /**
     * set value for any unique tag
     * @param tag
     * @param value
     */
    public void setValueAtTag(int tag, String value) {

        for (FormObject f : this.mDataset) {
            if (f instanceof FormElement) {
                FormElement formElement = (FormElement) f;
                if (formElement.getTag() == tag) {
                    formElement.setValue(value);
                    return;
                }
            }
        }
    }

    /**
     * get value of any element by tag
     * @param index
     * @return
     */
    public FormElement getValueAtIndex(int index) {
        return ((FormElement) mDataset.get(index));
    }

    /**
     * get value of any element by tag
     * @param tag
     * @return
     */
    public FormElement getValueAtTag(int tag) {
        for (FormObject f : this.mDataset) {
            if (f instanceof FormElement) {
                FormElement formElement = (FormElement) f;
                if (formElement.getTag() == tag) {
                    return formElement;
                }
            }
        }

        return null;
    }

    /**
     * gets total item count
     * @return
     */
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    /**
     * gets view item type based on header, or the form element type
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        if (mDataset.get(position).isHeader()) {
            return IS_HEADER_VIEW;
        } else {
            return ((FormElement) mDataset.get(position)).getType();
        }
    }

    /**
     * creating the view holder to be shown for a position
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public FormAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // get layout based on header or element type
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate((viewType == IS_HEADER_VIEW) ? R.layout.form_element_header : R.layout.form_element, parent, false);

        ViewHolder vh = new ViewHolder(v, new FormCustomEditTextListener());
        return vh;
    }

    /**
     * draws the view for the position specific view holder
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        // updates edit text listener index
        holder.mFormCustomEditTextListener.updatePosition(holder.getAdapterPosition());

        // gets current object
        FormObject currentObject = mDataset.get(position);

        // shows header view if it's a header
        if (getItemViewType(position) == IS_HEADER_VIEW) {
            FormHeader formHeader = (FormHeader) currentObject;
            holder.mTextViewTitle.setText(formHeader.getTitle());
        } else {
            // other wise, it just displays form element with respective type
            FormElement formElement = (FormElement) currentObject;
            holder.mTextViewTitle.setText(formElement.getTitle());
            holder.mEditTextValue.setText(formElement.getValue());
            holder.mEditTextValue.setHint(formElement.getHint());

            switch (getItemViewType(position)) {
                case FormElement.TYPE_EDITTEXT_TEXT_SINGLELINE:
                    holder.mEditTextValue.setMaxLines(1);
                    break;
                case FormElement.TYPE_EDITTEXT_TEXT_MULTILINE:
                    holder.mEditTextValue.setSingleLine(false);
                    holder.mEditTextValue.setMaxLines(4);
                    break;
                case FormElement.TYPE_EDITTEXT_NUMBER:
                    holder.mEditTextValue.setRawInputType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
                    break;
                case FormElement.TYPE_EDITTEXT_EMAIL:
                    holder.mEditTextValue.setRawInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS|InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
                    break;
                case FormElement.TYPE_EDITTEXT_PHONE:
                    holder.mEditTextValue.setRawInputType(InputType.TYPE_CLASS_PHONE|InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
                    break;
                case FormElement.TYPE_EDITTEXT_PASSWORD:
                    holder.mEditTextValue.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    holder.mEditTextValue.setSelection(holder.mEditTextValue.getText().length());
                    break;
                case FormElement.TYPE_PICKER_DATE:
                    setDatePicker(holder, position);
                    break;
                case FormElement.TYPE_PICKER_TIME:
                    setTimePicker(holder, position);
                    break;
                case FormElement.TYPE_SPINNER_DROPDOWN:
                    setSingleOptionsDialog(holder, position);
                    break;
                case FormElement.TYPE_PICKER_MULTI_CHECKBOX:
                    setMultipleOptionsDialog(holder.mEditTextValue, position);
                    break;
                default:
                    break;
            }
        }

    }

    /**
     * prepares the datepicker for the clicked position and attaches click listener for the passed edittext and listener for the itemview
     * @param holder
     * @param position
     */
    private void setDatePicker(ViewHolder holder, final int position) {

        holder.mEditTextValue.setFocusableInTouchMode(false);
        holder.mEditTextValue.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // saves clicked position for further reference
              showDatePickerDialog(position);
            }
        });

        holder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // saves clicked position for further reference
              showDatePickerDialog(position);
            }
        });

    }

  /**
   * prepares the datepickerdialog for the clicked position and updates the clickedPosition
   * @param position
   */
    private void showDatePickerDialog(int position){
        clickedPosition = position;

        // prepares date picker dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(mContext,
            date,
            mCalendarCurrentDate.get(Calendar.YEAR),
            mCalendarCurrentDate.get(Calendar.MONTH),
            mCalendarCurrentDate.get(Calendar.DAY_OF_MONTH));

        // this could be used to set a minimum date
        // datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);

        // display the picker
        datePickerDialog.show();
    }

    /**
     * prepares the timepicker for the clicked position and attaches click listener for the passed edittext
     * @param holder
     * @param position
     */
    private void setTimePicker(ViewHolder holder, final int position) {

        holder.mEditTextValue.setFocusableInTouchMode(false);
        holder.mEditTextValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              showTimePicker(position);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            showTimePicker(position);
          }
        });

    }

    private void showTimePicker(int position){

      // saves clicked position for further reference
      clickedPosition = position;

      // prepares time picker dialog
      TimePickerDialog timePickerDialog = new TimePickerDialog(mContext,
          time,
          mCalendarCurrentDate.get(Calendar.HOUR),
          mCalendarCurrentDate.get(Calendar.MINUTE),
          false);

      // display the picker
      timePickerDialog.show();
    }

    /**
     * prepares a single picker dialog for the clicked position and attaches click listener for the passed edittext
     * @param holder
     * @param position
     */
    private void setSingleOptionsDialog(final ViewHolder holder, final int position) {

        // get the element
        final FormElement currentObj = (FormElement) mDataset.get(position);

        holder.mEditTextValue.setFocusableInTouchMode(false);

        // reformat the options in format needed
        final CharSequence[] options = new CharSequence[currentObj.getOptions().size()];
        for (int i = 0; i < currentObj.getOptions().size(); i++) {
            options[i] = currentObj.getOptions().get(i);
        }

        // prepare the dialog
        final AlertDialog dialog = new AlertDialog.Builder(mContext)
                .setTitle("Pick one")
                .setItems(options, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        holder.mEditTextValue.setText(options[which]);
                        currentObj.setValue(options[which].toString());
                        notifyDataSetChanged();
                    }
                })
                .create();

        // display the dialog on click
        holder.mEditTextValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

      holder.itemView.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
          dialog.show();
        }
      });

    }

    /**
     * prepares a multi checkbox picker dialog for the clicked position and attaches click listener for the passed edittext
     * @param editText
     * @param position
     */
    private void setMultipleOptionsDialog(final AppCompatEditText editText, final int position) {

        // get the element
        final FormElement currentObj = (FormElement) mDataset.get(position);

        editText.setFocusableInTouchMode(false);

        // reformat the options in format needed
        final CharSequence[] options = new CharSequence[currentObj.getOptions().size()];
        final boolean[] optionsSelected = new boolean[currentObj.getOptions().size()];
        final ArrayList<Integer> mSelectedItems = new ArrayList();

        for (int i = 0; i < currentObj.getOptions().size(); i++) {
            options[i] = currentObj.getOptions().get(i);
            optionsSelected[i] = false;

            if (currentObj.getOptionsSelected().contains(options[i])) {
                optionsSelected[i] = true;
                mSelectedItems.add(i);
            }
        }

        // prepare the dialog
        final AlertDialog dialog  = new AlertDialog.Builder(mContext)
                .setTitle("Pick one or more")
                .setMultiChoiceItems(options, optionsSelected,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked) {
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
                        editText.setText(s);
                        ((FormElement) mDataset.get(position)).setValue(s);
                        notifyDataSetChanged();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                .create();

        // display the dialog on click
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
    }

    /**
     * View holder class
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView mTextViewTitle;
        public AppCompatTextView mTextViewOptions;
        public AppCompatEditText mEditTextValue;
        public FormCustomEditTextListener mFormCustomEditTextListener;

        public ViewHolder(View v, FormCustomEditTextListener listener) {
            super(v);
            mTextViewTitle = (AppCompatTextView) v.findViewById(R.id.formElementTitle);
            mTextViewOptions = (AppCompatTextView) v.findViewById(R.id.formElementTitle);
            mEditTextValue = (AppCompatEditText) v.findViewById(R.id.formElementValue);
            mFormCustomEditTextListener = listener;

            // attache generic text changed listener
            if (mEditTextValue != null)
                mEditTextValue.addTextChangedListener(mFormCustomEditTextListener);
        }
    }

    /**
     * Text watcher for Edit texts
     */
    private class FormCustomEditTextListener implements TextWatcher {
        private int position;

        public void updatePosition(int position) {
            this.position = position;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            // no op
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            FormElement formElement = (FormElement) mDataset.get(position);
            formElement.setValue(charSequence.toString());
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // no op
        }
    }

    /**
     * setting up date picker dialog listener
     */
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mCalendarCurrentDate.set(Calendar.YEAR, year);
            mCalendarCurrentDate.set(Calendar.MONTH, monthOfYear);
            mCalendarCurrentDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            String myFormatDate = "dd/MM/yy"; // custom format
            SimpleDateFormat sdfDate = new SimpleDateFormat(myFormatDate, Locale.US);

            // act only if clicked position is a valid index
            if (clickedPosition >= 0) {
                ((FormElement) mDataset.get(clickedPosition)).setValue(sdfDate.format(mCalendarCurrentDate.getTime()));
                notifyDataSetChanged();

                // change clicked position to default value
                clickedPosition = -1;
            }
        }

    };

    /**
     * setting up time picker dialog listener
     */
    TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            mCalendarCurrentTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            mCalendarCurrentTime.set(Calendar.MINUTE, minute);

            String myFormatTime = "KK:mm a"; // custom format
            SimpleDateFormat sdfTime = new SimpleDateFormat(myFormatTime, Locale.US);

            // act only if clicked position is a valid index
            if (clickedPosition >= 0) {
                ((FormElement) mDataset.get(clickedPosition)).setValue(sdfTime.format(mCalendarCurrentTime.getTime()));
                notifyDataSetChanged();

                // change clicked position to default value
                clickedPosition = -1;
            }
        }
    };

}