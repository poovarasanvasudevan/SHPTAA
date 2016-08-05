package in.shpt.preference;

import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Created by poovarasanv on 5/8/16.
 */
@SharedPref
public interface SHPTPreferences {

    boolean isInternetAvailable();
}
