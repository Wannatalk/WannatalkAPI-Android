package example.wannatalk.com.wannatalkapi_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import wannatalk.wannatalksdk.WTCore.Interface.IWTLoginManager;
import wannatalk.wannatalksdk.WTCore.WTSDKManager;
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

        WTSDKManager.InitializeSDK();

        WTSDKManager.ShowGuideButton(false);
        WTSDKManager.ShowProfileInfoPage(false);
        WTSDKManager.AllowAddParticipants(false);
        WTSDKManager.AllowSendAudioMessage(false);
        WTSDKManager.EnableAutoTickets(true);

        WTLoginManager.setIwtLoginManager(iwtLoginManager);


        WTSDKManager.ShowExitButton(true);
        WTSDKManager.EnableChatProfile(false);

//        WTSDKManager.SetInactiveChatTimeoutInterval(1800);


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
        WTLoginManager.StartLoginActivity(this);
    }

    void silentLogin() {

//        Silent authentication without otp verification
        Bundle bundle = new Bundle();
        bundle.putString("key1", "value1");
        bundle.putString("key2", "value2");
        WTLoginManager.SilentLoginActivity("<identifier>", bundle, this);
    }


    void loadOrganizationProfile() {

//        Load organization profile
        WTSDKManager.LoadOrganizationActivity(this, true);
    }

    void loadChatList() {

//        Load chat list
        WTSDKManager.LoadChatListActivity(this);
    }

    void loadUsers() {

//        Load users
        WTSDKManager.LoadUsersActivity(this);
    }

    void logout() {
        WTLoginManager.Logout(this);
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
