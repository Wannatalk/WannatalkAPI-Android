package example.wannatalk.com.wannatalkapi_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import wannatalk.wannatalksdk.WTCore.Interface.IWTLoginManager;
import wannatalk.wannatalksdk.WTCore.WTAppDataManager;
import wannatalk.wannatalksdk.WTCore.WTSDKConstants;
import wannatalk.wannatalksdk.WTLogin.WTLoginManager;

public class MainActivity extends AppCompatActivity {

    Button btn_org_profile;
    Button btn_login;
    Button btn_silent_login;
    Button btn_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WTAppDataManager.InitializeSDK();

        WTAppDataManager.ShowGuideButton(false);
        WTAppDataManager.ShowProfileInfoPage(false);
        WTAppDataManager.AllowAddParticipants(false);
        WTAppDataManager.AllowSendAudioMessage(false);
        WTAppDataManager.EnableAutoTickets(true);

        WTLoginManager.setIwtLoginManager(iwtLoginManager);

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_silent_login = (Button) findViewById(R.id.btn_silent_login);
        btn_org_profile = (Button) findViewById(R.id.btn_org_profile);
        btn_logout = (Button) findViewById(R.id.btn_logout);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        btn_silent_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                silentLogin();
            }
        });

        btn_org_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadOrganizationProfile();
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });


        updateButtons();
    }

    void login() {
//        Authentication
        WTAppDataManager.StartLoginActivity(this);
    }

    void silentLogin() {

//        Silent authentication without otp verification
        Bundle bundle = new Bundle();
        bundle.putString("key1", "value1");
        bundle.putString("key2", "value2");
        WTAppDataManager.SilentLoginActivity("your_phone_number", bundle, this);
    }


    void loadOrganizationProfile() {

//        Load organization profile
        WTAppDataManager.LoadOrganizationActivity(this, true);
    }

    void loadChatList() {

//        Load chat list
        WTAppDataManager.LoadChatListActivity(this);
    }

    void loadUsers() {

//        Load users
        WTAppDataManager.LoadUsersActivity(this);
    }

    void logout() {
        WTAppDataManager.Reset(this);
    }

    IWTLoginManager iwtLoginManager = new IWTLoginManager() {
        @Override
        public void wtsdkUserLoggedOut() {
            updateButtons();
        }

        @Override
        public void wtsdkUserLoggedIn() {
            updateButtons();
        }
    };

    void updateButtons() {

        boolean userLoggedIn = WTLoginManager.IsUserLoggedIn();
        if (userLoggedIn) {
            btn_login.setVisibility(View.GONE);
            btn_silent_login.setVisibility(View.GONE);
            btn_org_profile.setVisibility(View.VISIBLE);
            btn_logout.setVisibility(View.VISIBLE);
        }
        else {
            btn_login.setVisibility(View.VISIBLE);
            btn_silent_login.setVisibility(View.VISIBLE);
            btn_org_profile.setVisibility(View.GONE);
            btn_logout.setVisibility(View.GONE);
        }
    }
}
