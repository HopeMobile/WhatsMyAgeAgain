package davidhope.whatsmyageagain.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import davidhope.whatsmyageagain.R;


public class StartingActivity extends ActionBarActivity {

    private static final String TAG = StartingActivity.class.getSimpleName();

    protected String maleGender;
    protected String femaleGender;

    public String mUsersName;
    public int mAgeOfUser;

    @InjectView(R.id.nameHolder) EditText mNameSelectorView;
    @InjectView(R.id.ageHolder) EditText mAgeSelectorView;
    @InjectView(R.id.startButton) Button mStartButton;
    @InjectView(R.id.genderSelector) Spinner mGenderChooserSpinner;


    protected boolean isNameEmpty() {
        if (mNameSelectorView.getText().length()  <= 1) {

            Log.e(TAG, getString(R.string.empty_name_field_message));
       }

        return mNameSelectorView.getText().toString().isEmpty();
    }

    protected boolean isAgeEmpty() {
        if (mAgeSelectorView.getText().length() <= 1 ) {

            Log.e(TAG, getString(R.string.empty_age_field_message));
        }

        return mAgeSelectorView.getText().toString().isEmpty();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        ButterKnife.inject(this);


        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gender_selector_choices,
                R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        mGenderChooserSpinner.setAdapter(adapter);

        // TODO: Set theme for Second and Third Activities based on Gender choice from Spinner;

        //TODO: Move Spinner choices into getters and setters inside UserData class.
        mGenderChooserSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //TODO: Move booleans for checking Gender selection into UserData Class.
                if(mGenderChooserSpinner.getSelectedItem().toString().equals("male")) {

                    maleGender =  mGenderChooserSpinner.getSelectedItem().toString();

                    Toast.makeText(StartingActivity.this, maleGender, Toast.LENGTH_LONG).show();
                }

                else  {
                    femaleGender =  mGenderChooserSpinner.getSelectedItem().toString();

                    Toast.makeText(StartingActivity.this, femaleGender, Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        mStartButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


               if (!isNameEmpty() && !isAgeEmpty()){
                    mUsersName = mNameSelectorView.getText().toString();
                    mAgeOfUser = Integer.parseInt(mAgeSelectorView.getText().toString());
                    Intent intent = new Intent(StartingActivity.this, AgeCalculatorActivity.class);
                    intent.putExtra(getString(R.string.key_username), mUsersName);
                    intent.putExtra(getString(R.string.key_age), mAgeOfUser);
                     if (!femaleGender.isEmpty()) {
                       intent.putExtra(getString(R.string.key_gender), femaleGender);

                     }
                     else {

                       intent.putExtra(getString(R.string.key_gender), maleGender);
                     }

                    startActivity(intent);
                }

                else {

                   if (isNameEmpty()) {

                       Toast.makeText(StartingActivity.this, getString(R.string.empty_name_field_message), Toast.LENGTH_LONG).show();
                   }
                   if (isAgeEmpty()) {
                       Toast.makeText(StartingActivity.this, getString(R.string.empty_age_field_message), Toast.LENGTH_LONG).show();
                   }

                }

            }
        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_starting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
