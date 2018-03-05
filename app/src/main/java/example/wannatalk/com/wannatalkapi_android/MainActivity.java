package example.wannatalk.com.wannatalkapi_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import wannatalk.wannatalksdk.WTCore.WTAppDataManager;
import wannatalk.wannatalksdk.WTCore.WTSDKConstants;

public class MainActivity extends AppCompatActivity {

    Button btn_org_profile;
    Button btn_sign_out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WTAppDataManager.InitializeSDK();

        btn_org_profile = (Button) findViewById(R.id.btn_org_profile);
        btn_sign_out = (Button) findViewById(R.id.btn_sign_out);

        btn_org_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadOrganizationProfile();
            }
        });

        btn_sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WTAppDataManager.Reset(null);
            }
        });
    }

    void loadOrganizationProfile() {
        WTAppDataManager.LoadOrganizationActivity(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == WTSDKConstants.RC_WANNATALK && resultCode == RESULT_OK) {

            loadOrganizationProfile();
        }
    }
}
