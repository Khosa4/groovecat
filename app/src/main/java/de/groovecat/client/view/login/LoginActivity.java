package de.groovecat.client.view.login;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.FacebookSdk;

import org.androidannotations.annotations.EActivity;

import de.groovecat.client.R;
import de.groovecat.client.common.ToolbarActivity;

/**
 * Created by mgerc on 26.10.2016.
 */

@EActivity(R.layout.activity_login)
public class LoginActivity extends GoogleLoginActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        FacebookSdk.sdkInitialize(this);
        super.onCreate(savedInstanceState, persistentState);
    }

}
