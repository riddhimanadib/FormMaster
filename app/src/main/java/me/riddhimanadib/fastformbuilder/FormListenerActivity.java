package me.riddhimanadib.fastformbuilder;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.riddhimanadib.formmaster.helper.FormBuildHelper;
import me.riddhimanadib.formmaster.listener.OnFormElementValueChangedListener;
import me.riddhimanadib.formmaster.model.FormElement;
import me.riddhimanadib.formmaster.model.FormHeader;
import me.riddhimanadib.formmaster.model.FormObject;

public class FormListenerActivity extends AppCompatActivity implements OnFormElementValueChangedListener {

    private RecyclerView mRecyclerView;
    private FormBuildHelper mFormBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_form);

        setupToolBar();

        setupForm();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupToolBar() {

        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

    }

    private void setupForm() {

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mFormBuilder = new FormBuildHelper(this, mRecyclerView, this);

        FormElement element11 = FormElement.createInstance().setType(FormElement.TYPE_EDITTEXT_EMAIL).setTitle("Email").setHint("Enter Email");
        FormElement element12 = FormElement.createInstance().setType(FormElement.TYPE_EDITTEXT_PHONE).setTitle("Phone").setValue("+8801712345678");
        FormElement element21 = FormElement.createInstance().setType(FormElement.TYPE_EDITTEXT_TEXT_SINGLELINE).setTitle("Location").setValue("Dhaka");
        FormElement element22 = FormElement.createInstance().setType(FormElement.TYPE_EDITTEXT_TEXT_MULTILINE).setTitle("Address");
        FormElement element23 = FormElement.createInstance().setType(FormElement.TYPE_EDITTEXT_NUMBER).setTitle("Zip Code").setValue("1000");

        FormElement element31 = FormElement.createInstance()
                .setType(FormElement.TYPE_PICKER_DATE)
                .setDatePickerType(FormElement.DATEPICKER_TH)
                .setDatePickerTheme(FormElement.THEME1)
                .setDatePickerTitle("Title")
                .setTitle("Date");

        FormElement element32 = FormElement.createInstance().setType(FormElement.TYPE_PICKER_TIME).setTitle("Time");
        FormElement element33 = FormElement.createInstance().setType(FormElement.TYPE_EDITTEXT_PASSWORD).setTitle("Password").setValue("abcd1234");
        List<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");
        fruits.add("Guava");
        FormElement element41 = FormElement.createInstance()
                .setType(FormElement.TYPE_SPINNER_DROPDOWN)
                .setTitle("Single Item")
                .setDropdownTitle("Pick one")
                .setOptions(fruits);

        FormElement element42 = FormElement.createInstance()
                .setType(FormElement.TYPE_PICKER_MULTI_CHECKBOX)
                .setTitle("Multi Items")
                .setCheckboxTitle("Pick one or more")
                .setOptions(fruits);

        List<FormObject> formItems = new ArrayList<>();
        formItems.add(element11);
        formItems.add(element12);
        formItems.add(element21);
        formItems.add(element22);
        formItems.add(element23);
        formItems.add(element31);
        formItems.add(element32);
        formItems.add(element33);
        formItems.add(element41);
        formItems.add(element42);

        mFormBuilder.addFormElements(formItems);
        mFormBuilder.refreshView();

    }

    @Override
    public void onValueChanged(FormElement formElement) {
        Toast.makeText(this, formElement.getValue(), Toast.LENGTH_SHORT).show();
    }
}
