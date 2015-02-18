package davidhope.whatsmyageagain.Model;

import android.app.Activity;
import android.content.Intent;

import davidhope.whatsmyageagain.R;

/**
 * Created by David on 2/16/2015.
 */
public class GenderColor extends UserData {

 public static int sTheme;

 public static final int APP_THEME = 0;

 public static final int MALE_THEME = 1;

 public static final int FEMALE_THEME = 2;

    //TODO: Modify method example from CodePath to change theme based...
    // TODO: ...on data passed from StartingActivity to AgeCalculatorActivity

    public static void genderTheme(Activity activity, int theme) {
      sTheme = theme;
      activity.finish();
      activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void onActivitySetTheme(Activity activity) {
        switch (sTheme) {
            default:
            case APP_THEME:
                activity.setTheme(R.style.AppTheme);
                break;
            case MALE_THEME:
                activity.setTheme(R.style.MaleTheme);
                break;
            case FEMALE_THEME:

        }
    }

  //  String maleGenderSelected;
  //  String femaleGenderSelected;
   /*  public boolean genderColorSetter() {
         if(isGenderMale()) {

         }
     } */
}
