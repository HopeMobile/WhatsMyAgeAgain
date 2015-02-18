package davidhope.whatsmyageagain.Model;

import android.widget.Spinner;

/**
 * Created by David on 2/3/2015.
 */
public class UserData {

    public static final String TAG = UserData.class.getSimpleName();

    private String usersName;
    private int ageOfUser;
    private String genderOfUser;
    private Spinner genderSpinner;
    private boolean isNameEmpty;
    private boolean isAgeInRange;
    private boolean isGenderMale;
    public  boolean isGenderFemale;
    private int ageOfUserInDays;
    private int ageOfUserInWeeks;
    private int ageOfUserInDogYears;

    public boolean isGenderFemale() {
        return isGenderFemale;
    }

    public void setGenderFemale(boolean isGenderFemale) {
        this.isGenderFemale = isGenderFemale;
    }

    public boolean isGenderMale() {
        return isGenderMale;
    }

    public void setGenderMale(boolean isGenderMale) {
        this.isGenderMale = isGenderMale;
    }

    public Spinner getGenderSpinner() {
        return genderSpinner;
    }

    public void setGenderSpinner(Spinner genderSpinner) {
        this.genderSpinner = genderSpinner;
    }

    public int getAgeOfUserInDays() {
        return ageOfUserInDays;
    }

    public void setAgeOfUserInDays(int ageOfUserInDays) {
        this.ageOfUserInDays = ageOfUserInDays;
    }



 /*   public boolean spinnerChoice(Spinner spinner, String s, Class<AgeCalculatorActivity> activity) {
        if(spinner.getSelectedItem().toString().equals("male")) {
            Log.v(TAG, "Gender selected was male");
        }
        else if (spinner.getSelectedItem().toString().equals("female")) {
            Log.e(TAG, "Female gender selected");
        }
        return true;
    } */

   // String mUsersName, int mAgeOfUser, String genderOfUser
    public UserData() {

       // this.mUsersName = mUsersName;
       // this.mAgeOfUser = mAgeOfUser;
       // this.genderOfUser = genderOfUser;
    }

   /* public int genderThemeChooser(String genderOfUser) {
        if(isGenderMale()) {
            Log.v(TAG, "Male genderSelected");
        }


    } */

   /*   protected boolean isMaleSelected() {
        if (mGenderChooserSpinner.getSelectedItem().equals("male")) {
          mNameSelectorView.setTextColor(R.style.male_gender_selection);
        }
       return true;
    } */

    public boolean isFemaleSelected(String genderSelected) {
        boolean isGenderFemale;
        if (genderSelected.equals("female")) {
           isGenderFemale = true;
           String textColor = genderSelected;

        }
        return true;
    }

  /*  public boolean genderSelected(String genderOfUser) {
        if (genderOfUser.equals("male")) {

        }
    }  */


    public int ageDaysCalculator(int ageInDays) {
        int daysOldCalculator = ageInDays * 365;
        ageOfUserInDays = daysOldCalculator;

        return ageOfUserInDays;
    }

    public int ageWeeksCalculator(int ageInWeeks) {
        int weeksOldCalculator = ageInWeeks * 52;

        ageOfUserInWeeks = weeksOldCalculator;

        return ageOfUserInWeeks;
    }

    public int ageDogYearsCalculator(int ageInDogYears) {
        int dogYearsCalculator = ageInDogYears * 7;

        ageOfUserInDogYears = dogYearsCalculator;

        return ageOfUserInDogYears;
    }


    public int getAgeOfUserInWeeks() {
        return ageOfUserInWeeks;
    }

    public void setAgeOfUserInWeeks(int ageOfUserInWeeks) {
        this.ageOfUserInWeeks = ageOfUserInWeeks;
    }

    public int getAgeOfUserInDogYears() {
        return ageOfUserInDogYears;
    }

    public void setAgeOfUserInDogYears(int ageOfUserInDogYears) {
        this.ageOfUserInDogYears = ageOfUserInDogYears;
    }


    public boolean isNameEmpty() {
        return isNameEmpty;
    }

    public void setNameEmpty(boolean isNameEmpty) {
        this.isNameEmpty = isNameEmpty;
    }

    public boolean isAgeInRange() {
        return isAgeInRange;
    }

    public void setAgeInRange(boolean isAgeInRange) {
        this.isAgeInRange = isAgeInRange;
    }


    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public int getAgeOfUser() {
        return ageOfUser;
    }

    public void setAgeOfUser(int ageOfUser) {
        this.ageOfUser = ageOfUser;
    }

    public String getGenderOfUser() {
        return genderOfUser;
    }

    public void setGenderOfUser(String genderOfUser) {
        this.genderOfUser = genderOfUser;
    }

}
