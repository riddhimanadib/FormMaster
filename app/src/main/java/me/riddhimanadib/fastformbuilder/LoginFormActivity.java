package me.riddhimanadib.fastformbuilder;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.riddhimanadib.formmaster.helper.FormBuildHelper;
import me.riddhimanadib.formmaster.model.BaseFormElement;
import me.riddhimanadib.formmaster.model.FormElementTextEmail;
import me.riddhimanadib.formmaster.model.FormElementTextPassword;

public class LoginFormActivity extends AppCompatActivity {

    private static final int TAG_EMAIL = 12;
    private static final int TAG_PASSWORD = 2234;

    private RecyclerView mRecyclerView;
    private FormBuildHelper mFormBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        setupToolBar();

        setupForm();

        (findViewById(R.id.buttonLogin)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFormBuilder.isValidForm()) {
                    BaseFormElement loginElement = mFormBuilder.getFormElement(TAG_EMAIL);
                    BaseFormElement passwordElement = mFormBuilder.getFormElement(TAG_PASSWORD);
                    Toast.makeText(LoginFormActivity.this, "Do whatever you want with this data\n" + loginElement.getValue() + "\n" + passwordElement.getValue(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginFormActivity.this, "Invalid form data", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
        mFormBuilder = new FormBuildHelper(this, mRecyclerView);

        FormElementTextEmail element1 = FormElementTextEmail.createInstance().setTag(TAG_EMAIL).setTitle("Email").setRequired(true);
        FormElementTextPassword element2 = FormElementTextPassword.createInstance().setTag(TAG_PASSWORD).setTitle("Password").setRequired(true);

        List<BaseFormElement> formItems = new ArrayList<>();
        formItems.add(element1);
        formItems.add(element2);

        mFormBuilder.addFormElements(formItems);
        mFormBuilder.refreshView();

    }
}
