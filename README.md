# WannatalkAPI-Android
The official Wannatalk Messenger Android API
## To run sample example
1. Request **wannatalk-services.json** from wannatalk.co

2. Copy **wannatalk-services.json** file to sample application `assets` directory
<img src="Screenshots/Screenshot1.png" width="350">

3. That's it! Run the app

## Steps to integrate wannatalk library into your project

1. Download [wannatalk.aar](wannatalksdk/wannatalksdk.aar) and import into your application
2. Enable `multiDexEnabled` and add below `dependencies` in your application **build.gradle**
```
android {
	defaultConfig {
	    // Enabling multidex support.
	    multiDexEnabled true
	}
	...
}

dependencies 
{
	compile 'com.android.support:design:25.3.1'
	compile 'com.android.support:multidex:1.0.0'
	compile project(':wannatalksdk')  
	compile 'commons-io:commons-io:2.4'  
  
	compile 'com.github.bumptech.glide:glide:3.7.0'  
	compile 'jp.wasabeef:glide-transformations:2.0.1'  
  
	compile 'com.facebook.fresco:fresco:1.5.0'  
	compile 'com.facebook.fresco:animated-gif:1.5.0'  
	compile "com.android.support:support-core-utils:25.3.1"
	compile "com.android.support:customtabs:25.3.1"
	compile 'com.amazonaws:aws-android-sdk-core:2.6.7'
	compile 'com.amazonaws:aws-android-sdk-s3:2.6.7'

  	compile 'com.google.guava:guava:23.0-android'  
	compile 'me.saket:better-link-movement-method:1.2'  
	compile 'com.arasthel:asyncjob-library:1.0.3'  
  
	compile 'com.squareup:otto:1.3.8'  
	compile 'com.squareup.retrofit2:retrofit:2.3.0'  
	compile 'com.squareup.retrofit2:converter-gson:2.0.2'  
	compile 'com.google.code.gson:gson:2.8.2'
}
``` 
3. Edit your manifest file to set android:name in the tag as follows:
```
<application		
		android:name="wannatalk.wannatalksdk.WTApplication">
		...
</application>
```
4. Copy  **wannatalk-services.json** file to your application assets directory
5. Add below line in **onCreate** function of your main activity
```
WTSDKManager.InitializeSDK();
```
## To link Wannatalk account
    WTLoginManager.StartLoginActivity(this);

## To link Wannatalk account with user credentials
    Bundle bundle = new Bundle();
    bundle.putString("key1", "value1");
    bundle.putString("key2", "value2");
    WTLoginManager.SilentLoginActivity("<identifier>", bundle, this);
    
## To unlink Wannatalk account
    WTLoginManager.Logout(this);
    
## HelpDesk
### To load your organization profile
    // LoadOrganizationActivity(Activity activity, boolean autoOpenChat)
    // Recent chat page will be opened when click on channel if autoOpenChat is true, otherwise chat list page will be opened.
    
    WTSDKManager.LoadOrganizationActivity(this, true);
    
## Collaboration
### To view all chats
    WTSDKManager.LoadChatListActivity(this);
    
### To view all users
    WTSDKManager.LoadUsersActivity(this);

## Push notifications
1. Create android app in Firebase console
2. Download google-services.json configuration file and move it into the same directory as your root-level build.gradle file. 
3. Share us your Firebase project server key. You will find it in Cloud messaging tab of your Firebase project settings.(Open project in Firebase > Project Settings > Cloud Messaging)

## Other
### To show or hide guide button
    WTSDKManager.ShowGuideButton(false);               // default = YES

### To enable or disable sending audio message
    WTSDKManager.AllowSendAudioMessage(false);  // default = YES

### To show or hide add participants option in new ticket page and chat item profile page
    WTSDKManager.AllowAddParticipants(false);    // default = YES

### To show or hide remove participants option in chat item profile
    WTSDKManager.AllowRemoveParticipants(false); // default = NO

### To show or hide welcome message
    WTSDKManager.ShowWelcomeMessage(false);            // default = NO

### To show or hide Profile Info page
    WTSDKManager.ShowProfileInfoPage(false);           // default = YES

### To create auto tickets: 
Chat ticket will create automatically when auto tickets is enabled, otherwise default ticket creation page will popup

    WTSDKManager.EnableAutoTickets(true);           // default = NO

### To show or hide close chat button in chat page
    WTSDKManager.ShowExitButton(true);               // default = NO

### To show or hide participants in chat profile page
    WTSDKManager.ShowChatParticipants(false);          // default = YES

### To enable or disbale chat profile page
    WTSDKManager.EnableChatProfile(false);           // default = YES

### To allow modify in chat profile page
    WTSDKManager.AllowModifyChatProfile(false);       // default = YES

### To set Inactive chat timeout:  
Chat session will end if user is inactive for timeout interval duration. If timeout interval is 0, chat session will not end automatically. The default timout interval is 1800 seconds (30 minutes).

    long timeoutInterval = 1800; // Default Value: 1800 seconds ~ 30 minutes
    WTSDKManager.SetInactiveChatTimeoutInterval(timeoutInterval);



