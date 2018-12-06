package me.riddhimanadib.formmaster;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import me.riddhimanadib.formmaster.adapter.FormAdapter;
import me.riddhimanadib.formmaster.listener.OnFormElementValueChangedListener;
import me.riddhimanadib.formmaster.model.BaseFormElement;

/** Wrapper class around the adapter to assist in building form
 * Created by Adib on 16-Apr-17.
 */

public class FormBuilder {

    private FormAdapter mFormAdapter;

    /**
     * constructor without listener callback for changed values
     * @param context
     * @param recyclerView
     */
    public FormBuilder(Context context, RecyclerView recyclerView) {
        initializeFormBuildHelper(context, recyclerView, null);
    }

    /**
     * constructor with listener callback for changed values
     * @param context
     * @param recyclerView
     */
    public FormBuilder(Context context, RecyclerView recyclerView, OnFormElementValueChangedListener listener) {
        initializeFormBuildHelper(context, recyclerView, listener);
    }

    /**
     * private method for initializing form build helper
     * @param context
     * @param recyclerView
     * @param listener
     */
    private void initializeFormBuildHelper(Context context, RecyclerView recyclerView, OnFormElementValueChangedListener listener) {

        // initialize form adapter
        this.mFormAdapter = new FormAdapter(context, listener);

        // set up the recyclerview with adapter
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager.setStackFromEnd(false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mFormAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    /**
     * add list of form elements to be shown
     * @param baseFormElements
     */
    public void addFormElements(List<BaseFormElement> baseFormElements) {
        this.mFormAdapter.addElements(baseFormElements);
    }

    /**
     * get value of specific form element
     * @param tag
     * @return
     */
    public BaseFormElement getFormElement(String tag) {
        return this.mFormAdapter.getValueAtTag(tag);
    }

    /**
     * get the Iterator
     * @return
     */
    public Iterator<BaseFormElement> getFormElementIterator() {
        return this.mFormAdapter.getIterator();
    }

    /**
     * convert to a map which key is tag
     * @return
     */
    public Map<String,String> convertToDataMap() {
        Map<String, String> dataSetMap = new HashMap<>(mFormAdapter.getItemCount());
        for (Iterator<BaseFormElement> iterator = getFormElementIterator(); iterator.hasNext(); ) {
            BaseFormElement baseFormElement = iterator.next();
            dataSetMap.put(baseFormElement.getTag(), baseFormElement.getValue());
        }
        return dataSetMap;
    }


    /**
     *
     * return true if the form is valid
     *
     * @return
     */
    public boolean isValidForm() {
        for (int i = 0; i < this.mFormAdapter.getItemCount(); i++) {
            BaseFormElement baseFormElement = this.mFormAdapter.getValueAtIndex(i);
            if (baseFormElement.isRequired() && TextUtils.isEmpty(baseFormElement.getValue())) {
                return false;
            }
        }
        return true;
    }

}