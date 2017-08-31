package me.riddhimanadib.fastformbuilder;

/**
 * Created by Nestor Islas on 30/08/2017.
 */

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import org.json.JSONException;

import java.io.IOException;

import me.riddhimanadib.formmaster.helper.FormBuildHelper;

public class JSONFormActivity extends AppCompatActivity {

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
        mFormBuilder = new FormBuildHelper(this, mRecyclerView);

        try {
            mFormBuilder.createFromJson("{\"elements\":[{\"type\":0,\"title\":\"Personal Info\"},{\"type\":4,\"title\":\"Email\",\"hint\":\"Enter Email\"},{\"type\":5,\"title\":\"Phone\",\"value\":\"+8801712345678\"},{\"type\":0,\"title\":\"Family Info\"},{\"type\":1,\"title\":\"Location\",\"value\":\"Dhaka\"},{\"type\":2,\"title\":\"Address\"},{\"type\":3,\"title\":\"Zip Code\",\"value\":\"1000\"},{\"type\":0,\"title\":\"Schedule\"},{\"type\":6,\"title\":\"Date\"},{\"type\":7,\"title\":\"Time\"},{\"type\":10,\"title\":\"Password\",\"value\":\"abcd1234\"},{\"type\":0,\"title\":\"Preferred Items\"},{\"type\":8,\"title\":\"Single Item\",\"alertTitle\":\"Pick one\",\"options\":[\"Banana\",\"Orange\",\"Mango\",\"Guava\"]},{\"type\":9,\"title\":\"Multi Items\",\"alertTitle\":\"Pick one or more\",\"positiveText\":\"Okay\",\"negativeText\":\"Cancel\",\"options\":[\"Banana\",\"Orange\",\"Mango\",\"Guava\"]}]}");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mFormBuilder.refreshView();

    }
}
