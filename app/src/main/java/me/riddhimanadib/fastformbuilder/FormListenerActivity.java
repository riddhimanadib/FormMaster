package me.riddhimanadib.fastformbuilder;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.riddhimanadib.formmaster.helper.FormBuildHelper;
import me.riddhimanadib.formmaster.listener.OnFormElementValueChangedListener;
import me.riddhimanadib.formmaster.model.FormElement;
import me.riddhimanadib.formmaster.model.FormObject;

public class FormListenerActivity extends AppCompatActivity implements OnFormElementValueChangedListener {

    enum Fruit {
        BANANA, ORANGE, MANGO, GUAVA;

        public String toString() {
            switch (this) {
                case BANANA:
                    return "Banana";
                case ORANGE:
                    return "Orange";
                case MANGO:
                    return "Mango";
                case GUAVA:
                    return "Guava";
            }

            return "";
        }
    }

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
        FormElement element31 = FormElement.createInstance().setType(FormElement.TYPE_PICKER_DATE).setTitle("Date");
        FormElement element32 = FormElement.createInstance().setType(FormElement.TYPE_PICKER_TIME).setTitle("Time");
        FormElement element33 = FormElement.createInstance().setType(FormElement.TYPE_EDITTEXT_PASSWORD).setTitle("Password").setValue("abcd1234");

        List<String> fruitStrings = new ArrayList<>();
        fruitStrings.add("Banana");
        fruitStrings.add("Orange");
        fruitStrings.add("Mango");
        fruitStrings.add("Guava");

        List<Fruit> fruitEnums = new ArrayList<>();
        fruitEnums.add(Fruit.BANANA);
        fruitEnums.add(Fruit.ORANGE);
        fruitEnums.add(Fruit.MANGO);
        fruitEnums.add(Fruit.GUAVA);

        FormElement element41 = FormElement.<Fruit>createGenericInstance().setType(FormElement.TYPE_SPINNER_DROPDOWN).setTitle("Single Item").setOptions(fruitEnums);
        FormElement element42 = FormElement.createInstance().setType(FormElement.TYPE_PICKER_MULTI_CHECKBOX).setTitle("Multi Items").setOptions(fruitStrings);

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
        Toast.makeText(this, formElement.getValue().toString(), Toast.LENGTH_SHORT).show();
    }
}
