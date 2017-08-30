package me.riddhimanadib.formmaster.helper;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import me.riddhimanadib.formmaster.adapter.FormAdapter;
import me.riddhimanadib.formmaster.listener.OnFormElementValueChangedListener;
import me.riddhimanadib.formmaster.model.FormElement;
import me.riddhimanadib.formmaster.model.FormHeader;
import me.riddhimanadib.formmaster.model.FormObject;
import me.riddhimanadib.formmaster.model.JSONFormElement;

/** Wrapper class around the adapter to assist in building form
 * Created by Adib on 16-Apr-17.
 */

public class FormBuildHelper {

    private FormAdapter mFormAdapter;

    /**
     * constructor without listener callback for changed values
     * @param context
     * @param recyclerView
     */
    public FormBuildHelper(Context context, RecyclerView recyclerView) {
        initializeFormBuildHelper(context, recyclerView, null);
    }

    /**
     * constructor with listener callback for changed values
     * @param context
     * @param recyclerView
     */
    public FormBuildHelper(Context context, RecyclerView recyclerView, OnFormElementValueChangedListener listener) {
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
            if (formElement.isHeader() == false & formElement.isRequired() & formElement.getValue().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Creates elements from the information contained in the JSON file.
     * @param jsonString
     * @throws IOException
     * @throws JSONException
     */
    public void createFromJson(String jsonString) throws IOException, JSONException {
        if(!jsonString.trim().isEmpty()){
            JSONObject mainObject = new JSONObject(jsonString);
            JSONArray elementsArray = mainObject.getJSONArray("elements");

            List<FormObject> formItems = new ArrayList<>();
            Gson gson = new Gson();
            Type type = new TypeToken<List<JSONFormElement>>(){}.getType();
            List<JSONFormElement> elementsList = gson.fromJson(elementsArray.toString(), type);
            for (JSONFormElement formElement : elementsList){
                switch (formElement.type)
                {
                    case 0:
                    {
                        FormHeader headerForm = FormHeader.createInstance()
                                .setTitle(formElement.title);
                        formItems.add(headerForm);
                    }
                    break;
                    case FormElement.TYPE_EDITTEXT_TEXT_SINGLELINE:
                    case FormElement.TYPE_EDITTEXT_TEXT_MULTILINE:
                    case FormElement.TYPE_EDITTEXT_NUMBER:
                    case FormElement.TYPE_EDITTEXT_EMAIL:
                    case FormElement.TYPE_EDITTEXT_PHONE:
                    case FormElement.TYPE_PICKER_DATE:
                    case FormElement.TYPE_PICKER_TIME:
                    case FormElement.TYPE_EDITTEXT_PASSWORD:
                    {
                        FormElement elementForm = FormElement.createInstance()
                                .setTag(formElement.tag)
                                .setType(formElement.type)
                                .setTitle(formElement.title)
                                .setValue(formElement.value)
                                .setHint(formElement.hint)
                                .setRequired(formElement.required);
                        formItems.add(elementForm);
                    }
                    break;
                    case FormElement.TYPE_SPINNER_DROPDOWN:
                    {
                        FormElement elementForm = FormElement.createInstance()
                                .setTag(formElement.tag)
                                .setType(formElement.type)
                                .setTitle(formElement.title)
                                .setValue(formElement.value)
                                .setOptions(formElement.options)
                                .setAlertTitle(formElement.alertTitle)
                                .setHint(formElement.hint)
                                .setRequired(formElement.required);
                        formItems.add(elementForm);
                    }
                    break;
                    case FormElement.TYPE_PICKER_MULTI_CHECKBOX:
                    {
                        FormElement elementForm = FormElement.createInstance()
                                .setTag(formElement.tag)
                                .setType(formElement.type)
                                .setTitle(formElement.title)
                                .setValue(formElement.value)
                                .setOptions(formElement.options)
                                .setAlertTitle(formElement.alertTitle)
                                .setPositiveButtonText(formElement.positiveText)
                                .setNegativeButtonText(formElement.negativeText)
                                .setHint(formElement.hint)
                                .setRequired(formElement.required);
                        formItems.add(elementForm);
                    }
                    break;
                }
            }

            this.addFormElements(formItems);
        }
    }

}
