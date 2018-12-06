package me.riddhimanadib.formmaster.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import me.riddhimanadib.formmaster.R;
import me.riddhimanadib.formmaster.listener.FormItemEditTextListener;
import me.riddhimanadib.formmaster.listener.OnFormElementValueChangedListener;
import me.riddhimanadib.formmaster.model.BaseFormElement;
import me.riddhimanadib.formmaster.viewholder.BaseViewHolder;
import me.riddhimanadib.formmaster.viewholder.FormElementHeader;
import me.riddhimanadib.formmaster.viewholder.FormElementPickerDateViewHolder;
import me.riddhimanadib.formmaster.viewholder.FormElementPickerMultiViewHolder;
import me.riddhimanadib.formmaster.viewholder.FormElementPickerSingleViewHolder;
import me.riddhimanadib.formmaster.viewholder.FormElementPickerTimeViewHolder;
import me.riddhimanadib.formmaster.viewholder.FormElementSwitchViewHolder;
import me.riddhimanadib.formmaster.viewholder.FormElementTextEmailViewHolder;
import me.riddhimanadib.formmaster.viewholder.FormElementTextMultiLineViewHolder;
import me.riddhimanadib.formmaster.viewholder.FormElementTextNumberViewHolder;
import me.riddhimanadib.formmaster.viewholder.FormElementTextPasswordViewHolder;
import me.riddhimanadib.formmaster.viewholder.FormElementTextPhoneViewHolder;
import me.riddhimanadib.formmaster.viewholder.FormElementTextSingleLineViewHolder;
import me.riddhimanadib.formmaster.listener.ReloadListener;

/**
 * The adapter the holds and displays the form objects
 * Created by Adib on 16-Apr-17.
 */

public class FormAdapter extends RecyclerView.Adapter<BaseViewHolder> implements ReloadListener {

    private Context mContext;
    private List<BaseFormElement> mDataset;
    private OnFormElementValueChangedListener mListener;

    /**
     * public constructor with context
     * @param context
     */
    public FormAdapter(Context context, OnFormElementValueChangedListener listener) {
        mContext = context;
        mListener = listener;
        mDataset = new ArrayList<>();
    }

    /**
     * adds list of elements to be shown
     * @param formObjects
     */
    public void addElements(List<BaseFormElement> formObjects) {
        this.mDataset = formObjects;
        notifyDataSetChanged();
    }

    /**
     * adds single element to be shown
     * @param formObject
     */
    public void addElement(BaseFormElement formObject) {
        this.mDataset.add(formObject);
        notifyDataSetChanged();
    }

    /**
     * set value for any unique index
     * @param position
     * @param value
     */
    public void setValueAtIndex(int position, String value) {
        BaseFormElement baseFormElement = mDataset.get(position);
        baseFormElement.setValue(value);
        notifyDataSetChanged();
    }

    /**
     * set value for any unique tag
     * @param tag
     * @param value
     */
    public void setValueAtTag(String tag, String value) {
        for (BaseFormElement f : this.mDataset) {
            if (f.getTag().equals(tag)) {
                f.setValue(value);
                return;
            }
        }
        notifyDataSetChanged();
    }

    /**
     * get value of any element by tag
     * @param index
     * @return
     */
    public BaseFormElement getValueAtIndex(int index) {
        return (mDataset.get(index));
    }

    /**
     * get value of any element by tag
     * @param tag
     * @return
     */
    public BaseFormElement getValueAtTag(String tag) {
        for (BaseFormElement f : this.mDataset) {
            if (f.getTag().equals(tag)) {
                return f;
            }
        }

        return null;
    }

    /**
     * get whole dataset
     * @return
     */
    public List<BaseFormElement> getDataset() {
        return mDataset;
    }

    /**
     * gets the iterator of dataset
     * @return
     */
    public Iterator<BaseFormElement> getIterator() {
        return mDataset.iterator();
    }

    /**
     * get value changed listener
     * @return
     */
    public OnFormElementValueChangedListener getValueChangeListener() {
        return mListener;
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
        return mDataset.get(position).getType();
    }

    /**
     * creating the view holder to be shown for a position
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // get layout based on header or element type
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v;
        switch (viewType) {
            case BaseFormElement.TYPE_HEADER:
                v = inflater.inflate(R.layout.form_element_header, parent, false);
                return new FormElementHeader(v);
            case BaseFormElement.TYPE_EDITTEXT_TEXT_SINGLELINE:
                v = inflater.inflate(R.layout.form_element, parent, false);
                return new FormElementTextSingleLineViewHolder(v, new FormItemEditTextListener(this));
            case BaseFormElement.TYPE_EDITTEXT_TEXT_MULTILINE:
                v = inflater.inflate(R.layout.form_element, parent, false);
                return new FormElementTextMultiLineViewHolder(v, new FormItemEditTextListener(this));
            case BaseFormElement.TYPE_EDITTEXT_NUMBER:
                v = inflater.inflate(R.layout.form_element, parent, false);
                return new FormElementTextNumberViewHolder(v, new FormItemEditTextListener(this));
            case BaseFormElement.TYPE_EDITTEXT_EMAIL:
                v = inflater.inflate(R.layout.form_element, parent, false);
                return new FormElementTextEmailViewHolder(v, new FormItemEditTextListener(this));
            case BaseFormElement.TYPE_EDITTEXT_PHONE:
                v = inflater.inflate(R.layout.form_element, parent, false);
                return new FormElementTextPhoneViewHolder(v, new FormItemEditTextListener(this));
            case BaseFormElement.TYPE_EDITTEXT_PASSWORD:
                v = inflater.inflate(R.layout.form_element, parent, false);
                return new FormElementTextPasswordViewHolder(v, new FormItemEditTextListener(this));
            case BaseFormElement.TYPE_PICKER_DATE:
                v = inflater.inflate(R.layout.form_element, parent, false);
                return new FormElementPickerDateViewHolder(v, mContext, this);
            case BaseFormElement.TYPE_PICKER_TIME:
                v = inflater.inflate(R.layout.form_element, parent, false);
                return new FormElementPickerTimeViewHolder(v, mContext, this);
            case BaseFormElement.TYPE_PICKER_SINGLE:
                v = inflater.inflate(R.layout.form_element, parent, false);
                return new FormElementPickerSingleViewHolder(v, mContext, this);
            case BaseFormElement.TYPE_PICKER_MULTI:
                v = inflater.inflate(R.layout.form_element, parent, false);
                return new FormElementPickerMultiViewHolder(v, mContext, this);
            case BaseFormElement.TYPE_SWITCH:
                v = inflater.inflate(R.layout.form_element_switch, parent, false);
                return new FormElementSwitchViewHolder(v, mContext, this);
            default:
                v = inflater.inflate(R.layout.form_element, parent, false);
                return new FormElementTextSingleLineViewHolder(v, new FormItemEditTextListener(this));
        }
    }

    /**
     * draws the view for the position specific view holder
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(BaseViewHolder holder, final int position) {

        // updates edit text listener index
        if (holder.getListener() != null) {
            holder.getListener().updatePosition(holder.getAdapterPosition());
        }

        // gets current object
        BaseFormElement currentObject = mDataset.get(position);
        holder.bind(position, currentObject, mContext);
    }

    /**
     * use the listener to update value and notify dataset changes to adapter
     * @param position
     * @param updatedValue
     */
    @Override
    public void updateValue(int position, String updatedValue) {
        mDataset.get(position).setValue(updatedValue);
        notifyDataSetChanged();
        if (mListener != null)
            mListener.onValueChanged(mDataset.get(position));
    }

}