package me.riddhimanadib.fastformbuilder;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.riddhimanadib.formmaster.FormBuilder;
import me.riddhimanadib.formmaster.listener.OnActionListener;
import me.riddhimanadib.formmaster.listener.OnFormElementValueChangedListener;
import me.riddhimanadib.formmaster.model.BaseFormElement;
import me.riddhimanadib.formmaster.model.FormElementButton;
import me.riddhimanadib.formmaster.model.FormElementLabel;
import me.riddhimanadib.formmaster.model.FormElementPickerDate;
import me.riddhimanadib.formmaster.model.FormElementPickerMulti;
import me.riddhimanadib.formmaster.model.FormElementPickerSingle;
import me.riddhimanadib.formmaster.model.FormElementPickerTime;
import me.riddhimanadib.formmaster.model.FormElementSwitch;
import me.riddhimanadib.formmaster.model.FormElementTextEmail;
import me.riddhimanadib.formmaster.model.FormElementTextMultiLine;
import me.riddhimanadib.formmaster.model.FormElementTextNumber;
import me.riddhimanadib.formmaster.model.FormElementTextPassword;
import me.riddhimanadib.formmaster.model.FormElementTextPhone;
import me.riddhimanadib.formmaster.model.FormElementTextSingleLine;
import me.riddhimanadib.formmaster.model.FormHeader;

public class FormListenerActivity extends AppCompatActivity implements OnFormElementValueChangedListener, OnActionListener {

    private RecyclerView mRecyclerView;
    private FormBuilder mFormBuilder;

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
        mFormBuilder = new FormBuilder(this, mRecyclerView, this, this);

        FormHeader header1 = FormHeader.createInstance("Personal Info");
        FormElementTextEmail element11 = FormElementTextEmail.createInstance().setTitle("Email").setHint("Enter Email");
        FormElementTextPhone element12 = FormElementTextPhone.createInstance().setTitle("Phone").setValue("+8801712345678");

        FormHeader header2 = FormHeader.createInstance("Family Info");
        FormElementTextSingleLine element21 = FormElementTextSingleLine.createInstance().setTitle("Location").setValue("Dhaka");
        FormElementTextMultiLine element22 = FormElementTextMultiLine.createInstance().setTitle("Address");
        FormElementTextNumber element23 = FormElementTextNumber.createInstance().setTitle("Zip Code").setValue("1000");

        FormHeader header3 = FormHeader.createInstance("Schedule");
        FormElementPickerDate element31 = FormElementPickerDate.createInstance().setTitle("Date").setDateFormat("MMM dd, yyyy");
        FormElementPickerTime element32 = FormElementPickerTime.createInstance().setTitle("Time").setTimeFormat("KK hh");
        FormElementTextPassword element33 = FormElementTextPassword.createInstance().setTitle("Password").setValue("abcd1234");

        FormHeader header4 = FormHeader.createInstance("Preferred Items");
        List<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");
        fruits.add("Guava");
        FormElementPickerSingle element41 = FormElementPickerSingle.createInstance().setTitle("Single Item").setOptions(fruits).setPickerTitle("Pick any item");
        FormElementPickerMulti element42 = FormElementPickerMulti.createInstance().setTitle("Multi Items").setOptions(fruits).setPickerTitle("Pick one or more").setNegativeText("reset");
        FormElementSwitch element43 = FormElementSwitch.createInstance().setTitle("Frozen?").setSwitchTexts("Yes", "No");

        FormHeader header5 = FormHeader.createInstance("New Elements");
        FormElementLabel element51 = FormElementLabel.createInstance("Label");
        FormElementButton element52 = FormElementButton.createInstance("Action");

        List<BaseFormElement> formItems = new ArrayList<>();
        formItems.add(header1);
        formItems.add(element11);
        formItems.add(element12);
        formItems.add(header2);
        formItems.add(element21);
        formItems.add(element22);
        formItems.add(element23);
        formItems.add(header3);
        formItems.add(element31);
        formItems.add(element32);
        formItems.add(element33);
        formItems.add(header4);
        formItems.add(element41);
        formItems.add(element42);
        formItems.add(element43);
        formItems.add(header5);
        formItems.add(element51);
        formItems.add(element52);
        mFormBuilder.addFormElements(formItems);

    }

    @Override
    public void onValueChanged(BaseFormElement formElement) {
        Toast.makeText(this, formElement.getValue(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAction(BaseFormElement formElement) {
        Toast.makeText(this, formElement.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
