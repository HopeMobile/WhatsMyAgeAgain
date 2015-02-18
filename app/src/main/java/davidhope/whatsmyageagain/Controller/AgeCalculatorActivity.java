package davidhope.whatsmyageagain.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import davidhope.whatsmyageagain.Model.GenderColor;
import davidhope.whatsmyageagain.Model.UserData;
import davidhope.whatsmyageagain.R;

public class AgeCalculatorActivity extends ActionBarActivity {

    private static final String TAG = AgeCalculatorActivity.class.getSimpleName();

    protected String mGenderOfUser;
    protected String mMaleGender;
    protected String mFemaleGender;

    @InjectView(R.id.usersName) TextView mUsersName;
    @InjectView(R.id.ageCalculatorOpeningTitle) TextView mOpeningTitle;
    @InjectView(R.id.age_in_days) TextView mAgeInDaysView;
    @InjectView(R.id.days_label) TextView mDaysLabel;
    @InjectView(R.id.age_in_weeks) TextView mAgeInWeeksView;
    @InjectView(R.id.ageInWeeksLabel) TextView mWeeksLabel;
    @InjectView(R.id.ageOfUserInDogYears) TextView mAgeInDogYearsView;
    @InjectView(R.id.dogYearsLabel) TextView mDogYearsLabel;
    @InjectView(R.id.startThirdActivityButton) Button mStartThirdActivityButton;
    @InjectView(R.id.backToHomeButton) Button mBackToHomeButton;

    /*  protected boolean whatGender() {


        else {
            Toast.makeText(AgeCalculatorActivity.this, "The boolean is not working as intended", Toast.LENGTH_LONG).show();
        }

        return true;
    } */


  /*  boolean whatName()  {
        if (mGenderOfUser.equals("male")) {
            new GenderColor().onActivitySetTheme(AgeCalculatorActivity.this);
            Toast.makeText(AgeCalculatorActivity.this, getString(R.string.gender_male), Toast.LENGTH_LONG).show();
        }

        else if (mGenderOfUser.equals("female"))  {
            new GenderColor().onActivitySetTheme(AgeCalculatorActivity.this);
            Toast.makeText(AgeCalculatorActivity.this, getString(R.string.gender_female), Toast.LENGTH_LONG).show();

        }
      return true;
    } */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String userName = intent.getStringExtra(getString(R.string.key_username));
        int ageOfUser = intent.getIntExtra(getString(R.string.key_age), 0);
        mGenderOfUser = intent.getStringExtra(getString(R.string.key_gender));

        Toast.makeText(AgeCalculatorActivity.this, mGenderOfUser, Toast.LENGTH_LONG).show();

         if (mGenderOfUser.matches("Male")){
            mMaleGender = mGenderOfUser;
            GenderColor.onActivitySetTheme(AgeCalculatorActivity.this);
            setTheme(R.style.MaleTheme);
           }

           else if (mGenderOfUser.matches("Female")) {
                mFemaleGender = mGenderOfUser;
                GenderColor.onActivitySetTheme(AgeCalculatorActivity.this);
                setTheme(R.style.FemaleTheme);
           }

           else {
                GenderColor.genderTheme(AgeCalculatorActivity.this, R.style.AppTheme);
           }

        GenderColor.onActivitySetTheme(this);
        setContentView(R.layout.activity_age_calculator);
        ButterKnife.inject(this);
        //Show gender selected as age of user.


        if (userName == null) {
            Toast.makeText(AgeCalculatorActivity.this, getString(R.string.empty_name_field_message), Toast.LENGTH_LONG).show();
        }




        mUsersName.setText(userName);
        // Use constructor for UserData to handle data and its ageCalculator() to get Users Age in Days;
        String ageInDays = " " + new UserData().ageDaysCalculator(ageOfUser);
        String ageInWeeks = "" + new UserData().ageWeeksCalculator(ageOfUser);
        String ageInDogYears = "" + new UserData().ageDogYearsCalculator(ageOfUser);



        mAgeInDaysView.setText(ageInDays);
        mAgeInWeeksView.setText(ageInWeeks);
        mAgeInDogYearsView.setText(ageInDogYears);

        //Toast.makeText(AgeCalculatorActivity.this, userName, Toast.LENGTH_LONG).show();
              //intent.getExtras();

        mBackToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToMainIntent = new Intent(AgeCalculatorActivity.this, StartingActivity.class);
                backToMainIntent.setAction(Intent.ACTION_SEND);
                startActivity(backToMainIntent);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_age_calculator, menu);
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
