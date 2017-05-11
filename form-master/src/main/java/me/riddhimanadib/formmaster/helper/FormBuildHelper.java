package me.riddhimanadib.formmaster.helper;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import me.riddhimanadib.formmaster.adapter.FormAdapter;
import me.riddhimanadib.formmaster.model.FormElement;
import me.riddhimanadib.formmaster.model.FormObject;

/** Wrapper class around the adapter to assist in building form
 * Created by Adib on 16-Apr-17.
 */

public class FormBuildHelper {

    private FormAdapter mFormAdapter;

    public FormBuildHelper(Context context, RecyclerView recyclerView) {

        // initialize form adapter
        this.mFormAdapter = new FormAdapter(context);

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
     * @param formElements
     */
    public void addFormElements(List<FormObject> formElements) {
        this.mFormAdapter.addElements(formElements);
    }

    /**
     * redraws the view
     */
    public void refreshView() {
        this.mFormAdapter.notifyDataSetChanged();
    }

    /**
     * get value of specific form element
     * @param tag
     * @return
     */
    public FormElement getFormElement(int tag) {
        return this.mFormAdapter.getValueAtTag(tag);
    }

    /**
     *
     * return true if the form is valid
     *
     * @return
     */
    public boolean isValidForm() {
        for (int i = 0; i < this.mFormAdapter.getItemCount(); i++) {
            FormElement formElement = this.mFormAdapter.getValueAtIndex(i);
            if (formElement.isRequired() & formElement.getValue() == null) {
                return false;
            }
        }
        return true;
    }

}